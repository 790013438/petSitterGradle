package snippets.jee.repositories;

import snippets.jee.base.AbstractEntity;

public interface AbstractRepo<T extends AbstractEntity> {
    void save(T t);

    void delete(T t);

    void deleteById(Long id);

    T findByid(Long id);
}
