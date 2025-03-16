package space.typro.typicallauncher.events;

public interface EventListener<T extends EventData>{
    void onEvent(T eventData);
}
