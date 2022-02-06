package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import static java.lang.System.out;

public class GameEngine {
    private ArrayList<Card> cards=new ArrayList<>();
    private VBox cardBox=new VBox();
    private Random rand=new Random();
    private Card currCard;
    private ResourceTracker resourceTracker;
    private int score=0;
    private Leaderboard leaderboard;
    private ArrayList<String> decisionList= new ArrayList<>();

    GameEngine(ResourceTracker resourceTracker, Leaderboard leaderboard){
        this.resourceTracker=resourceTracker;
        this.leaderboard=leaderboard;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void start(){
        Button startButton=new Button("Start");
        cardBox.getChildren().addAll(startButton,new Label(leaderboard.getLeaderboardString()));
        startButton.setOnAction((event5 -> {
            showFirstCard();
        }));
    }

    private void showFirstCard(){
        setNewCard();
    }

    private void decisionMade(boolean accepted){
        score++;
        if (accepted)
            decisionList.add(currCard.getAcceptMessage());
        else
            decisionList.add(currCard.getDeclineMessage());
        Map<Resource,Double> resourcesChange=currCard.getResources(accepted);
        if(resourceTracker.updateResources(resourcesChange))
            setNewCard();
        else
            end();
    }

    private void setNewCard(){
        currCard=getRandomCard();
        cardBox.getChildren().clear();
        cardBox.getChildren().addAll(new Label(currCard.getDescription()),getDecisionBox(currCard));
    }

    private void end(){
        cardBox.getChildren().clear();
        TextField usernameField=new TextField();
        Button saveButton=new Button("Save");
        String decisions="Twoje decyzje:\n";
        for (String decision:decisionList){
            decisions+=decision+"\n";
        }
        cardBox.getChildren().addAll(new Label("Game Over \n Your score: "+score),usernameField,saveButton,new Label(decisions));
        saveButton.setOnAction((event3 -> {
            save(new UserScore(usernameField.getText(),score));
        }));
        return;
    }

    private void save(UserScore score){
        leaderboard.addToLeaderboard(score);
        cardBox.getChildren().clear();
        cardBox.getChildren().add(new Label(leaderboard.getLeaderboardString()));
    }

    private Card getRandomCard(){
        return cards.get(rand.nextInt(cards.size()));
    }

    private HBox getDecisionBox(Card card){
        Map<Resource,Double> resourcesOnAccept=card.getResources(true);
        Map<Resource,Double> resourcesOnDecline=card.getResources(false);
        VBox acceptBox=new VBox();
        updateBox(acceptBox,resourcesOnAccept);
        VBox declineBox=new VBox();
        updateBox(declineBox,resourcesOnDecline);
        Button acceptButton=new Button(card.getAcceptMessage());
        Button declineButton=new Button(card.getDeclineMessage());
        HBox decisionBox=new HBox(acceptButton,acceptBox,declineButton,declineBox);
        acceptButton.setOnAction((event0 -> {
            decisionMade(true);
        }));
        declineButton.setOnAction((event1 -> {
            decisionMade(false);
        }));
        return decisionBox;
    }

    private void updateBox(VBox box, Map<Resource,Double> resources){
        for (Resource resource :resources.keySet()){
            try{box.getChildren().add(
                    new HBox(new ImageView(new Image(new FileInputStream(resource.getImgPath()),20.0,20.0,true,true)),
                            new Label(resources.get(resource).toString())));}
            catch (FileNotFoundException ex){}
        }
        return;
    }

    public VBox getCardBox() {return cardBox;}
}
