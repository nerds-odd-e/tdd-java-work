package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Questions {
	public LinkedList popQuestions;
	public LinkedList scienceQuestions;
	public LinkedList sportsQuestions;
	public LinkedList rockQuestions;

	public Questions() {
			
		this.popQuestions = new LinkedList();
		this.scienceQuestions = new LinkedList();
		this.sportsQuestions = new LinkedList();
		this.rockQuestions = new LinkedList();
		createQuestions();
	}

	void createQuestions() {
		for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast("Rock Question " + i);
		}
	}

	Object getQuestion(String category) {
		Object question = "";
		if (category == "Pop")
			question = popQuestions.removeFirst();
		if (category == "Science")
			question = scienceQuestions.removeFirst();
		if (category == "Sports")
			question = sportsQuestions.removeFirst();
		if (category == "Rock")
			question = rockQuestions.removeFirst();
		return question;
	}
}