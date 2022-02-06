package game;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResourceTracker {
    private Map<Resource, Double> resources=new LinkedHashMap<>();

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

        resources.put(Resource.Military,50.0);
        resources.put(Resource.Gold,50.0);
        resources.put(Resource.Food,50.0);
        resources.put(Resource.Tech,50.0);
    }

    public boolean updateResources(Map<Resource,Double> resourcesChange){
        for (Resource resource :resourcesChange.keySet()){
            resources.put(resource,resources.get(resource)+resourcesChange.get(resource));
            if (resources.get(resource)>100)
                resources.put(resource, 100.0);
            switch (resource){
                case Military:
                    militaryBar.setProgress(resources.get(Resource.Military)/100);
                    break;
                case Tech:
                    techBar.setProgress(resources.get(Resource.Tech)/100);
                    break;
                case Gold:
                    goldBar.setProgress(resources.get(Resource.Gold)/100);
                    break;
                case Food:
                    foodBar.setProgress(resources.get(Resource.Food)/100);
                    break;
                default:
                    break;
            }
            if (resources.get(resource)<=0)
                return false;
        }
        return true;
    }

    public HBox getResourcesBox(){
        return resourcesBox;
    }
}
