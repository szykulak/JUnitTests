package app;

import java.util.ArrayList;

public class PeselList {

    private ArrayList<String> peselList;

    private static PeselList listInstance = new PeselList();



    public static PeselList getInstance() {
        return listInstance;
    }
    private PeselList() {

        peselList = new ArrayList<String>();
    }

    public ArrayList<String> getPeselList() {
        return peselList;
    }


}
