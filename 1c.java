public class NextAIInc {

    // Method to calculate contractor payment
    public static double calculatePayment(double baseHourlyRate, int hoursWorked) {
        // Validate base hourly rate
        if (baseHourlyRate < 30000) {
            throw new IllegalArgumentException("Error: Base hourly rate must not fall below UGX 30,000.");
        }

        // Validate hours worked
        if (hoursWorked > 72) {
            throw new IllegalArgumentException("Error: Contractors are not allowed to work more than 72 hours per week.");
        }

        double payment;
        if (hoursWorked <= 48) {
            // Calculate payment for up to 48 hours
            payment = hoursWorked * baseHourlyRate;
        } else {
            // Calculate payment for 48 hours plus overtime
            int overtimeHours = hoursWorked - 48;
            payment = (48 * baseHourlyRate) + (overtimeHours * baseHourlyRate * 2);
        }

        return payment;
    }

    // Method to accept base pay and hours worked, calculate and print total pay
    public static void calculateAndPrintTotalPay(double baseHourlyRate, int hoursWorked) {
        try {
            double totalPayment = calculatePayment(baseHourlyRate, hoursWorked);
            System.out.println("Total Weekly Pay: UGX " + totalPayment);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test Cases

        // Contractor A
        System.out.println("Contractor A:");
        calculateAndPrintTotalPay(30000, 51);

        // Contractor B
        System.out.println("\nContractor B:");
        calculateAndPrintTotalPay(20000, 40);

        // Contractor C
        System.out.println("\nContractor C:");
        calculateAndPrintTotalPay(35000, 96);
    }
}
