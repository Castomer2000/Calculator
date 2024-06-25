import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static double getDouble() {
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("Incorrect input");
            scanner.next();
            number = getDouble();
        }
        return number;
    }

    public static char getOperation() {
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Unacceptable operation");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static double calc(double number1, double number2, char operation) {
        double res = 0.0;
        switch (operation) {
            case '+':
                res = number1 + number2;
                break;
            case '-':
                res = number1 - number2;
                break;
            case '*':
                res = number1 * number2;
                break;
            case '/':
                if (number2 == 0) {
                    System.out.println("Error");
                } else {
                    res = number1 / number2;
                }
                break;
            default: {
                System.out.println("Operation not recognized");
                return calc(number1, number2, getOperation());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        boolean status = true;
        while (status) {
            double number1 = getDouble();
            char operation = getOperation();
            if (operation == 'C'){
                break;
            }
            double number2 = getDouble();
            System.out.println(calc(number1, number2, operation));
        }
    }
}