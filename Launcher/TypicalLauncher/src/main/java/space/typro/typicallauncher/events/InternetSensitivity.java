package space.typro.typicallauncher.events;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.Timestamp;

public interface InternetSensitivity {
    void onInternetEvent(InternetEventInfo internetEventInfo);
    @AllArgsConstructor
    @Data class InternetEventInfo {

        public InternetEventData data;

        @Data
        static class InternetEventData implements EventData{
            public InternetEventType type;
            public Timestamp timestamp;
        }
    }

    public enum InternetEventType{
        LOST_CONNECTION, RETURNED_CONNECTION
    }
}
