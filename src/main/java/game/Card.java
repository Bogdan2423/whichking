package game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Card {
    private Map<Resource, Integer> resourcesOnAccept=new LinkedHashMap<>();
    private Map<Resource, Integer> resourcesOnDecline=new LinkedHashMap<>();
    private String description;
    private String acceptMessage;
    private String declineMessage;

    Card(int militaryOnAccept, int goldOnAccept, int foodOnAccept, int techOnAccept, int militaryOnDecline, int goldOnDecline, int foodOnDecline, int techOnDecline,
         String description, String acceptMessage, String declineMessage){
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
    }



    public Map<Resource,Integer> getResources(boolean accepted){
        Map<Resource,Integer> returnMap=new LinkedHashMap<>();
        Map<Resource,Integer> resourcesList;
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

    public String getDescription(){return description;}
    public String getAcceptMessage(){return acceptMessage;}
    public String getDeclineMessage(){return declineMessage;}
}
