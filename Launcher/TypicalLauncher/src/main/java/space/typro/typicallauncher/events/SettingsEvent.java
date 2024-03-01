package space.typro.typicallauncher.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import space.typro.typicallauncher.controllers.scenes.subscenes.SettingsController;

import java.util.HashMap;

public interface SettingsEvent {
    void onSettingsEvent(SettingsEventInfo settingsEventInfo);
    @AllArgsConstructor
    @Data
    class SettingsEventInfo implements EventData {
        public SettingsData settingsData;

        @AllArgsConstructor
        public static @Data class SettingsData implements EventData {
            public SettingsEventType type;
            public HashMap<String, String> changedSettingsMap;
            public SettingsController.GameSettings settingsAfterChange;
            public SettingsController.GameSettings settingsBeforeChange;
        }

        public enum SettingsEventType {
            CHANGE, SAVE, RESET_TO_DEFAULT, RESET
        }
    }
}
