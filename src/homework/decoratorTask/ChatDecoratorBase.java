package homework.decoratorTask;

public class ChatDecoratorBase implements ChatClient {

    ChatClient decoratee;

    public ChatDecoratorBase(ChatClient chatClient)
    {
        decoratee = chatClient;
    }

    @Override
    public void sendMessage(Message message) {
        decoratee.sendMessage(message);
    }

    @Override
    public Message recieveMessage() {
        return decoratee.recieveMessage();
    }
}
