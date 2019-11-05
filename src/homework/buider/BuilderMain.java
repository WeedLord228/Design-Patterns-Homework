package homework.buider;

public class BuilderMain {
    public static void main(String[] args) {
        Email emailWithoutTopic = new EmailBuilder()
                .addReciever("Паша")
                .setContent("Привет")
                .build();


        System.out.println("Письмо без темы с одним получателем:");
        printEmail(emailWithoutTopic);
        System.out.println();

        Email emailWithTopic = new EmailBuilder()
                .addReciever("Леша")
                .addReciever("Миша")
                .addReciever("Саша")
                .setContent("Приглашаю на свой день рождения!")
                .setTopic("День рождения")
                .build();

        System.out.println("Письмо с темой и несколькими получателями:");
        printEmail(emailWithTopic);

    }

    protected static void printEmail(Email email) {
        String recievers = "";
        if (email.getRecievers().size() == 1)
            recievers = email.getRecievers().get(0);
        else for (String r : email.getRecievers())
            recievers += r + " ";

        System.out.println("To: " + recievers);
        System.out.println(email.getTopic());
        System.out.println(email.getContent());
    }
}
