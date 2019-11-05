package homework.buider;

import java.util.ArrayList;

class EmailBuilder {
//Порядок конструиврования объекта: получатели, содержимое письма, [тема письма]
    public ContentBulder addReciever(String reciever) {
        return new ContentBulder(reciever);
    }

   class ContentBulder {
        private ArrayList<String> recievers;

        public ContentBulder(String reciever) {
            recievers = new ArrayList<String>();
            this.recievers.add(reciever);
        }

        public ContentBulder addReciever(String reciever) {
            recievers.add(reciever);
            return this;
        }

        public FinalBulder setContent(String content) {
            return new FinalBulder(recievers, content);
        }
    }

    class FinalBulder {
        private ArrayList<String> recievers;
        private String content;
        private String topic = "";

        public FinalBulder(ArrayList<String> recievers, String content) {
            this.content = content;
            this.recievers = recievers;
        }

        public FinalBulder addReciever(String reciever) {
            recievers.add(reciever);
            return this;
        }

        public FinalBulder setTopic(String topic) {
            this.topic = topic;
            return this;
        }

        public Email build() {
            return new Email(recievers, content, topic);
        }
    }
}
