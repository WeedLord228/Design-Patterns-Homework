package homework.StateTask;

public class PrintState implements State {
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
        System.out.println("то недоступная операция на данном этапе");
    }

    @Override
    public void printDoc(Context context) {
        System.out.println("Документ " + context.getDocument() +" был напечатан");
        context.setCash(context.getCash() - 10);
        context.setState(new FinalState());
    }

    @Override
    public void cashOut(Context context) {
        System.out.println("то недоступная операция на данном этапе");
    }
}
