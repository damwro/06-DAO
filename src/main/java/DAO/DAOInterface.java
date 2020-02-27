package DAO;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object
 * @param <T> klasa implementująca DAO
 */
public interface DAOInterface<T> {
    /**
     * Pobierz obiekt po id
     */
    Optional<T> get(long id);

    /**
     * Pobierz wszystkie obiekty
     */
    List<T> getAll();

    /**
     * Zapisz obiekt
     */
    void save(T t);

    /**
     * Modyfikuj obiekt
     */
    void update(T t);

    /**
     * Usuń obiekt
     */
    void delete(T t);

}
