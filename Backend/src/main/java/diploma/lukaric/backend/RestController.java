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
        ArrayList<ResponseModel> data = service.validateSQLStatement(modelStatementQuestion.getStatement(), modelStatementQuestion.getQuestion());
        return new RestResponse(200,"OK", data);
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
