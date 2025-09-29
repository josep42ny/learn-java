package josep42ny;

public class SmsNotifier implements Notifier{

    @Override
    public void send(String message) {
        System.out.println(this.validate(message) ? "Sms: " + message : "Invalid sms message");
    }

    @Override
    public boolean validate(String message) {
        return Notifier.super.validate(message) && message.length() <= 500;
    }

}
