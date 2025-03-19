package MusicChannel;

public interface Channel {
    public void update();
    public void add(Observer subscriber);
    public void notifySubscribers();
}
