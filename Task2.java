import java.util.*;
public class Task2 {
    public static int EnterMarks(int NumberOfSubjects, int sub){
        if(NumberOfSubjects == 0){
            System.out.println("You have succesfuly entered marks for all the subjects.");
            return 0;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the marks obtained in the subject "+sub+" (from 0 to 100): " );
        int marks = sc.nextInt();
        return marks + EnterMarks(NumberOfSubjects-1, sub+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of subject: ");
        int NumberOfSubjects = sc.nextInt();
        int totalMarks = EnterMarks(NumberOfSubjects, 1);
        System.out.println("\n\nYour total marks of "+NumberOfSubjects+" subjects are: "+totalMarks);

        float Percentage = totalMarks / NumberOfSubjects;
        System.out.println("Percentage of the marks is "+Percentage);
        Grade(Percentage);
    }
    public static void Grade(float Percentage){
        if(Percentage <= 100 && Percentage >=95){
            System.out.println("You have obtained A+ Grade");
        }else if(Percentage > 90 && Percentage <95){
            System.out.println("You have obtained A Grade");
        }
        else if(Percentage > 75 && Percentage <=90){
            System.out.println("You have obtained B Grade");
        }
        else if(Percentage > 60 && Percentage <=75){
            System.out.println("You have obtained C Grade");
        }
        else if(Percentage > 45 && Percentage <=60){
            System.out.println("You have obtained D Grade");
        }
        else if(Percentage >30 && Percentage <=45){
            System.out.println("You have obtained E Grade");
        }
        else if(Percentage<=30){
            System.out.println("OOPS! you have failed");
        }
    }
}
