import java.util.*;

public class Task3 {
    public static void ATMInterface(int option, ATM machine) {
        Scanner op = new Scanner(System.in);
        if (option == 1) {
            System.out.println("Available balance is " + machine.checkBalance());
        } else if (option == 2) {
            System.out.println("Enter the amount to deposit: ");
            int amount = op.nextInt();
            machine.deposit(amount);
            System.out.println("Thank you for depositing money.");
        } else if (option == 3) {
            System.out.println("Enter the amount to withdraw");
            int amount = op.nextInt();
            if(machine.withdrawing(amount)){
                System.out.println("You may run out of the money.");
                System.out.println("Please check your balance and the withdrawing amount.");
                return;
            }
            System.out.println("Thank you for withdrawing money");
        }
        else{
            System.out.println("Invalid choice! please enter a number from 1 to 4 only.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM machine = new ATM();
        int num = 0;
        System.out.println("\t\t\tWELCOME TO ATM");
        while (num < 4) {
            System.out.println("\n\n1. Check Balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("\nChoose an option");
            int option = sc.nextInt();
            ATMInterface(option, machine);
            num = option;
            if(option > 4 ){
                System.out.println("\n\nDo you want to continue to ATM ?");
                System.out.println("Enter 1 to contine. \nEnter any key to exit.");
                int contine = sc.nextInt();
                if(contine == 1){
                    num = 0;
                }else{
                    break;
                }
            }
        }
        System.out.println("Thank Your for using ATM");
    }
}

class ATM {
    private int balance = 0;

    public int checkBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean withdrawing(int amount) {
        if(balance == 0){
            System.out.println("\nOOPS! your can't withdraw them money.");
            return true;
        }
        else if(balance-amount<0){
            System.out.println("OOPS! your can't withdraw them money.");
            return true;
        }
        balance -= amount;
        return false;
    }
}