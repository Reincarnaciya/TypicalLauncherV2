package space.typro.typicallauncher.events;

import lombok.AllArgsConstructor;
import lombok.Data;

public interface UserEvent {
    void onUserEvent(UserEventInfo userEventInfo);

    @AllArgsConstructor
    @Data
    class UserEventInfo implements EventData {

        public UserData data;
        @Data
        static class UserData{
            public Type type;
            public String username;
        }

        public enum Type{
            LOGIN, UNLOGIN, REGISTRATION
        }
    }
}
