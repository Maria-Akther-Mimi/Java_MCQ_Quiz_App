import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

public class Question {
    static void Question() throws IOException, ParseException {
        System.out.println("Welcome admin! Please create new questions in the question bank.");
        String fileName = "./src/main/resources/quiz.json";
        char choice;
        do {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("./src/main/resources/quiz.json"));
            JSONArray jsonArray = (JSONArray) obj;

            Scanner scan = new Scanner(System.in);

            JSONObject setQuestion = new JSONObject();

            System.out.println("\nPlease Add a Question Here:");
            setQuestion.put("question", scan.nextLine());

            System.out.println("\nEnter Option a:");
            setQuestion.put("Option a", scan.nextLine());
            System.out.println("Enter Option b:");
            setQuestion.put("Option b", scan.nextLine());
            System.out.println("Enter Option c:");
            setQuestion.put("Option c", scan.nextLine());
            System.out.println("Enter Option d:");
            setQuestion.put("Option d", scan.nextLine());
            System.out.println("What is the answer key?");
            setQuestion.put("answerkey", scan.nextLine());

            jsonArray.add(setQuestion);

            FileWriter file = new FileWriter("./src/main/resources/quiz.json");
            file.write(jsonArray.toJSONString());
            file.flush();
            System.out.println("Saved successfully! Do you want to add more questions? (press s for start and q for quit)");
            choice = scan.next().charAt(0);
        }
        while (choice == 's');
    }
}