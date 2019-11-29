package homework.StateTask;

public interface State {
    public void readCash(Context context,Integer cash);
    public void chooseDevice(Context context, String device);
    public void chooseDoc(Context context, String doc);
    public void printDoc(Context context);
    public void cashOut(Context context);
}
