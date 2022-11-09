import java.io.*;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class TopScorer {
    private ArrayList<Player> playerList;
    ArrayList<String> userNames = new ArrayList<>();
    ArrayList<Integer> userRatings = new ArrayList<>();

    public TopScorer(FileInputStream fileByteStream) {
        playerList = new ArrayList<>();
    }

    public TopScorer(String file) {

        Scanner inFS = new Scanner(file);
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
        playerList.sort(Collections.reverseOrder());
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