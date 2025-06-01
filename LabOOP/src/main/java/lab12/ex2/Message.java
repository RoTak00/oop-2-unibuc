package lab12.ex2;

import java.time.LocalDateTime;

public class Message {

    private final String message;
    private final String user;
    private final LocalDateTime date;

    public Message(String message, String user) {
        this.message = message;
        this.user = user;
        this.date = LocalDateTime.now();
    }

    public Message(String message, String user, LocalDateTime date) {
        this.message = message;
        this.user = user;
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "[" + this.date.toString() + "] " + "(" + this.user + ") " + this.message;
    }
}
