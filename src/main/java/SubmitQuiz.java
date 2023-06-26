import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import java.util.Random;
import java.util.Scanner;

public class SubmitQuiz {
    static void submitQuiz() throws IOException, ParseException {
        String fileName = "./src/main/resources/quiz.json";
        Scanner scan = new Scanner(System.in);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/main/resources/quiz.json"));
        JSONArray jsonArray = (JSONArray) obj;

        System.out.println("Welcome to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. " +
                "Are you ready? Press 's' for start.");

        char ch = scan.next().charAt(0);
        while(ch == 's'){
            int count = 0;
            for (int i = 1; i <= 10; i++) {

                Random rand = new Random();
                int pos = rand.nextInt(jsonArray.size());
                JSONObject quesAns = (JSONObject) jsonArray.get(pos);

                String question = (String) quesAns.get("question");
                String option1 = (String) quesAns.get("Option a");
                String option2 = (String) quesAns.get("Option b");
                String option3 = (String) quesAns.get("Option c");
                String option4 = (String) quesAns.get("Option d");
                String answerkey = (String) quesAns.get("answerkey");

                System.out.println("\n[Question " + i + "] " +question);
                System.out.println("a. " + option1);
                System.out.println("b. " + option2);
                System.out.println("c. " + option3);
                System.out.println("d. " + option4);


                String answer = scan.next();
                if (answer.equals(answerkey)) {
                    count++;
                }
            }
            if(count >= 8) {
                System.out.println("\nExcellent! You have got " + count + " out of 10");
            } else if (count >= 5) {
                System.out.println("\nGood. You have got "+ count +" out of 10");
            } else if (count >= 2) {
                System.out.println("\nVery poor! You have got "+ count +" out of 10");
            } else {
                System.out.println("\nVery sorry you are failed. You have got "+ count +" out of 10");
            }

            System.out.println("\nWould you like to start again? press s for start or q for quit");
            ch = scan.next().charAt(0);
        }
    }
}