import java.util.ArrayList;
import java.util.List;

/**
 * ObserverPatternDemo
 * 
 * A simple project demonstrates ObserverPattern where suscribers receives
 * notifcation on new post from channel
 * 
 * Ytchannel is the subject which updates the subscribed users whenever a new
 * post is uploaded
 * 
 */

// Subscriber : observer interface
interface Subscriber {
    void PushNotification(String content);
}

// Subject: manages subscribers and posts
class Ytchannel {
    final private String channelName;
    private List<String> posts;
    private List<Subscriber> subscribers;

    public Ytchannel(String channelName) {
        this.channelName = channelName;
        this.posts = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    // adds new post
    public void UploadNewPost(String content) {
        posts.add(content);
        notifyUsers(content); // notify user on new post
    }

    private void notifyUsers(String content) {
        for (Subscriber subscriber : subscribers) {
            subscriber.PushNotification(content);
        }
    }

    public void subscribe(Subscriber user) {
        subscribers.add(user);
    }

}

// concrete observer
class User implements Subscriber {

    private int id;

    public User(int id) {
        this.id = id;
    }

    @Override
    public void PushNotification(String content) {
        System.out.println(" new Notifcation for user " + id + " : " + content);
    }

}

// client
public class ObserverPatternDemo {

    public static void main(String[] args) {
        // creating a channel
        Ytchannel channel = new Ytchannel("Simplechannel");

        User user1 = new User(1);
        User user2 = new User(2);

        // users subscribing to channel
        channel.subscribe(user1);
        channel.subscribe(user2);

        // uploading new post triggers alter for user
        channel.UploadNewPost("New post comming at today 7pm");
        channel.UploadNewPost("My latest vlogs");

    }
}