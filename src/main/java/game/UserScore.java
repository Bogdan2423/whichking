package game;

public class UserScore implements Comparable<UserScore> {
    private String username;
    private int score;

    UserScore(String username, int score){
        this.username=username;
        this.score=score;
    }

    public int getScore() {
        return score;
    }

    public String toString(){
        return username+" "+score;
    }

    @Override
    public int compareTo(UserScore o) {
        int otherScore=o.getScore();
        if (score==otherScore)
            return 0;
        if (score<otherScore)
            return 1;
        return -1;
    }
}
