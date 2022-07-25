package diploma.lukaric.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;

@org.springframework.stereotype.Service
public class Service {
    private List<Question> questions = new ArrayList<>();
    public ArrayList<ResponseModel> validateSQLStatement(String statement, Question question){
        System.out.println("tip: " + question.getType());
        System.out.println("dobili smo: " + statement);

        if(checkStatementForHavingInjection(statement)){
            return null;
        }

        ArrayList<ResponseModel> list = executeStatement(statement);

        System.out.println("Data Retrieved Successfully ..");

        return list;
    }

    private boolean checkStatementForHavingInjection(String statement) {
        // if statement does not have ;
        if(!statement.contains(";")){
            System.out.println("Injection detected: Missing ';'.");
            return true;
        }
        // if statement contains ; more than once
        else if(statement.length() - statement.replaceAll(";","").length() > 1) {
            System.out.println("Injection detected: Detected ';' more then once.");
            return true;
        }
        // if statement contains DROP
        else if(statement.contains("DROP")){
            System.out.println("Injection detected: Detected 'DROP'.");
            return true;
        }
        return false;
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

            // get names of columns from ResultSet
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++){
                columnNames.add(resultSetMetaData.getColumnLabel(i));
            }

            while (rs.next()) {
                List<Object> rowData = new ArrayList<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    rowData.add(rs.getObject(i));
                }

                for (int colIndex = 0; colIndex < resultSetMetaData.getColumnCount(); colIndex++) {
                    list.add(new ResponseModel(columnNames.get(colIndex),rowData.get(colIndex).toString()));
                }
            }

            rs.close();

            stmt.close();

            connection.close();

        } catch ( Exception e ) {

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return null;

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
