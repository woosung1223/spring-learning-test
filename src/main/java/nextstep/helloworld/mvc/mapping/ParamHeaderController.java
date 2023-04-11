package nextstep.helloworld.mvc.mapping;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param-header")
public class ParamHeaderController {

    @GetMapping("/message")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> message() {
        return ResponseEntity.ok().body("message");
    }

    @GetMapping(value = "/message", params = "name=hello")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> messageForParam(String value) {
        return ResponseEntity.ok().body("hello");
    }

    @GetMapping(value = "/message", headers = "HEADER=hi")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> messageForHeader() {
        return ResponseEntity.ok().body("hi");
    }
}
