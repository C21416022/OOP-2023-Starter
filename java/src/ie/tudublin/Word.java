// C21416022
// This class represents a word and its following words in a text
// It contains a String to store the word and an ArrayList to store the Follow objects,
// which represent the words that come after this word in the text.

package ie.tudublin;

import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<Follow> follows;

    public Word(String word) {// constructor method that initializes the word and ArrayList
        this.word = word;
        follows = new ArrayList<>();
    }

    public String getWord() { // method to return the word stored in the object
        return word;
    }

    public ArrayList<Follow> getFollows() {// method to return the ArrayList of Follow objects stored in the object
        return follows;
    }

    public void SetWord(String word) {// method to set the word to a new value
        this.word = word;
    }

    public void addFollow(Follow follow) {// method to add a new Follow object to the ArrayList
        follows.add(follow);
    }

    public Follow findFollow(String str) {// method to find a Follow object with a given word
        for (Follow follow : follows) {
            if (follow.getWord().equals(str)) {
                return follow;
            }
        }
        return null;
    }

 
}