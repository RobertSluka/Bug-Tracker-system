package java.Bug.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("http://localhost:3000")
@RestController
public class HelloController {
    @RequestMapping("/") public String helloworld()
    {
        return "Hello World";
    }
}
