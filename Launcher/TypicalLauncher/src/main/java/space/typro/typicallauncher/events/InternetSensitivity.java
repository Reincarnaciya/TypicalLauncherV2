package space.typro.typicallauncher.events;

public interface InternetSensitivity {
    void onInternetLostConnection();
    void onInternetReturnedConnection();
}
