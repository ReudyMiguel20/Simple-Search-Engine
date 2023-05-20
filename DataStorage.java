package search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataStorage {
    private ArrayList<String> peopleData;
    private Scanner scanner;

    public DataStorage() {
        this.scanner = new Scanner(System.in);
        this.peopleData = new ArrayList<>();
    }

    public void add(String person) {
        this.peopleData.add(person);
    }

    public int getSize() {
        return this.peopleData.size();
    }

    public void addingMultiplePerson() {
        System.out.println("Enter the number of people:");
        int counterPeople = Integer.parseInt(scanner.nextLine());

        //Adding a person data until the size gets to the desired value 'counterPeople'
        System.out.println("Enter all people:");
        while (getSize() < counterPeople) {
            String userInput = scanner.nextLine();
            add(userInput);
        }

    }

    public void searchQuery() {
            System.out.println("\nEnter a name or email to search all suitable people.");
            String userInput = scanner.nextLine();
            searchPeople(userInput);
    }

    public void searchPeople(String userInput) {
        boolean foundData = false;
        StringBuilder sb = new StringBuilder();

        //Iterating the list searching for the inputted data
        for (String x : this.peopleData) {
            if (x.toLowerCase().trim().contains(userInput.toLowerCase().trim())) {
                sb.append(x).append("\n");
                foundData = true;
            }
        }

        if (!foundData) {
            //Printing this if the passed data is not found on the list
            System.out.println("No matching people found.");
        } else {
            //Removing the last newline on the StringBuilder
            sb.deleteCharAt(sb.length() - 1);

            //Printing the found data
            System.out.println(sb.toString());
        }

    }

    public void printAllPeople() {
        if (this.peopleData.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();

        //Iterating over the list and appending the values to the StringBuilder
        for (String x : this.peopleData) {
            sb.append(x).append("\n");
        }

        //Removing the last newline on the StringBuilder before printing it
        sb.deleteCharAt(sb.length() - 1);
        System.out.println("\n=== List of people ===");
        System.out.println(sb.toString());
    }

    public void importFile() throws IOException {
        String line = "";
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("names.txt"));

            while ((line = reader.readLine()) != null) {
                add(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
