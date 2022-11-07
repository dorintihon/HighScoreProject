import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TopScorer {
    private ArrayList<Player> playerList;

    public TopScorer() {
        playerList = new ArrayList<>();
    }

    public TopScorer(String file) {
        try {
            Scanner fileReader = new Scanner(new File(file));
            while (fileReader.hasNextLine()) {
// assuming each data line in the input file has the fields separated by comma
                String name = fileReader.nextLine();
                int score = fileReader.nextInt();
                playerList.add(new Player(name, score));
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File " + file + " could not be found!");
        }
    }

    public int playerScore(String name) {
        for (Player player : playerList) {
            if (name.equals(player.getName())) {
                return player.getScore();
            }
        }

        return 0;
    }

    public ArrayList<Player> getPlayers(){
        ArrayList<Player> tempPlayers = new ArrayList<>();
// we will duplicate the original arraylist and sort it, without changing the original one
        for(Player p : playerList)
            tempPlayers.add(p);
// now, we will sort the tempPlayers arraylist
        Collections.sort(tempPlayers);
        return tempPlayers;
    }

    public ArrayList<Player> getTopFivePlayers(ArrayList<Player> pls) {
        ArrayList<Player> topFive = new ArrayList<>(5);
        for(int i = 0; i < 5; i++)
            topFive.add(pls.get(i));
        return topFive;
    }

    public void topFiveToFile(ArrayList<Player> pls, String filename)
    {
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter(new File(filename));
            pw = new PrintWriter(fw);
            for(Player p : pls)
                pw.write(p.toString() + System.lineSeparator());
            pw.flush();
            fw.close();
            pw.close();
            System.out.println("All player data have been successfully written to file " + filename + ".\n");
        } catch (IOException ex) {
            System.out.println("Error in writing player records to file " + filename + "! Exiting..");
            System.exit(0);
        }
    }
}