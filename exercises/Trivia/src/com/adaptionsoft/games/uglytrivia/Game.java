package com.adaptionsoft.games.uglytrivia;

public class Game {
	Questions questions = new Questions();
	Players players = new Players();
	boolean isGettingOutOfPenaltyBox;
	private boolean gameContinue;

	public Game() {
	}

	protected void print(Object obj) {
		System.out.println(obj);
	}

	public boolean isPlayable() {
		return (players.howManyPlayers() >= 2);
	}

	public void add(String playerName) {
		players.addPlayer(playerName);

		print(playerName + " was added");
		print("They are player number " + players.howManyPlayers());
	}

	public void roll(int roll) {
		print(players.getCurrentPlayerName() + " is the current player");
		print("They have rolled a " + roll);

		if (players.currentPlayerInPenaltyBox()) {
			isGettingOutOfPenaltyBox = roll % 2 != 0;
			if (!isGettingOutOfPenaltyBox) {
				print(players.getCurrentPlayerName()
						+ " is not getting out of the penalty box");
				return;
			}
			print(players.getCurrentPlayerName()
					+ " is getting out of the penalty box");
		}
		players.currentPlayerRolls(roll);
		reportNewQuestion();

	}

	void reportNewQuestion() {
		print(players.getCurrentPlayerName() + "'s new location is "
				+ players.getPlaceOfCurrentPlayer());
		print("The category is " + players.currentCategory());
		print(questions.getQuestion(players.currentCategory()));
	}

	public void wasCorrectlyAnswered() {
		this.gameContinue = currentPlayerAnswerRight();
		players.nextPlayer();
	}

	boolean currentPlayerAnswerRight() {
		if (players.currentPlayerInPenaltyBox()) {
			if (!isGettingOutOfPenaltyBox) {
				return true;
			}
		}
		print("Answer was corrent!!!!");
		players.currentPlayerAnswerRight();
		print(players.getCurrentPlayerName() + " now has "
				+ players.getCurentPlayerPurse() + " Gold Coins.");
		return players.didCurrentPlayerWin();
	}

	public void wrongAnswer() {
		print("Question was incorrectly answered");
		print(players.getCurrentPlayerName() + " was sent to the penalty box");
		players.sendCurrentPlayerToPenaltyBox();
		players.nextPlayer();
		this.gameContinue = true;
	}

	public boolean isGameContinue() {
		return gameContinue;
	}

}
