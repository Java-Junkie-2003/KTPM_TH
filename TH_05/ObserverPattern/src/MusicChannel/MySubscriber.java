package MusicChannel;

public class MySubscriber implements Observer {

    @Override
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
