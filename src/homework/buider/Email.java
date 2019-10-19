package homework.buider;

import java.util.ArrayList;

class Email {
    private ArrayList<String> recievers;
    private String content;
    private String topic;

    protected Email(ArrayList<String> recievers, String content, String topic) {
        this.recievers = recievers;
        this.content = content;
        this.topic = topic;
    }

    protected ArrayList<String> getRecievers() {
        return recievers;
    }

    protected void setRecievers(ArrayList<String> recievers) {
        this.recievers = recievers;
    }

    protected String getContent() {
        return content;
    }

    protected void setContent(String content) {
        this.content = content;
    }

    protected String getTopic() {
        return topic;
    }

    protected void setTopic(String topic) {
        this.topic = topic;
    }

}
