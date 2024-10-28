import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose the types of data to analysis:");
        System.out.println("0 - Rainfall only");
        System.out.println("1 - Rainfall and Sunshine");
        System.out.println("2 - Rainfall, Sunshine and Minimum Temperature");
        System.out.println("3 - All data");
        System.out.println("Enter your selection:");
        String choice = input.next();

        ArrayList<String> files = new ArrayList<>();

        int cityChoice;
        do {
            System.out.println("Pick a city / cities (One at a time - 'EXIT' to finish):");
            System.out.println("1 - Auckland");
            System.out.println("2 - Hamilton");
            System.out.println("3 - Gisborne");
            System.out.println("4 - Masterton");
            System.out.println("5 - Nelson");
            System.out.println("9 - EXIT");
            cityChoice = input.nextInt();
            switch(cityChoice) {
                case 1:
                    files.add("Auckland.txt");
                    break;
                case 2:
                    files.add("Hamilton.txt");
                    break;
                case 3:
                    files.add("Gisborne.txt");
                    break;
                case 4:
                    files.add("Masterton.txt");
                    break;
                case 5:
                    files.add("Nelson.txt");
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        } while(cityChoice != 9);

        switch(choice) {
            case "0":
                Statistics s = new Statistics(ClimateType.RAINFALL);
                for(String file : files) {
                    s.process(file);
                }
                s.displayTable();
                break;
            case "1":
                Statistics s1 = new Statistics(ClimateType.RAINFALL_SUNSHINE);
                for(String file : files) {
                    s1.process(file);
                }
                s1.displayTable();
                break;
            case "2":
                Statistics s2 = new Statistics(ClimateType.RAINFALL_SUNSHINE_TEMPERATURE);
                for(String file : files) {
                    s2.process(file);
                }
                s2.displayTable();
                break;
            case "3":
                Statistics s3 = new Statistics(ClimateType.ALL);
                for(String file : files) {
                    s3.process(file);
                }
                s3.displayTable();
                break;
        }
    }
}
