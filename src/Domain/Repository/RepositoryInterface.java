package Domain.Repository;

import java.util.UUID;

public interface RepositoryInterface <E>{
    public void create(E entity);
    public void listAll();
    public void update(UUID id, E entity);
    public void search(String name);
    public void delete(UUID id);
    public void takeTheExam(String name);

}
