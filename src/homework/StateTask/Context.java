package homework.StateTask;

import javax.swing.plaf.PanelUI;

public class Context {
    private State state;
    private String document;
    private String device;
    private int cash;

    public void readCash(Integer cash)
    {
        state.readCash(this,cash);
    }

    public void chooseDevice(String device)
    {
        state.chooseDevice(this,device);
    }
    public void chooseDoc(String doc)
    {
        state.chooseDoc(this, doc);
    }
    public void printDoc()
    {
        state.printDoc(this);
    }
    public void cashOut()
    {
        state.cashOut(this);
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
