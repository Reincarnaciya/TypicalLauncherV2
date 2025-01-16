package space.typro.typicallauncher.managers;

import lombok.CustomLog;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@CustomLog
public class DirManager {

    public static final DirManager launcherDir = new DirManager("TypicalLauncher");
    public static final DirManager logDir = new DirManager(launcherDir.getName() + File.separator + "logs");
    public static final DirManager assetsDir = new DirManager(launcherDir.getName() + File.separator + "assets");


    public final File dir;

    /**
     * Создает папку в рабочей директории определяемой по ОС
     * @param dirName имя директории так же может создать подпапку, например, мы создали папку LauncherDir,
     *               мы можем передать сюда
     *               "LauncherDir/settings" и мы создадим папку settings в LauncherDir
     */
    public DirManager(String dirName){


        String userHome = System.getProperty("user.home", ".");
        File tempDir;

        switch (UserPC.USER_OS){
            case windows -> {
                String appdata = System.getenv("APPDATA");
                if (appdata != null){
                    tempDir = new File(appdata, dirName + "/");
                }else {
                    tempDir = new File(userHome, dirName + "/");
                }
            }
            case linux -> tempDir = new File(userHome, "Library/Application Support/" + dirName);
            default -> tempDir = new File(userHome, dirName + "/");
        }

        if ((!tempDir.exists()) && (!tempDir.mkdirs())) {
            throw new RuntimeException("Рабочая директория не определена (" + tempDir + ")");
        }
        dir = tempDir;
    }
    public void openInExplorer(){
        switch (UserPC.USER_OS){
            case windows -> {
                if (Desktop.isDesktopSupported()){
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.open(dir);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            default -> throw new RuntimeException("Лаунчер не работает на вашей ОС или она не определена");
        }
    }

    public static void deleteAllFileInFolder(File file){
        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                deleteAllFileInFolder(f);
            }
        }
        try {
            Files.delete(Paths.get(file.getAbsolutePath()));
        } catch (IOException ignore) {}
    }


    public String getName(){
        return dir.getName();
    }

    @Override
    public String toString(){
        return dir.toString();
    }

}
