// C21416022
// This class represents a word and its following words in a text
// It contains a String to store the word and an ArrayList to store the Follow objects,
// which represent the words that come after this word in the text.

package ie.tudublin;

import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<Follow> follows;

    // Constructor method that initializes the word and ArrayList
public Word(String word) {
    this.word = word;
    follows = new ArrayList<>();
}

// Method to return the word stored in the object
public String getWord() {
    return word;
}

// Method to return the ArrayList of Follow objects stored in the object
public ArrayList<Follow> getFollows() {
    return follows;
}

// Method to set the word to a new value
public void setWord(String word) {
    this.word = word;
}

// Method to add a new Follow object to the ArrayList
public void addFollow(Follow follow) {
    follows.add(follow);
}

// Method to find a Follow object with a given word
public Follow findFollow(String str) {
    for (Follow follow : follows) {
        if (follow.getWord().equals(str)) {
            return follow;
        }
    }
    return null;
}

 
}