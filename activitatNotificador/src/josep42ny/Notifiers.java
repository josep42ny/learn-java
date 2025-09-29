package josep42ny;

public class Notifiers {

    public static void main(String[] args) {
        Notifier email = new EmailNotifier();
        Notifier sms = new SmsNotifier();

        Notifier[] notifiers = {email, sms};

        for (Notifier notifier : notifiers) {
            notifier.send(null);
            notifier.send("");
            notifier.send("Good message");
            notifier.send("Very long message Lorem ipsum dolor sit amet, consectetur adipiscing elites, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectet");
        }
        Notifier.printHelp();
    }

}
