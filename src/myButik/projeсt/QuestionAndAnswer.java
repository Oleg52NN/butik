package myButik.projeсt;

import java.util.Scanner;

public class QuestionAndAnswer {
    final static String choice = " (да/нет)";

    public static boolean questionAndAnswer(String question, String answerYes, String answerNo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question + choice);
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("да")) {
                System.out.println(answerYes);
                return true;
            }
            if (s.equals("нет")) {
                System.out.println(answerNo);
                return false;
            }
        }
    }
}
