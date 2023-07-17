import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        boolean endProgram = true;
        while (endProgram) {
            System.out.println("Выберите действие: 1-деление, 2-вычитание, 3-возведение в квадрат, 4-завершить(выйти)");
            try {
                int number = scanner.nextInt();
                if (number==4){
                    endProgram =false;
                }
                if (number<0){
                    throw new RuntimeException();
                }
                boolean backToMainMenu = true;
                while (backToMainMenu){
                switch (number) {
                    case 1:
                        double result;
                        System.out.println("Введите два числа или выйдите в главное меню(b)");
                        try {
                            String input = scanner.next();
                            if (input.equalsIgnoreCase("b")){
                                backToMainMenu =false;
                            }else {

                            double number1 = Double.parseDouble(input);
                            double number2 = scanner.nextDouble();
                            if (number2==0){
                                throw new RuntimeException();
                            }
                            result = Division.divisionOfTwoNumbers(number1, number2);
                            System.out.println("Ответ: " + decimalFormat.format(result));
                        }}catch (InputMismatchException e){
                            System.out.println("Неверный символ. Пожалуйста, введите число.");
                            scanner.next();
                        }catch (RuntimeException e){
                            System.out.println( "Неверное значение. Пожалуйста, введите число отличное от нуля.");
                        }
                        break;
                    case 2:
                        double result1;
                        System.out.println("Введите два числа или выйдите в главное меню(b)");
                        try {
                            String input = scanner.next();
                            if (input.equalsIgnoreCase("b")){
                                backToMainMenu =false;
                            }else {
                            double number3 = Double.parseDouble(input);
                            double number4 = scanner.nextDouble();
                            result1 = Subtraction.subtractionOfTwoNumbers(number3, number4);
                            System.out.println("Ответ: " + decimalFormat.format(result1));
                        }}catch (InputMismatchException e){
                            System.out.println("Неверный символ. Пожалуйста, введите число.");
                            scanner.next();
                        }
                        break;
                    case 3:
                        double result2;
                        System.out.println("Введите число или выйдите в главное меню(b)");
                        try {
                            String input = scanner.next();
                            if (input.equalsIgnoreCase("b")){
                                backToMainMenu =false;
                            }else {
                            double number5 = Double.parseDouble(input);
                            result2 = Squaring.squaringANumber(number5);
                            System.out.println("Ответ: " + decimalFormat.format(result2));
                        }}catch (InputMismatchException e){
                            System.out.println("Неверный символ. Пожалуйста, введите число.");
                            scanner.next();
                        }
                    break;
                }}


            } catch (InputMismatchException e) {
                System.out.println("Неверный символ. Пожалуйста, введите число.");
                scanner.next();
            }catch (RuntimeException e){
                System.out.println("Неверное значение. Пожалуйста, введите положительное число.");
            }
        }
    }
}