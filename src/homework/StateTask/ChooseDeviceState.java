package homework.StateTask;

public class ChooseDeviceState implements State {
    @Override
    public void readCash(Context context, Integer cash) {
        System.out.println("то недоступная операция на данном этапе");
    }

    @Override
    public void chooseDevice(Context context, String device) {
        context.setDevice(device);
        context.setState(new ChooseDocState());
    }

    @Override
    public void chooseDoc(Context context, String doc) {
        System.out.println("то недоступная операция на данном этапе");
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
