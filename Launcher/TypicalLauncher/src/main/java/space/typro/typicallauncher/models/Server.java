package space.typro.typicallauncher.models;

import javafx.scene.control.skin.TextInputControlSkin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import space.typro.typicallauncher.managers.DirManager;

import java.awt.*;
import java.io.File;
import java.io.Serializable;

@Data
public class Server {
    String name;
    ServerVersion version;
    Image image;


    public enum ServerVersion{
        VERSION_1_7_10("assets1.7.10"), VERSION_1_12_2("assets1.12.2");


        public final String pathToAssets;

        ServerVersion(String assetName){
            this.pathToAssets = DirManager.assetsDir.dir.getAbsolutePath() + File.separator + assetName;
        }
    }






}
