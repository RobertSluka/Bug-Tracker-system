package Bug.Controller;

import Bug.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
    @Autowired
    private UserService service;

    public String hello() {
        return "Hello Robike";
    }

}
