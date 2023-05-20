package search;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    private DataStorage dataStorage;
    private Scanner scanner;

    public UserInterface(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
        this.scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        boolean userWantToExit = false;
        this.dataStorage.importFile();

        //Implementing the menu inside a while loop
        while (!userWantToExit) {
            System.out.println("""
                                        
                    === Menu ===
                    1. Find a person
                    2. Print all people
                    0. Exit""");

            switch (scanner.nextLine()) {
                case "1" -> this.dataStorage.searchQuery();
                case "2" -> this.dataStorage.printAllPeople();
                case "0" -> {
                    userWantToExit = true;
                    System.out.println("\nBye!");
                }
                default -> System.out.println("\nIncorrect option! Try again.");
            }
        }
    }
}
