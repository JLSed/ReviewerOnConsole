import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.file.*;
import java.util.Scanner;

public class Mainscript {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(); // remove only for nvim debugging
        MainMenu(scanner);

    }

    private static void MainMenu(Scanner scanner) {
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
                "What would you like to do with " + fileName + ": (1) Add Cards (2) Edit Cards (3) View Cards");
        switch (userChoice) {
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }

    }

    // Finds the subject if it exist
    private static void FindSubject() {

    }

    // Makes new txt file to store subject reviewer entries
    private static void CreateNewSubjectEntry(String fileName) {
        System.out.println("Creating new Subjecy Entry named " + fileName + "...");
        Path filePath = Paths.get(fileName + ".txt");
        OutputStream fileCreate = null;
        try {
            fileCreate = new BufferedOutputStream(Files.newOutputStream(filePath, StandardOpenOption.CREATE));
            fileCreate.flush();
            fileCreate.close();
            System.out.println(fileName + " Subject Entry has been added.");
        } catch (Exception e) {
            System.out.println("Error Occured while creating new Subject Entry: " + e.getMessage());
        }
    }

    private static void OpenSubjectEntry(String fileName) {
        System.out.println("Opening Subject Entry named " + fileName + "...");
        Path filePath = Paths.get(fileName + ".txt");

    }

}
