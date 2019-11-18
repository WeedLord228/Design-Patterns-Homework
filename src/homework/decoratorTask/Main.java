package homework.decoratorTask;

public class Main {
    public static void main(String[] args) {
        ChatClient chatClient1 = new DesktopChatClient();
        Message message1 = new Message("Vitya", "Misha",
                "The letter about something very important", 1);

        chatClient1.sendMessage(message1);
        chatClient1.recieveMessage().printMessage();

        System.out.println();

        chatClient1 = new ChatClientBuilder(chatClient1)
                .withContentEncoding()
                .withHiddenNames()
                .build();
        chatClient1.sendMessage(message1);
        chatClient1.recieveMessage().printMessage();

    }
}
