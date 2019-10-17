package homework.buider;

import java.util.ArrayList;

public class Email {
    private ArrayList<String>  recievers;
    private String content;
    private String topic;

    public Email(ArrayList<String> recievers,String content, String topic)
    {
        this.recievers = recievers;
        this.content = content;
        this.topic = topic;
    }

}
