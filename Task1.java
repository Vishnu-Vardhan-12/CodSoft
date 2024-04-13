import java.util.*;
public class Task1 {
    private static int GenarateRandomNumber(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    public static void FindOutNumber(int number, int rounds, int score){
        if(rounds == 0){
            System.out.println("\n\n");
            System.out.println("OOPS! the rounds are completed");
            System.out.println("Your Score is "+score);
            System.out.println("The Genarted number was: " +number);
            return;
        }
        
        System.out.println("\n\nCurrent round number is "+rounds);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a guss (form 1 to 100) : ");
        int EnteredNumber = sc.nextInt();
        if(EnteredNumber == number){
            System.out.println("You have succesfully gussed the number correctly.");
            System.out.println("\t\t\tCONGRATULATIONS!  your score is: "+score);
            return;
        }
        else if(EnteredNumber > number){
            System.out.println("The number entered is  HIGH  then the genarated number.");
            System.out.println("You have "+(rounds-1)+" more rounds to guss the number.");
        }
        else if(EnteredNumber < number){
            System.out.println("The number entered is   LOW   then the genarated number.");
            System.out.println("You have "+(rounds-1)+" more rounds to guss the number.");
        }
        FindOutNumber(number, rounds-1, score-1);
    }
    
    public static void main(String[] args) {
        int number = GenarateRandomNumber();
        Scanner pa = new Scanner(System.in);
        boolean PlayAgain = true;
        int rounds = 5;
        int score = rounds;
        while(PlayAgain){
            System.out.println("\n\n\t\t\t WLLCOME TO NUMBER GUSSING GAME\n\n");
            System.out.println("A random number form 1 to 100 has been genarated sussfully.");
            System.out.println("Now, your task is to find out genarated number.  \n\n");
            System.out.println("You have "+rounds+" rounds to find out the number.");
            FindOutNumber(number, rounds, score);
            System.out.println("\n\nTo play again, enter 'true' ");
            System.out.println("To exit, enter 'false' " );
            PlayAgain = pa.nextBoolean();
        }
        System.out.println("Thank You, for Playing the game.");
    }
}