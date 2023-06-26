import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class MainProject {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        String fileName="./src/main/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;

        System.out.println("Enter your username");
        String username = sc.next();
        System.out.println("Enter your password");
        String password = sc.next();

        JSONObject jsonAdmin = (JSONObject) jsonArray.get(0);


        String unameAdmin = (String) jsonAdmin.get("username");
        String passwordAdmin = (String) jsonAdmin.get("password");

        JSONObject jsonStudent = (JSONObject) jsonArray.get(1);

        String unameStudent = (String) jsonStudent.get("username");
        String passwordStudent = (String) jsonStudent.get("password");

        if(unameAdmin.equals(username) && passwordAdmin.equals(password)) {
            Question.Question();
        }
        else if (unameStudent.equals(username) && passwordStudent.equals(password)) {
            SubmitQuiz.submitQuiz();
        }
        else {
            System.out.println("Given creeds Invalid");
        }
    }
}