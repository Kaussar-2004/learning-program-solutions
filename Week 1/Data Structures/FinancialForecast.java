import java.util.Scanner;

public class FinancialForecast {

    public static double forecastValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return forecastValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Financial Forecast Calculator ===");

        while (true) {
            System.out.print("Enter present value (in rupees): ");
            double present = sc.nextDouble();

            System.out.print("Enter annual growth rate (in percent): ");
            double ratePercent = sc.nextDouble();
            double growthRate = ratePercent / 100;

            System.out.print("Enter number of years: ");
            int years = sc.nextInt();

            if (present < 0 || ratePercent < 0 || years < 0) {
                System.out.println("Please enter non-negative values for all inputs.");
                continue;
            }

            double future = forecastValue(present, growthRate, years);
            System.out.printf("Projected value after %d years: ₹%.2f\n", years, future);

            System.out.print("Do you want to forecast again? (yes/no): ");
            String choice = sc.next().toLowerCase();
            if (!choice.equals("yes")) {
                System.out.println("Thank you for using the Financial Forecast Calculator!");
                break;
            }
        }

        sc.close();
    }
}
