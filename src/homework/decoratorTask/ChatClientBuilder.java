package homework.decoratorTask;

public class ChatClientBuilder {
    ChatClient decoratee;

    public ChatClientBuilder(ChatClient chatClient)
    {
        this.decoratee = chatClient;
    }

    public ChatClientBuilder withContentEncoding()
    {
        decoratee = new EncodingDecorator(decoratee);
        return this;
    }

    public ChatClientBuilder withHiddenNames()
    {
        decoratee = new PrivacyDecorator(decoratee);
        return this;
    }

    public ChatClient build()
    {
        return decoratee;
    }



}
