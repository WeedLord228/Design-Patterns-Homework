package homework.decoratorTask;

import java.util.LinkedList;

public interface ChatClient {
    void sendMessage(Message message);

    Message recieveMessage();
}
