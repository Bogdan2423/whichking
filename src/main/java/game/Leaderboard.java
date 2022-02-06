package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Leaderboard {
    private ArrayList<UserScore> list;

    Leaderboard(){
        loadLeaderboard();
    }

    public void loadLeaderboard(){
        list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("leaderboard.txt"));
            String username;
            int score;
            while (scanner.hasNext()) {
                username = scanner.next();
                score = scanner.nextInt();
                list.add(new UserScore(username, score));
            }
            Collections.sort(list);
        }
        catch (FileNotFoundException ex){}
    }

    public void addToLeaderboard(UserScore score){
        list.add(score);
        Collections.sort(list);

        String listString="";
        for (UserScore scoreFromList:list){
            listString+=scoreFromList.toString()+" ";
        }

        try{
            FileWriter file=new FileWriter("leaderboard.txt");
            file.write(listString);
            file.flush();
            file.close();
        }
        catch(Exception ex){}
    }

    public String getLeaderboardString(){
        String returnString="";
        int i=1;
        for (UserScore scoreFromList:list){
            returnString+=i+". "+scoreFromList.toString()+"\n";
            i++;
        }
        return returnString;
    }
}
