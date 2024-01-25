import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter first number (1-99): ");
                int num1 = validateInput(scanner.nextInt());

                System.out.print("Enter second number ( 1-99): ");
                int num2 = validateInput(scanner.nextInt());

                System.out.print("Enter operator (+, -, *, /): ");
                char operator = scanner.next().charAt(0);

                double result = 0;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = (double) num1 / num2; // Cast to double for division
                        } else {
                            throw new ArithmeticException("Division by zero");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator");
                }

                System.out.println("Result: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter two-digit numbers between 10 and 99.");
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("\nDo you want to perform another calculation? (yes/no): ");
            if (!scanner.next().equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }

    // Method to validate input for two-digit numbers between 10 and 99
    private static int validateInput(int number) {
        if (number < 10 || number > 99) {
            throw new NumberFormatException("Invalid input. Please enter two-digit numbers between 10 and 99.");
        }
        return number;
    }
}
