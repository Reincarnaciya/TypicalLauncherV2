package space.typro.typicallauncher.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import space.typro.typicallauncher.controllers.scenes.subscenes.SettingsController;

import java.util.HashMap;

public class Events {

    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    public class InternetEvent extends EventData {
        InternetEventType type;

        public enum InternetEventType {
            LOST, RESTORED
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    public class UserEvent extends EventData {



        public enum UserEventType{
            LOGIN, REGISTER, LOGOUT
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    public static class SettingsEvent extends EventData {
        SettingsEventType SettingsEventType;
        HashMap<String, String> changedSettings;
        SettingsController.GameSettings beforeChange;
        SettingsController.GameSettings newSettings;




        public enum SettingsEventType {
            CHANGE, SAVE, RESTORE, CANCEL_EDIT
        }
    }
}
