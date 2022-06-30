package diploma.lukaric.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@org.springframework.stereotype.Service
public class Service {

    public void validateSQLStatement(String statement){
        System.out.println("dobili smo: " + statement);
    }

    public Question getRandomQuestion() {
        List<Question> questions = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/questions.txt");
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\"");
                questions.add(new Question(line[1], line[3], line[5], line[7]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Unable to read file");
            questions.add(new Question("-1", "Unable to read file", "ERROR", "ERROR"));
        }
        int randomNumber = new Random().nextInt(questions.size());
        System.out.println("Returning random question: " + questions.get(randomNumber));
        return questions.get(randomNumber);
    }
}
