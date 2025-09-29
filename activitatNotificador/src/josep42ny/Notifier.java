package josep42ny;

public interface Notifier {

    String innerInfo = "inner info";

    void send(String message);

    default boolean validate(String message) {
        log(innerInfo);
        return !(message == null || message.isEmpty());
    }

    public static void printHelp() {
        System.out.println("""
                Class Help
                =====================
                Lorem ipsum dolor sit amet,
                consectetur adipiscing elit,
                sed do eiusmod tempor.
                """);
        System.out.println("");
    }

    private void log(String message) {
        System.out.println(message);
    }

}
