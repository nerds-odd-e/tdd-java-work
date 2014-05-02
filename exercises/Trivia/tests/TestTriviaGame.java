import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;

public class TestTriviaGame {

	private List<String> output = new ArrayList<String>();
	Game aGame = new Game() {
		protected void print(Object obj) {
			output.add(obj.toString());
			System.out.println(obj);
			
		}
	};

//	@Test
	public void preserveTheGameBehavior() {

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");


		aGame.roll(1);
		aGame.wrongAnswer();
		aGame.roll(0);
		aGame.wasCorrectlyAnswered();

		assertTrue(output.contains("Chet was added"));
		assertTrue(output.contains("They are player number 1"));
		assertTrue(output.contains("Pat was added"));
		assertTrue(output.contains("Chet is the current player"));
		assertTrue(output.contains("They have rolled a 1"));
		assertTrue(output.contains("The category is Science"));
		assertTrue(output.contains("Science Question 0"));
		assertTrue(output.contains("Question was incorrectly answered"));
		assertTrue(output.contains("Chet was sent to the penalty box"));
		assertTrue(output.contains("Pat is the current player"));
		assertTrue(output.contains("Pat's new location is 0"));
		assertTrue(output.contains("Answer was corrent!!!!"));
		assertTrue(output.contains("Pat now has 1 Gold Coins."));
	}
	
	@Test
	public void shouldGetOutOfThePanaltyBoxOnlyOnce() throws Exception {
		aGame.add("Jack");
		aGame.roll(1);
		aGame.wrongAnswer();
		aGame.roll(1);
		aGame.roll(1);
		assertEquals(2, countOutput("Jack is getting out of the penalty box"));
		
	}

	int countOutput(String expected) {
		int count = 0;
		for (String line : output)
			if (line.equals(expected))
				count++;
		return count;
	}

}
