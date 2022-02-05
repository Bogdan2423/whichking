package game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{
    private ResourceTracker tracker=new ResourceTracker();
    private double sceneWidth=800;
    private double sceneHeight=1000;

    public void start(Stage primaryStage) throws Exception {
        VBox mainBox=new VBox(tracker.getResourcesBox());
        Scene scene = new Scene(mainBox,sceneWidth,sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
