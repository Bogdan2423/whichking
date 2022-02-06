package game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Card {
    private Map<Resource, Double> resourcesOnAccept=new LinkedHashMap<>();
    private Map<Resource, Double> resourcesOnDecline=new LinkedHashMap<>();
    private String description;
    private String acceptMessage;
    private String declineMessage;
    private int imageId;

    Card(double militaryOnAccept, double goldOnAccept, double foodOnAccept, double techOnAccept,
         double militaryOnDecline, double goldOnDecline, double foodOnDecline, double techOnDecline,
         String description, String acceptMessage, String declineMessage, int ImageId){
        resourcesOnAccept.put(Resource.Military,militaryOnAccept);
        resourcesOnAccept.put(Resource.Gold,goldOnAccept);
        resourcesOnAccept.put(Resource.Food,foodOnAccept);
        resourcesOnAccept.put(Resource.Tech,techOnAccept);

        resourcesOnDecline.put(Resource.Military,militaryOnDecline);
        resourcesOnDecline.put(Resource.Gold,goldOnDecline);
        resourcesOnDecline.put(Resource.Food,foodOnDecline);
        resourcesOnDecline.put(Resource.Tech,techOnDecline);

        this.description=description;
        this.acceptMessage=acceptMessage;
        this.declineMessage=declineMessage;
        this.imageId=ImageId;
    }



    public Map<Resource,Double> getResources(boolean accepted){
        Map<Resource,Double> returnMap=new LinkedHashMap<>();
        Map<Resource,Double> resourcesList;
        if (accepted)
            resourcesList=resourcesOnAccept;
        else
            resourcesList=resourcesOnDecline;
        for (Resource resource:resourcesList.keySet()){
            if (resourcesList.get(resource)!=0){
                returnMap.put(resource,resourcesList.get(resource));
            }
        }
        return returnMap;
    }

    public String getImgPath(){return "src/main/resources/cardImage"+imageId+".png";}
    public String getDescription(){return description;}
    public String getAcceptMessage(){return acceptMessage;}
    public String getDeclineMessage(){return declineMessage;}
}
