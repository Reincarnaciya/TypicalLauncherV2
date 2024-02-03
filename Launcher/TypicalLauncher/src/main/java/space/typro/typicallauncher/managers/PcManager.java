package space.typro.typicallauncher.managers;

public class PcManager {

    public static final OS USER_OS = getPlatform();




    private static OS getPlatform(){
        return switch (System.getProperty("os.name").toLowerCase()){
            case "win" -> OS.windows;
            case "linux", "unix" -> OS.linux;
            case "macos" -> OS.macos;
            default -> OS.unknown;
        };
    }
    public enum OS{
        windows, linux, macos, unknown
    }
}
