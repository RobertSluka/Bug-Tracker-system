package Bug.Repository;

import Bug.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DeveloperRepository implements DemoRepository{
    private Map<Long,String> repository;


    public DeveloperRepository(){
        this.repository = new HashMap<>();
    }
    @Override
    public void save(User developer) {
        repository.put(developer.getId(),developer.getFirstName());
    }

    @Override
    public Object findById(Integer id) {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public Object findById(Long id) {
        return repository.get(id);
    }
}
