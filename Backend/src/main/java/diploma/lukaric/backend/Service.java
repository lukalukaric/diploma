package diploma.lukaric.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;

@org.springframework.stereotype.Service
public class Service {
    private List<Question> questions = new ArrayList<>();
    public void validateSQLStatement(String statement){
        System.out.println("dobili smo: " + statement);
    }
    public Question getSelectQuestion() {
        readQuestionsFile("select");
        int randomNumber = new Random().nextInt(questions.size());
        System.out.println("Returning random question: " + questions.get(randomNumber));
        return questions.get(randomNumber);
    }

    public Question getAggregateQuestion() {
        readQuestionsFile("aggregate");
        int randomNumber = new Random().nextInt(questions.size());
        System.out.println("Returning random question: " + questions.get(randomNumber));
        return questions.get(randomNumber);
    }

    public Question getGroupByQuestion() {
        readQuestionsFile("groupBy");
        int randomNumber = new Random().nextInt(questions.size());
        System.out.println("Returning random question: " + questions.get(randomNumber));
        return questions.get(randomNumber);
    }

    public Question getOrderByQuestion() {
        readQuestionsFile("orderBy");
        int randomNumber = new Random().nextInt(questions.size());
        System.out.println("Returning random question: " + questions.get(randomNumber));
        return questions.get(randomNumber);
    }

    public Question getHavingQuestion() {
        readQuestionsFile("having");
        int randomNumber = new Random().nextInt(questions.size());
        System.out.println("Returning random question: " + questions.get(randomNumber));
        return questions.get(randomNumber);
    }

    public Question getRandomQuestion() {
        readQuestionsFile("random");
        int randomNumber = new Random().nextInt(questions.size());
        System.out.println("Returning random question: " + questions.get(randomNumber));
        return questions.get(randomNumber);
    }

    public void readQuestionsFile(String filter){
        questions.clear();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/questions.txt");
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\"");
                if(filter.equals("random")){
                    questions.add(new Question(line[1], line[3], line[5], line[7]));
                }
                else if(line[7].equals(filter)){
                    questions.add(new Question(line[1], line[3], line[5], line[7]));
                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Unable to read file");
            questions.add(new Question("-1", "Unable to read file", "ERROR", "ERROR"));
        }
    }
}
