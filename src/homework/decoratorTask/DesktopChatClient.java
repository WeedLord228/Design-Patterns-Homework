package homework.decoratorTask;

import java.util.LinkedList;

public class DesktopChatClient implements ChatClient {
    LinkedList<Message> messages = new LinkedList<>();

    @Override
    public void sendMessage(Message message) {
        messages.push(message);
    }

    @Override
    public Message recieveMessage() {
        return messages.poll();
    }
}
