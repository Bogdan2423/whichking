package game;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class GameEngine {
    private ArrayList<Card> cards=new ArrayList<>();
    private VBox cardBox;
    private Random rand=new Random();

    public void addCard(Card card){
        cards.add(card);
    }

    public void start(){
        Card currCard=getRandomCard();
        cardBox=new VBox();
    }

    private Card getRandomCard(){
        return cards.get(rand.nextInt(cards.size()));
    }

    private HBox getDecisionBox(Card card){
        Map<Resource,Integer> resourcesOnAccept=card.getResources(true);
        Map<Resource,Integer> resourcesOnDecline=card.getResources(false);
        VBox acceptBox;
        VBox declineBox;
        HBox decisionBox=new HBox();

        return decisionBox;
    }
}
