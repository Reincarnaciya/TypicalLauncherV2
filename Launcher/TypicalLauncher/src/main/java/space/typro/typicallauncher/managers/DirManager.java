package space.typro.typicallauncher.managers;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DirManager {

    public static final DirManager launcherDir = new DirManager("TypicalLauncher");


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

        switch (PcManager.USER_OS){
            case windows -> {
                String appdata = System.getenv("APPDATA");
                if (appdata != null){
                    tempDir = new File(appdata, "." + dirName + "/");
                }else {
                    tempDir = new File(userHome, "." + dirName + "/");
                }
            }
            case linux -> tempDir = new File(userHome, "Library/Application Support/" + dirName);
            default -> tempDir = new File(userHome, dirName + "/");
        }

        if ((!tempDir.exists()) && (!tempDir.mkdirs())){
            throw new RuntimeException("Рабочая директория не определена (" + tempDir + ")");
        }
        dir = tempDir;
    }
    public void openInExplorer(){
        Desktop desktop;
        switch (PcManager.USER_OS){
            case windows -> {
                if (Desktop.isDesktopSupported()){
                    desktop = Desktop.getDesktop();
                    try {
                        desktop.open(dir);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            default -> {
                System.err.println("Ошибка");
            }
        }
    }








}
