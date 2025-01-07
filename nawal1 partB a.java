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

    public static void main(String[] args) {
        // Example usage
        try {
            double baseHourlyRate = 35000; // Input base hourly rate
            int hoursWorked = 50; // Input hours worked

            double totalPayment = calculatePayment(baseHourlyRate, hoursWorked);
            System.out.println("Total Payment: UGX " + totalPayment);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
