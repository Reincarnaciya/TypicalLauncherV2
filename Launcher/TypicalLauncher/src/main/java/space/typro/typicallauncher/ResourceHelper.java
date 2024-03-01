package space.typro.typicallauncher;

import lombok.CustomLog;

import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
@CustomLog
public class ResourceHelper {

    public static String getResourceByType(ResourceFolder folder, String resourceName){
        if (folder == ResourceFolder.ROOT){
            return Objects.requireNonNull(Main.class.getResource(resourceName)).toExternalForm();
        }
        return Objects.requireNonNull(Main.class.getResource(folder.location + "/" + resourceName)).toExternalForm();
    }
    public static URL getResourceUrlByType(ResourceFolder folder, String resourceName){
        if (folder == ResourceFolder.ROOT){
            return Main.class.getResource(resourceName);
        }
        return Main.class.getResource(folder.location + "/" + resourceName);
    }
    public static InputStream getResourceAsStreamByType(ResourceFolder folder, String resourceName){
        if (folder == ResourceFolder.ROOT){
            return Main.class.getResourceAsStream(resourceName);
        }
        return Main.class.getResourceAsStream(folder.location + "/" + resourceName);
    }



    public enum ResourceFolder {
        IMAGES("images"),
        LEFT_PANEL_IMAGE_NP("images/leftPanelImg/notpick"),
        LEFT_PANEL_IMAGE_P("images/leftPanelImg/picked"),
        SUB_SCENES("scenes/subscene"),
        SCENES("scenes"),
        ROOT("");

        public final String location;

        ResourceFolder(String s){
            this.location = s;
        }

    }
}
