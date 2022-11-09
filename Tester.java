import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Tester {
    private static final String IN_FILE = "in_players.txt";
    private static final String OUT_FILE = "out_players.txt";

    public static void main(String[] args){

        TopScorer ts = new TopScorer("in_players.txt");


        // testing all methods of TopScorers
        int score = ts.playerScore("Pele");
        System.out.println("\nScore of Pele is " + score);


    }
}
