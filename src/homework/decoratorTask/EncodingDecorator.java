package homework.decoratorTask;

public class EncodingDecorator extends ChatDecoratorBase {
    public EncodingDecorator(ChatClient chatClient) {
        super(chatClient);
    }

    public void encode(Message message)
    {
        message.setContent("///строка закодирована ///"+message.getContent() + "(строка была закодирована)");
        System.out.println("Закодировано содержимое сообщения номер " +message.getNumber());
    }

    public Message decode(Message message)
    {
        if (message.getContent().startsWith("///")) {
            message.setContent(message.getContent().split("///")[2]);
            System.out.println("Декодировано содержимое сообщения номер " + message.getNumber());
            return message;
        }
        return message;
    }

    @Override
    public void sendMessage(Message message) {
        encode(message);
        super.sendMessage(message);
    }

    @Override
    public Message recieveMessage()
    {
        return decode(super.recieveMessage());
    }




}