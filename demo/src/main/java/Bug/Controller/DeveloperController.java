package Bug.Controller;


import Bug.Service.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
    @Autowired
    private UserServiceImpl service;

    public String hello() {
        return "Hello Robike";
    }

}
