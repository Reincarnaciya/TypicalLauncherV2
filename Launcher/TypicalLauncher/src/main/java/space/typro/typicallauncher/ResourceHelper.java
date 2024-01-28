package space.typro.typicallauncher;

public class ResourceHelper {

    public static String getResourceByType(ResourceType type, String resourceName){
        return Main.class.getResource(type.location + "/" + resourceName).toExternalForm();
    }



    public enum ResourceType{
        IMAGES("images"),
        LEFT_PANEL_IMAGE_NP("images/leftPanelImg/notpick"),
        LEFT_PANEL_IMAGE_P("images/leftPanelImg/picked"),
        SCENES("scenes"),
        ROOT("");

        public final String location;

        ResourceType(String s){
            this.location = s;
        }

    }
}
