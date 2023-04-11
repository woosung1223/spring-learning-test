package nextstep.helloworld.mvc.handler;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ViewResolver;

import javax.print.attribute.standard.Media;

@Controller
@RequestMapping("/return-value")
public class ReturnValueController {

    @GetMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String string() {
        return "message";
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public User responseBodyForUser() {
        return new User("name", "email");
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> responseEntity(@PathVariable Long id) {
        return ResponseEntity.ok(new User("name", "email"));
    }

    @GetMapping(value = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> responseEntityFor400() {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/thymeleaf", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String thymeleaf(Model model) {
        model.addAttribute("name", "Hello");
        return "sample";
    }
}
