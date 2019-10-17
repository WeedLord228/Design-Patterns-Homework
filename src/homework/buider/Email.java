package homework.buider;

import java.util.ArrayList;

public class Email {
    private ArrayList<String> recievers;
    private String content;
    private String topic;

    public Email(ArrayList<String> recievers, String content, String topic) {
        this.recievers = recievers;
        this.content = content;
        this.topic = topic;
    }

    public ArrayList<String> getRecievers() {
        return recievers;
    }

    public void setRecievers(ArrayList<String> recievers) {
        this.recievers = recievers;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
