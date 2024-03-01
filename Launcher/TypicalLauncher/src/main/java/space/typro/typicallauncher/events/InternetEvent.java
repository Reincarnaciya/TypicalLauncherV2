package space.typro.typicallauncher.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.security.Timestamp;
import java.util.Optional;

public interface InternetEvent {
    void onInternetEvent(InternetEventInfo internetEventInfo);
    @AllArgsConstructor
    @Data class InternetEventInfo {

        public InternetData data;


        public static @Data class InternetData implements EventData {
            public InternetEventType type;
            public Timestamp timestamp;
        }
        public enum InternetEventType {
            LOST_CONNECTION, RETURNED_CONNECTION
        }
    }
}
