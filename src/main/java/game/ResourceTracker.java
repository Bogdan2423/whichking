package game;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ResourceTracker {
    private double military=50;
    private double gold=50;
    private double food=50;
    private double tech=50;

    private HBox resourcesBox;
    private ProgressBar militaryBar = new ProgressBar(0.5);
    private ProgressBar goldBar = new ProgressBar(0.5);
    private ProgressBar foodBar = new ProgressBar(0.5);
    private ProgressBar techBar = new ProgressBar(0.5);

    ResourceTracker(){
        try {
            ImageView militaryImageView = new ImageView(new Image(new FileInputStream(Resource.Military.getImgPath())));
            ImageView goldImageView = new ImageView(new Image(new FileInputStream(Resource.Gold.getImgPath())));
            ImageView foodImageView = new ImageView(new Image(new FileInputStream(Resource.Food.getImgPath())));
            ImageView techImageView = new ImageView(new Image(new FileInputStream(Resource.Tech.getImgPath())));
            resourcesBox=new HBox(militaryImageView,militaryBar,goldImageView,goldBar,foodImageView,foodBar,techImageView,techBar);
        }
        catch (FileNotFoundException ex){}
    }

    public boolean updateResources(int military, int gold, int food, int tech){
        this.military+=military;
        this.gold+=gold;
        this.food+=food;
        this.tech+=tech;

        if (this.military>100){this.military=100;}
        if (this.gold>100){this.gold=100;}
        if (this.food>100){this.food=100;}
        if (this.tech>100){this.tech=100;}

        militaryBar.setProgress(this.military/100);
        goldBar.setProgress(this.gold/100);
        foodBar.setProgress(this.food/100);
        techBar.setProgress(this.tech/100);

        if (this.military==0 || this.gold==0 || this.food==0 || this.tech==0)
            return false;
        else
            return true;
    }

    public HBox getResourcesBox(){
        return resourcesBox;
    }
}
