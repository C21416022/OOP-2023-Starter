//C21416022 
package ie.tudublin;

// Define the Follow class
public class Follow {
    // Declare class fields
    private String word;
    private int count;

  // Constructor for the Follow class
public Follow(String word, int count) {
    // Assign the parameter values to class fields
    this.word = word;
    this.count = count;
}

// Gets the word field
public String getWord() {
    return word;
}

// Gets  the count field
public int getCount() {
    return count;
}

// Set  the word field
public void setWord(String word) {
    this.word = word;
}

// Sets method for the count field
public void setCount(int count) {
    this.count = count;
}

// Method to increment the count field by 1
public void incrementCount() {
    this.count++;
}


}

