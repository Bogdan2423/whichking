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
                0,0,20,20,"lorem ipsum","tak","nie"));
        engine.addCard(new Card(-10,0,20,0,
                0,0,0,-20,"dolor sit","tak","nie"));
        engine.start();
        VBox mainBox=new VBox(tracker.getResourcesBox(), engine.getCardBox());
        Scene scene = new Scene(mainBox,sceneWidth,sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
