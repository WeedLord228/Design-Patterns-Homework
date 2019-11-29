package homework.StateTask;

import java.sql.SQLTransactionRollbackException;

public class BeginningState implements State {

    @Override
    public void readCash(Context context, Integer cash) {
        context.setCash(cash);
        System.out.println("Вы внесли сумму денег равную " + cash);
        context.setState(new ChooseDeviceState());
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
        System.out.println("то недоступная операция на данном этапе");
    }

    @Override
    public void cashOut(Context context) {
        System.out.println("то недоступная операция на данном этапе");
    }
}
