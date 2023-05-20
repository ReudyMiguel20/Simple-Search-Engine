package search;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Initializing Variables
        DataStorage dataStorage = new DataStorage();
        UserInterface UI = new UserInterface(dataStorage);

        UI.start();
    }
}