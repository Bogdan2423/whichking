package game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{
    private ResourceTracker tracker=new ResourceTracker();
    private Leaderboard leaderboard=new Leaderboard();
    private double sceneWidth=800;
    private double sceneHeight=1000;

    public void start(Stage primaryStage) throws Exception {
        GameEngine engine=new GameEngine(tracker,leaderboard);
        engine.addCard(new Card(10,-20,0,0,
                -20,0,0,0,"Powinnismy zwiekszyć zold dla naszych zolnierzy"
                ,"Tak","Nie",0));
        engine.addCard(new Card(-10,-40,0,0,
                -20,0,0,-20,
                "W naszym krolestwie szerzy sie zaraza, potrzebuje funduszy oraz ludzi do znalezienia lekarstwa"
                ,"Tak","Nie",3));
        engine.addCard(new Card(-20,0,0,30,
                0,0,-20,-10,
                "Potrzebuje troche \"pomocnikow\" do moich eksperymentow"
                ,"Tak","Nie",2));
        engine.addCard(new Card(-20,20,10,0,
                0,0,0,0,
                "Potrzebuje wyszkolonych wojownikow do mojej zalogi, w zamian oddam czesc lupow z moich wypraw"
                ,"Tak","Nie",6));
        engine.addCard(new Card(0,-20,0,20,
                0,10,-10,0,
                "Moge podzielic sie technologia z mojego kraju"
                ,"Tak","Nie",7));
        engine.addCard(new Card(0,50,0,0,
                0,-20,10,10,
                "Znalazlem to w skarbcu sasiedniego krolestwa"
                ,"Tak","Nie",4));
        engine.addCard(new Card(-20,0,40,0,
                10,0,-20,-10,
                "Plony w tym roku byly obfite, jednak brakuje nam rak do pracy"
                ,"Tak","Nie",5));
        engine.addCard(new Card(-40,30,30,50,
                0,0,0,0,
                "źżććźżźćźćżźćśęęę€ó€ńśęśąś śąśąąęęąńśńąąćęŹŻĘ"
                ,"???","???",1));
        engine.addCard(new Card(30,00,-30,50,
                0,0,0,0,
                "Mozemy zwerbowac troche chlopow do wojska"
                ,"Tak","Nie",0));
        engine.addCard(new Card(-10,30,10,0,
                20,0,0,0,
                "Nasze krolestwa moga skorzystac na wspolpracy handlowej"
                ,"Tak","Nie",7));
        engine.start();
        VBox mainBox=new VBox(tracker.getResourcesBox(), engine.getCardBox());
        Scene scene = new Scene(mainBox,sceneWidth,sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
