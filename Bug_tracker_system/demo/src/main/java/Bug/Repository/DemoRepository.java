package Bug.Repository;

import Bug.User;

public interface DemoRepository <T> {
    public void save(T t);

    public T findById(Long id);

    void save(User developer);

    Object findById(Integer id);
}
