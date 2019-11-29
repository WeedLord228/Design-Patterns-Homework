package homework.StateTask;

public class ChooseDocState implements State {
    @Override
    public void readCash(Context context, Integer cash) {
        System.out.println("то недоступная операция на данном этапе");
    }

    @Override
    public void chooseDevice(Context context, String device) {
        System.out.println("то недоступная операция на данном этапе");
    }

    @Override
    public void chooseDoc(Context context, String doc) {
        context.setDocument(doc);
        System.out.println("Текущий документ: " + doc);
        context.setState(new PrintState());
    }

    @Override
    public void printDoc(Context context) {
        System.out.println("то недоступная операция на данном этапе");
    }

    @Override
    public void cashOut(Context context) {
        System.out.println("то недоступная операция на данном этапе");
    }
}
