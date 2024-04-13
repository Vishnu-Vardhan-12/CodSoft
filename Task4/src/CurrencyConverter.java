import java.util.*;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap <Integer, String> CurrencyCodes = new HashMap<>();
        CurrencyCodes.put(1, "USD");
        CurrencyCodes.put(2, "INR");
        CurrencyCodes.put(3, "EUR");
        CurrencyCodes.put(4, "AED");
        CurrencyCodes.put(5, "JPY");

        String fromCode, toCode;

        double amount;
        System.out.println("\n\n WELCOME TO CURRENCY CONVERTER");

        System.out.println("Currency converting from?");
        System.out.println("1.USD (US Dollar)\n2.INT (Indian Rupees) \n3.EUR (Europes) \n4.AED (Dubai) \n4.JPY (Japan)");
        fromCode = CurrencyCodes.get(sc.nextInt());
        System.out.println("Currency converting to?");
        System.out.println("1.USD (US Dollar)\n2.INT (Indian Rupees) \n3.EUR (Europes) \n4.AED (Dubai) \n4.JPY (Japan)");
        toCode = CurrencyCodes.get(sc.nextInt());

        System.out.println("Amount to be converted?");
        amount = sc.nextFloat();

    }
}
