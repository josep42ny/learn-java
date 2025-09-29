package josep42ny;

public class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println(this.validate(message) ? "Email: " + message : "Invalid email message");
    }

}
