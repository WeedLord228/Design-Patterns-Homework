package homework.buider;

import java.util.ArrayList;

public class EmailBuilder {
    private ArrayList<String> recievers;
    private String content;
    private String topic;

    public EmailBuilder(String reciever, String content) {
        recievers.add(reciever);
        this.content = content;
    }

    public EmailBuilder addReciever(String reciever)
    {
        this.recievers.add(reciever);
        return this;
    }

    public EmailBuilder setTopic(String topic)
    {
        this.topic = topic;
        return this;
    }

    public Email build()
    {
        return new Email(recievers,content,topic);
    }

}
