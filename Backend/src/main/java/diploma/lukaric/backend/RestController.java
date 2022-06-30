package diploma.lukaric.backend;

import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/api")
public class RestController {
    private final Service service;

    public RestController(Service service) {
        this.service = service;
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/validate")
    public RestResponse validateSQLStatement(@RequestBody String statement) {
        service.validateSQLStatement(statement);
        return new RestResponse(200,"OK");
    }

    @GetMapping(path = "/randomQuestion")
    public Question getRandomQuestion() {
        return service.getRandomQuestion();
    }

    @GetMapping(path = "/selectQuestion")
    public Question getSelectQuestion() {
        return service.getSelectQuestion();
    }
}
