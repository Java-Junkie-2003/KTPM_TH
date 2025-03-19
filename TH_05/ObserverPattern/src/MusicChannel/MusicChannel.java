package MusicChannel;

import java.util.ArrayList;
import java.util.List;

public class MusicChannel implements Channel {


    boolean state = false;
    List<Observer> subscribers = new ArrayList<>();

    @Override
    public void update() {
        this.state = !state;
        notifySubscribers();
    }

    @Override
    public void add(Observer subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers() {
        System.out.println("State of the channel: "+ (state ? "Live" : "Offline"));
        subscribers.forEach(subscriber -> subscriber.receiveMessage("Music channel is now " + (state ? "live" : "offline")));
    }
}
