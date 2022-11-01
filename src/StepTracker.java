import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    static HashMap<String,int[]> database = new HashMap<>();
    static String[] months = {"","January","February","March","April","May","June","July", "August",
            "September", "October", "November", "December"};
    static Scanner scanner = new Scanner(System.in);

    static int goal = 10000;

    public static void createDatabase(){
        for (int i = 1; i < 13; i++){
            database.put(months[i],new int[31]);
        }
    }

    public static void dailyEntry() {
        int month = 0;
        while (month < 1 || month > 12) {
            month = chooseMonth();
        }
        int day = 0;
        while (day <1 || day > 30){
            System.out.println("Enter a day by number. A number should be between 1 and 30.");
            day = scanner.nextInt();
        }
        int steps = -1;
        while (steps < 0){
            System.out.println("Enter step count for day " + day + " of month " + months[month] + ". ");
            steps = scanner.nextInt();
        }
        int[] temp = database.get(months[month]);
        temp[day] = steps;

        System.out.println("Success!");
    }

    public static void monthStats() {
        int month = 0;
        while (month < 1 || month > 12) {
            month = chooseMonth();
        }
        int total = 0;
        int max = 0;
        for (int i = 1; i < 31; i++){
            total += database.get(months[month])[i];
            System.out.println("Day " + i + ": " + database.get(months[month])[i]);
            max = Math.max(database.get(months[month])[i], max);
        }
        System.out.println("Total steps: "+ total);
        System.out.println("Max steps: "+ max);
        System.out.println("Median: "+ total/30);
        System.out.println("You have walked "+ Converter.convertKm(total) + " kilometers");
        System.out.println("You have spent "+ Converter.convertKkal(total) + " kkal");
        System.out.println("Your best series is " + SeriesFlexer.seriesFlexer(database.get(months[month]), goal) + " days");

    }

    public static void changeGoal() {
        System.out.println("Enter the changed goal. The current goal is " + goal + ". The goal should be a positive number,");
        goal = scanner.nextInt();
        while (goal <= 0){
            changeGoal();
        }
        System.out.println("The new goal is " + goal);
    }

    public static int chooseMonth(){
        System.out.println("Choose a month by number. A number should be between 1 and 12.");
        for (int i = 1; i < 13; i++){
            System.out.println((i) + " - " + months[i]);
        }
        return scanner.nextInt();
    }}
