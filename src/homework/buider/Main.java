package homework.buider;

class Main {
    protected static void main(String[] args) {
        EmailBuilder emailBuilder = new EmailBuilder("Паша", "Привет");
        Email emailWithoutTopic = emailBuilder.build();

        System.out.println("Письмо без темы с одним получателем:");
        printEmail(emailWithoutTopic);
        System.out.println();

        emailBuilder = new EmailBuilder("Лёша", "Приглашаю на свой день рождения!")
                .addReciever("Миша")
                .addReciever("Саша")
                .setTopic("День рождения");
        Email emailWithTopic = emailBuilder.build();

        System.out.println("Письмо с темой и несколькими получателями:");
        printEmail(emailWithTopic);

    }

    protected static void printEmail(Email email) {
        String recievers = "";
        if (email.getRecievers().size() == 1)
            recievers = email.getRecievers().get(0);
        else for (String r : email.getRecievers())
            recievers += r;

        System.out.println("To: " + recievers);
        System.out.println();
        System.out.println(email.getContent());
    }
}
