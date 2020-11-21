import java.time.LocalDate;
import java.util.Scanner;

public class CalcIngin {
    public static void main(String[] args) {
        // now i am going to declare some variable that will some data...//
        /// the first val will be the leftVal ..
        double[] leftVal = { 100.00d, 20.00, 30d, 40d };
        /// the second val...
        double[] rightVal = { 10d, 5.4d, 4.45d, 1.1d };
        /// for the option to chose...
        char[] opCode = { 'a', 's', 'm', 'd' };
        // to hendle the result of the code we are going to declare the result
        // variable..//
        double[] result = new double[opCode.length];
        /*
         * now i am going to check ar the args string array have any data or not
         */
        if (args.length == 0) {
            System.out.println("nothing heir");
            /*
             * now i am goiing to create a mathod that will hendle the logic behid the
             * calculation
             */
            for (int i = 0; i < opCode.length; i++) {
                result[i] = calCulate(leftVal[i], rightVal[i], opCode[i]);
            }
            for (double d : result) {
                System.out.println(d);
            }
        } else if (args.length == 1 && args[0].equals("interactive")) {
            hendleIneractive();
        } else if (args.length == 3) {
            // hendleArgsValue(args);
            performdOperation(args);
        } else {
            System.out.println("the symbol is out of reach");
        }
        // to hendle if of the row of the array we are going to use the for loop..

    }

    private static void hendleIneractive() {
        System.out.println("Enter some value");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String[] part = userInput.split(" ");
        performdOperation(part);

    }

    private static void performdOperation(String[] part) {
        char opCode = opCodeFromString(part[0]);
        if (opCode == 'w') {
            whenTheCalculate(part);
        } else {
            double leftVal = performWord(part[1]);
            double rightVal = performWord(part[2]);

            double resutl = calCulate(leftVal, rightVal, opCode);
            desplayResult(opCode, leftVal, rightVal, resutl);
        }

    }

    private static void whenTheCalculate(String[] part) {
        LocalDate startDate = LocalDate.parse(part[1]);
        long daysToAdd = (long) performWord(part[2]);
        LocalDate newDate = startDate.plusDays(daysToAdd);
        String output = String.format("%s plus %d days is %s", startDate, daysToAdd, newDate);
        System.out.println(output);
    }

    private static void desplayResult(char opCode, double leftVal, double rightVal, double resutl) {
        char ymbol = symbolFrom(opCode);
        // StringBuilder symbol = new StringBuilder();
        /*
         * symbol.append(leftVal); symbol.append(" "); symbol.append(ymbol);
         * symbol.append(" "); symbol.append(rightVal); symbol.append(" ");
         * symbol.append("="); symbol.append(resutl); String output = symbol.toString();
         */
        String output = String.format("%.0f %c %.0f = %.0f", leftVal, ymbol, rightVal, resutl);

        System.out.println(output);
    }

    private static char symbolFrom(char opCode) {
        char[] symbol = { '+', '-', '*', '/' };
        char[] opCodes = { 'a', 's', 'm', 'd' };
        char symbols = ' ';
        for (int i = 0; i < opCodes.length; i++) {
            if (opCode == opCodes[i]) {
                symbols = symbol[i];
                break;
            }
        }
        return symbols;
    }

    private static double performWord(String string) {
        String[] word = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        double value = -1d;
        for (int i = 0; i < word.length; i++) {
            if (string.equals(word[i])) {
                value = i;
                break;
            }
        }
        if (value == -1d) {
            value = Double.parseDouble(string);
        }
        return value;
    }

    private static char opCodeFromString(String string) {
        char opCode = string.charAt(0);
        return opCode;
    }

    private static void hendleArgsValue(String[] i) {
        double leftVal = Double.parseDouble(i[1]);
        double rightVal = Double.parseDouble(i[2]);
        char opCode = i[0].charAt(0);
        double result = calCulate(leftVal, rightVal, opCode);
        System.out.println(result);
    }

    private static double calCulate(double leftVal, double rightVal, char opCode) {
        double result = 0;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = rightVal != 0 ? leftVal * rightVal : rightVal;
                break;
            case 'd':
                result = leftVal / rightVal;
        }
        return result;
    }

}
