package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class GameEngine {
    private ArrayList<Card> cards=new ArrayList<>();
    private VBox cardBox;
    private Random rand=new Random();
    private Card currCard;

    public void addCard(Card card){
        cards.add(card);
    }

    public void start(){
        currCard=getRandomCard();
        cardBox=new VBox(new Label(currCard.getDescription()),getDecisionBox(currCard));
    }

    private void accepted(){}

    private void declined(){}

    private Card getRandomCard(){
        return cards.get(rand.nextInt(cards.size()));
    }

    private HBox getDecisionBox(Card card){
        Map<Resource,Integer> resourcesOnAccept=card.getResources(true);
        Map<Resource,Integer> resourcesOnDecline=card.getResources(false);
        VBox acceptBox=new VBox();
        for (Resource resource :resourcesOnAccept.keySet()){
            try{acceptBox.getChildren().add(
                    new HBox(new ImageView(new Image(new FileInputStream(resource.getImgPath()))),
                    new Label(resourcesOnAccept.get(resource).toString())));}
            catch (FileNotFoundException ex){}
        }
        VBox declineBox=new VBox();
        for (Resource resource :resourcesOnDecline.keySet()){
            try{declineBox.getChildren().add(
                        new HBox(new ImageView(new Image(new FileInputStream(resource.getImgPath()))),
                        new Label(resourcesOnDecline.get(resource).toString())));}
            catch (FileNotFoundException ex){}
        }
        Button acceptButton=new Button(card.getAcceptMessage());
        Button declineButton=new Button(card.getDeclineMessage());
        HBox decisionBox=new HBox(acceptButton,acceptBox,declineButton,declineBox);
        return decisionBox;
    }

    public VBox getCardBox() {return cardBox;}
}
