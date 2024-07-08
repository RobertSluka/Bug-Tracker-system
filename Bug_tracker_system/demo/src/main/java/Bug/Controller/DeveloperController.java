package Bug.Controller;

import Bug.Service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/developer")
public class DeveloperController {
    @Autowired
    private DeveloperService service;

    public String hello(){
        return "Hello Robike";
    }

//    public List<> findAll(){
//        return  service.findAll();
//    }
//
//    @GetMapping(value = "/{id}")
//    public
}
