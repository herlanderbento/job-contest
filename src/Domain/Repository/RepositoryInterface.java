package Domain.Repository;

import java.util.List;

public interface RepositoryInterface <E>{
    public void create(E entity);
    public List<E> listAll();
    public void update(E entity);
    public void search(String name);
    public void delete(String name);

}
