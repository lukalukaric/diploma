package diploma.lukaric.backend;

import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.ArrayList;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/api")
public class RestController {
    private final Service service;

    public RestController(Service service) {
        this.service = service;
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/validate")
    public RestResponse validateSQLStatement(@RequestBody ModelStatementQuestion modelStatementQuestion) {
        String statement = modelStatementQuestion.getStatement();
        Question question = modelStatementQuestion.getQuestion();

        int statusCode = service.checkStatementForHavingInjection(statement);
        if( statusCode != 1110){
            return new RestResponse(statusCode,"Failed check for having injection.", null, null);
        }

        ArrayList<ResponseModel> data = service.validateSQLStatement(statement, question);
        if (data.size() == 1 && data.get(0).getName() == "ERROR")
            return new RestResponse(4000,"ERROR", data, null);
        if(!service.checkIfStatementIsCorrect(question, data))
            return new RestResponse(3000,"NOT MATCHING", data, question.getAnswer());

        return new RestResponse(200,"OK", data, question.getAnswer());
    }

    @GetMapping(path = "/randomQuestion")
    public Question getRandomQuestion() {
        return service.getRandomQuestion();
    }

    @GetMapping(path = "/selectQuestion")
    public Question getSelectQuestion() {
        return service.getSelectQuestion();
    }

    @GetMapping(path = "/aggregateQuestion")
    public Question getAggregateQuestion() {
        return service.getAggregateQuestion();
    }

    @GetMapping(path = "/groupByQuestion")
    public Question getGroupByQuestion() {
        return service.getGroupByQuestion();
    }

    @GetMapping(path = "/orderByQuestion")
    public Question getOrderByQuestion() {
        return service.getOrderByQuestion();
    }

    @GetMapping(path = "/havingQuestion")
    public Question getHavingQuestion() {
        return service.getHavingQuestion();
    }
}
