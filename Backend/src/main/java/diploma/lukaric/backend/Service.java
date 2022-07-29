package diploma.lukaric.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;

@org.springframework.stereotype.Service
public class Service {
    private final List<Question> questions = new ArrayList<>();
    public ArrayList<ResponseModel> validateSQLStatement(String statement, Question question){
        System.out.println("tip: " + question.getType());
        System.out.println("dobili smo: " + statement);

        ArrayList<ResponseModel> list = executeStatement(statement);

        return list;
    }

    public boolean checkIfStatementIsCorrect(Question question, ArrayList<ResponseModel> list) {

        ArrayList<ResponseModel> correctAnswer = executeStatement(question.getCorrectStatement());
        assert correctAnswer != null;

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < correctAnswer.size(); i++){
            if(correctAnswer.get(i).getName() == "NEW LINE")
                str.append("\n");
            else
                str.append(correctAnswer.get(i).getText()).append("   ");
        }

        question.setAnswer(String.valueOf(str));

        if(correctAnswer.size() != list.size()){
            return false;
        }

        int correctCounter = 0;
        for (int i = 0; i < correctAnswer.size(); i++){
            if(correctAnswer.get(i).getText().equals(list.get(i).getText()))
                correctCounter++;
        }
        return correctCounter == correctAnswer.size();

    }

    public int checkStatementForHavingInjection(String statement) {
        // if statement does not have ;
        if(!statement.contains(";")){
            System.out.println("Injection detected: Missing ';'.");
            return 1111;
        }
        // if statement contains ; more than once
        else if(statement.length() - statement.replaceAll(";","").length() > 1) {
            System.out.println("Injection detected: Detected ';' more then once.");
            return 1112;
        }
        // if statement contains DROP
        else if(statement.contains("DROP")){
            System.out.println("Injection detected: Detected 'DROP'.");
            return 1113;
        }
        return 1110;
    }

    private ArrayList<ResponseModel> executeStatement(String statement){
        ArrayList<ResponseModel> list = new ArrayList<>();
        Connection connection;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/course","luka", "luka");
            System.out.println("Successfully Connected.");

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery( statement);

            List<String> columnNames = new ArrayList<>();

            //  Get names of columns from ResultSet
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++){
                columnNames.add(resultSetMetaData.getColumnLabel(i));
            }

            //  Get data from query and fill the list with ResponseModels
            while (rs.next()) {
                List<Object> rowData = new ArrayList<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    rowData.add(rs.getObject(i));
                }

                for (int colIndex = 0; colIndex < resultSetMetaData.getColumnCount(); colIndex++) {
                    list.add(new ResponseModel(columnNames.get(colIndex),rowData.get(colIndex).toString()));

                }
                list.add(new ResponseModel("NEW LINE",""));
            }

            //  Remove last element of list because last element is new empty line
            list.remove(list.size() - 1);

            rs.close();

            stmt.close();

            connection.close();

        } catch ( Exception e ) {

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            list.add(new ResponseModel("ERROR", e.getMessage()));

        }

        return list;
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
                    questions.add(new Question(line[1], line[3], line[5], line[7], null));
                }
                else if(line[7].equals(filter)){
                    questions.add(new Question(line[1], line[3], line[5], line[7], null));
                }

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Unable to read file");
            questions.add(new Question("-1", "Unable to read file", "ERROR", "ERROR", null));
        }
    }
}
