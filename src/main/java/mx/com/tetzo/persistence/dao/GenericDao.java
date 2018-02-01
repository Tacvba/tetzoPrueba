package mx.com.tetzo.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 * This interface describes all methods to be implemented by any DAO. Being T
 * the persist object and PK the object that encapsulate the persist object's
 * id. Values for T and PK are assigned once the interface is implemented.
 * 
 * @author Rotten
 * @param <T>
 *            the persist object
 * @param <PK>
 *            the persist object's id
 */
public interface GenericDao<T, PK extends Serializable> {

	public void create(T persistObject);

	public T read(PK id);

	public void update(T persistObject);

	public void update(String sql);

	public void delete(T persistObject);

	public void deleteById(PK id);

	public void createOrUpdate(T persisObject);

	public List<T> listAll();

	public boolean exist(PK id);

	public int getTotal();

	public T findById(PK id);

	public void evict(T persistObject);

	public void merge(T persistObject);

	public String getPersistenceClassId();

	public List<String> getPersistenceClassSkippedProperties();

}
