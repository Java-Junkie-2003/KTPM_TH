package MusicChannel;

public class Main {
    public static void main(String[] args) {

        Channel musicChannel = new MusicChannel();
        Observer subscriber = new MySubscriber();
        musicChannel.add(subscriber);
        Observer subscriber2 = new MySubscriber();
        musicChannel.add(subscriber2);
        musicChannel.update();
        musicChannel.update();
    }
}