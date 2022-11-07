import java.util.ArrayList;

public class Tester {
    private static final String IN_FILE = "in_players.txt";
    private static final String OUT_FILE = "out_players.txt";

    public static void main(String[] args) {
// creating an instance of TopScorer class
        TopScorer topScorer = new TopScorer();
// read file
        topScorer.readFile(IN_FILE);

// display the top players
        ArrayList<Player> topPlayers = topScorer.getTopPlayers();
// get top 5 players
        ArrayList<Player> topFivePlayers = topScorer.getTopFivePlayers(topPlayers);
// display all the top 5 players [OPTIONAL]
        System.out.println("Top 5 five players:");
        for(Player p : topFivePlayers)
            System.out.println("Name: " + p.getName() + ", Score: " + p.getScore());
        System.out.println();
// write the top five players to the file
        topScorer.topFiveToFile(topFivePlayers, OUT_FILE);
    }
}
