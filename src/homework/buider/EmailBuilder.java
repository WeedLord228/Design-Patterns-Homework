package homework.buider;

import java.util.ArrayList;

class EmailBuilder {
    private ArrayList<String> recievers;
    private String content;
    private String topic = "";

    EmailBuilder(String reciever, String content) {
        recievers = new ArrayList<String>();
        recievers.add(reciever);
        this.content = content;
    }

    EmailBuilder addReciever(String reciever) {
        this.recievers.add(reciever);
        return this;
    }

    EmailBuilder setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    Email build() {
        return new Email(recievers, content, topic);
    }

}
