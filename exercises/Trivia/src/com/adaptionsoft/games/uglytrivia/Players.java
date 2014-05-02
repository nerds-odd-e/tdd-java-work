package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.List;

public class Players {
	public List<String> players;
	public int[] places;
	public int[] purses;
	public boolean[] inPenaltyBox;
	public int currentPlayer;

	public Players() {
		this.players = new ArrayList<String>();
		this.places = new int[6];
		this.purses = new int[6];
		this.inPenaltyBox = new boolean[6];
		this.currentPlayer = 0;
	}

	public int howManyPlayers() {
		return players.size();
	}

	void addPlayer(String playerName) {
		players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;
	}

	String getCurrentPlayerName() {
		return players.get(currentPlayer);
	}

	void currentPlayerRolls(int roll) {
		places[currentPlayer] = places[currentPlayer]
				+ roll;
		if (places[currentPlayer] > 11)
			places[currentPlayer] = places[currentPlayer] - 12;
	}

	boolean currentPlayerInPenaltyBox() {
		return inPenaltyBox[currentPlayer];
	}

	String currentCategory() {
		if (places[currentPlayer] == 0)
			return "Pop";
		if (places[currentPlayer] == 4)
			return "Pop";
		if (places[currentPlayer] == 8)
			return "Pop";
		if (places[currentPlayer] == 1)
			return "Science";
		if (places[currentPlayer] == 5)
			return "Science";
		if (places[currentPlayer] == 9)
			return "Science";
		if (places[currentPlayer] == 2)
			return "Sports";
		if (places[currentPlayer] == 6)
			return "Sports";
		if (places[currentPlayer] == 10)
			return "Sports";
		return "Rock";
	}
}