import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        StepTracker.createDatabase();
        int userInput = scanner.nextInt();
        while (userInput != 0) {
            if (userInput == 1){
                StepTracker.dailyEntry();
                printMenu();
                userInput = scanner.nextInt();
            } else if (userInput == 2){
                StepTracker.monthStats();
                printMenu();
                userInput = scanner.nextInt();
            } else if (userInput == 3){
                StepTracker.changeGoal();
                printMenu();
                userInput = scanner.nextInt();
            } else {
                System.out.println("Please, choose one of the options.");
                printMenu();
                userInput = scanner.nextInt();
            }
        }
        System.out.println("Exiting...");
    }

    public static void printMenu(){
        System.out.println("Choose an option by entering a number:");
        System.out.println("1 - Add daily entry");
        System.out.println("2 - Show month stats");
        System.out.println("3 - Change daily goal");
        System.out.println("0 - Exit");
    }
}
