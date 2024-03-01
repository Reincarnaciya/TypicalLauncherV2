package space.typro.typicallauncher.events;

import lombok.AllArgsConstructor;
import lombok.Data;

public interface UserEvent {
    void onUserEvent(UserEventInfo userEventInfo);
    @AllArgsConstructor
    @Data class UserEventInfo implements EventData {

        public UserData data;

        public static @Data class UserData{
            public UserEventType type;
            public String username;
        }

        public enum UserEventType {
            LOGIN, UNLOGIN, REGISTRATION
        }
    }
}
