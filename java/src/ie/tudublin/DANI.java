package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

	

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;

    public String[] writeSonnet()
    {
        return null;
    }

	public void setup() {
		colorMode(HSB);

       
	}

	public void keyPressed() {

	}

	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);
        
	}

	public class Follow {
		private String word;
		private int count;
	
		// Constructor with both fields
		public Follow(String word, int count) {
			this.word = word;
			this.count = count;
		}
	
		// Constructor with just the word field
		public Follow(String word) {
			this(word, 0);
		}
	
		// Accessor method for the word field
		public String getWord() {
			return word;
		}
	
		// Accessor method for the count field
		public int getCount() {
			return count;
		}
	
		// Method to increment the count field by one
		public void incrementCount() {
			count++;
		}
	
		// toString method to print out the object's fields
		public String toString() {
			return word + ": " + count;
		}
	}
	


}
