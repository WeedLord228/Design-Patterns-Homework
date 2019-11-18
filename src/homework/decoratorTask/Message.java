package homework.decoratorTask;

public class Message {
    private int number;

    private String author;

    private String reciever;

    private String content;

    public Message(String author, String reciever, String content,int number) {
        this.author = author;
        this.reciever = reciever;
        this.content = content;
        this.number = number;
    }

    public void printMessage()
    {
        System.out.println("To: " + reciever);
        System.out.println("From: " + author);
        System.out.println("Content: " + content);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
