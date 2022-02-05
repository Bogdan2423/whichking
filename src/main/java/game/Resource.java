package game;

public enum Resource {
    Military,
    Gold,
    Food,
    Tech;

    public String getImgPath(){
        switch (this){
            case Food:
                return "src/main/resources/foodIcon.png";
            case Gold:
                return "src/main/resources/goldIcon.png";
            case Tech:
                return "src/main/resources/techIcon.png";
            case Military:
                return "src/main/resources/militaryIcon.png";
            default:
                return "";
        }
    }
}
