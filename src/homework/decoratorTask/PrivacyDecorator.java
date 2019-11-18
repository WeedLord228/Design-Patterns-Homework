package homework.decoratorTask;

public class PrivacyDecorator extends ChatDecoratorBase {
    public PrivacyDecorator(ChatClient chatClient) {
        super(chatClient);
    }

    public Message hideNames(Message message)
    {
        message.setAuthor(message.getAuthor().hashCode()+"");
        message.setReciever(message.getReciever().hashCode()+"");

        return message;
    }

    @Override
    public Message recieveMessage()
    {
     return hideNames(super.recieveMessage());
    }

}
