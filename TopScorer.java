import java.io.*;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class TopScorer {
    private ArrayList<Player> playerList;
    ArrayList<String> userNames = new ArrayList<>();
    ArrayList<Integer> userRatings = new ArrayList<>();
    String fileName;

    public TopScorer() {
        playerList = new ArrayList<>();
    }

    public TopScorer(String fileName) {
        File f = new File(fileName);
        if(f.isFile()) {
            readData();
        }
    }

    void readData() {
        File file = new File(fileName);
        Scanner console;
        try {
            // getting file
            console = new Scanner(file);
            // loop over file data
            while (console.hasNext()) {
                // getting file data line by line
                String name = console.next();
                int score = console.nextInt();
                playerList.add(new Player(name, score));

            }

            // sort list in descending order by using our static sortPlayer() class.

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public int playerScore(String name) {
        for (Player player : playerList) {
            if (name.equals(player.getName())) {
                return player.getScore();
            }
        }

        return 0;
    }

    public void getTopNames(){
        Scanner inFS = null;
        playerList = new ArrayList<>();


        while(inFS.hasNext()) {
            String playerName = inFS.next();
            int playerScore = inFS.nextInt();

            playerList.add(new Player(playerName,playerScore));
            userNames.add(playerName);
            userRatings.add(playerScore);
        }

        inFS.close(); // close() may throw IOException if fails
    }

    public ArrayList<Player> getTopFivePlayers(ArrayList<Player> players) {
        ArrayList<Player> topList = new ArrayList<>(5);
        for(int i = 0; i < 5; i++)
            topList.add(players.get(i));
        return topList;
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