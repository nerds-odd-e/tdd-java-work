package com.adaptionsoft.games.uglytrivia;

public class Game {
	Questions questions = new Questions();
	Players players = new Players();
	boolean isGettingOutOfPenaltyBox;

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
				+ players.places[players.currentPlayer]);
		print("The category is " + players.currentCategory());
		askQuestion();
	}

	private void askQuestion() {
		print(questions.getQuestion(players.currentCategory()));
	}

	public boolean wasCorrectlyAnswered() {
		if (players.currentPlayerInPenaltyBox()) {
			if (isGettingOutOfPenaltyBox) {
				print("Answer was correct!!!!");
				players.purses[players.currentPlayer]++;
				print(players.getCurrentPlayerName() + " now has "
						+ players.purses[players.currentPlayer]
						+ " Gold Coins.");

				boolean winner = didPlayerWin();
				players.currentPlayer++;
				if (players.currentPlayer == players.players.size())
					players.currentPlayer = 0;

				return winner;
			} else {
				players.currentPlayer++;
				if (players.currentPlayer == players.players.size())
					players.currentPlayer = 0;
				return true;
			}

		} else {

			print("Answer was corrent!!!!");
			players.purses[players.currentPlayer]++;
			print(players.getCurrentPlayerName() + " now has "
					+ players.purses[players.currentPlayer] + " Gold Coins.");

			boolean winner = didPlayerWin();
			players.currentPlayer++;
			if (players.currentPlayer == players.players.size())
				players.currentPlayer = 0;

			return winner;
		}
	}

	public boolean wrongAnswer() {
		print("Question was incorrectly answered");
		print(players.getCurrentPlayerName() + " was sent to the penalty box");
		players.inPenaltyBox[players.currentPlayer] = true;

		players.currentPlayer++;
		if (players.currentPlayer == players.players.size())
			players.currentPlayer = 0;
		return true;
	}

	private boolean didPlayerWin() {
		return !(players.purses[players.currentPlayer] == 6);
	}
}
