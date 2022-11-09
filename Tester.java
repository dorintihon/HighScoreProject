import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Tester {
    private static final String IN_FILE = "in_players.txt";
    private static final String OUT_FILE = "out_players.txt";

    public static void main(String[] args) throws FileNotFoundException {
// creating an instance of TopScorer class
        TopScorer topScorer = new TopScorer("./in_players.txt");
        System.out.println(topScorer.getPlayerList());
// read

// display the top players

// get top 5 players

// display all the top 5 players [OPTIONAL]

    }
}
