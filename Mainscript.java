import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Mainscript {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(); // remove only for nvim debugging
        MainMenu();

    }

    private static void MainMenu() {
        int userChoice = 0;
        System.out.println("What would you like to do: \n(1) List recorded subject \n(2) New Subject Entry");
        System.out.print(": ");
        userChoice = scanner.nextInt();
        scanner.nextLine(); // catch whitespace
        switch (userChoice) {
            case 1:
                FindSubject();
                break;
            case 2:
                System.out.print("Enter Subject Name: ");
                String fileName = scanner.nextLine();
                CreateNewSubjectEntry(fileName);
                SubjectMenu(fileName);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    private static void SubjectMenu(String fileName) {
        int userChoice = 0;
        System.out.println("Opening " + fileName + " menu...");
        System.out.println(
                "What would you like to do with " + fileName
                        + ":\n (1) Add Cards (2) Edit Cards (3) View Cards (4) Quiz");
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                AddCards(fileName);
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }

    }

    // TODO: add card function

    // add new card entry to a subject
    private static void AddCards(String fileName) {
        Path filePath = Paths.get("subjects//" + fileName + ".txt");
        boolean quit = true;
        while (quit) {
            String question = "", answer = "";
            System.out.println("Enter your Question: ");
            question = scanner.nextLine();
            System.out.println("Enter your Answer: ");
            answer = scanner.nextLine();
            String quesAns = question + "}" + answer;
            byte[] quesAnsToBytes = quesAns.getBytes();
            OutputStream cardCreate = null;
            try {
                cardCreate = new BufferedOutputStream(Files.newOutputStream(filePath, StandardOpenOption.APPEND));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(cardCreate));
                cardCreate.write(quesAnsToBytes);
                cardCreate.flush();
                cardCreate.close();
                System.out.println("Card Entry has been added...");
            } catch (Exception e) {
                System.out.println("Error Occured while adding new Card Entry: " + e.getMessage());
            }
            System.out.println("'q' to quit");

        }
    }

    // Finds the subject if it exist
    private static void FindSubject() {

    }

    // Makes new txt file to store subject reviewer entries
    private static void CreateNewSubjectEntry(String fileName) {
        System.out.println("Creating new Subjecy Entry named " + fileName + "...");
        // change path to "subjects\\" + fileName + ".txt" when in windows
        Path filePath = Paths.get("subjects//" + fileName + ".txt");
        OutputStream fileCreate = null;
        try {
            fileCreate = new BufferedOutputStream(Files.newOutputStream(filePath, StandardOpenOption.CREATE));
            fileCreate.flush();
            fileCreate.close();
            System.out.println(fileName + " Subject Entry has been added...");
        } catch (Exception e) {
            System.out.println("Error Occured while creating new Subject Entry: " + e.getMessage());
        }
    }

    private static void OpenSubjectEntry(String fileName) {
        System.out.println("Opening Subject Entry named " + fileName + "...");
        Path filePath = Paths.get(fileName + ".txt");

    }

}
