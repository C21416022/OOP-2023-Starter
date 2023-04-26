// This code defines a class named DANI, which extends the PApplet class from Processing.
//C21416022
package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;

public class DANI extends PApplet {

	// An ArrayList of Word objects, which represents a model of a text file.
	ArrayList<Word> model = new ArrayList<>();
	// An array of strings, which represents a sonnet generated from the model.
	String[] sonnet;

	// Defines the size of the Processing sketch.
	public void settings() {
		size(1000, 1000);
		// fullScreen(SPAN);
	}

	// Writes a sonnet by calling the writeLine() method 14 times.
	public String[] writeSonnet() {
		String[] sonnet = new String[14];
		for (int i = 0; i < 14; i++) {
			sonnet[i] = writeLine();
		}
		return sonnet;
	}

	// Writes a line of text by randomly selecting words from the model.
	public String writeLine() {
		StringBuilder sb = new StringBuilder();
		int wordCount = 0;
		// Picks a random word from the model to start with.
		Word currentWord = model.get((int) random(model.size()));

		// Keeps picking random words from the model until either a line of text
		// containing 8 words is created or there are no more words to pick.
		while (currentWord != null && wordCount < 8) {
			sb.append(currentWord.getWord()).append(" ");
			currentWord = pickRandomFollow(currentWord);
			wordCount++;
		}

		return sb.toString().trim();
	}

	// Picks a random word that follows the given word in the model.
	public Word pickRandomFollow(Word word) {
		if (word.getFollows().size() == 0) {
			return null;
		}

		// Picks a random follow word from the list of follow words for the given word.
		String randomFollowWord = word.getFollows().get((int) random(word.getFollows().size())).getWord();
		return findWord(randomFollowWord);
	}
	
	// Initializes the model with data from a text file.
	public void initializeModel(String filename) {
		loadFile(filename);
	}

	// Called once at the start of the program to set up the sketch.
	public void setup() {
		colorMode(HSB);
		initializeModel("shakespere.txt");
		sonnet = writeSonnet();
		for (String line : sonnet) {
			println(line);
		}
	}

	// Called whenever a key is pressed.
	public void keyPressed() {
		if (key == ' ') {
			sonnet = writeSonnet();
		}
	}	

	float off = 0;

	// Called repeatedly to draw the sketch.
	public void draw() {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
		textAlign(CENTER, CENTER);
	
		float lineHeight = height / 18;
		float yOffset = (height - lineHeight * sonnet.length) / 2;
	
		for (int i = 0; i < sonnet.length; i++) {
			text(sonnet[i], width / 2, yOffset + (i * lineHeight));
		}
	}
	
	
	// Loads data from a text file into the model.
	public void loadFile(String filename) {
		String[] lines = loadStrings(filename);
		String prevWord = null;

		for (String line : lines) {
			String[] words = split(line, ' ');

			for (String w : words) {
				w = w.replaceAll("[^\\w\\s]", "").toLowerCase();

				if (prevWord != null) {
					Word wordObj = findWord(prevWord);
					if (wordObj == null) {
						wordObj = new Word(prevWord);
						model.add(wordObj);
					}

					Follow followObj = wordObj.findFollow(w);
					if (followObj == null) {
						wordObj.addFollow(new Follow(w, 1));
					} else {
						followObj.incrementCount();
					}
				}
				prevWord = w;
			}
		}
	}

	public Word findWord(String str) {
		for (Word wordObj : model) {
			if (wordObj.getWord().equals(str)) {
				return wordObj;
			}
		}
		return null;
	}

	public void printModel() {
		for (Word wordObj : model) {
			println(wordObj.toString());
		}
	}

}