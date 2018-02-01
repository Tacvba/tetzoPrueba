package mx.com.tetzo.persistence.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.tetzo.persistence.dao.GenericDao;

public abstract class AbstractGenericDaoImpl<T, PK extends java.io.Serializable> implements GenericDao<T, PK> {

	private Class<T> type = null;
	// private Logger logger =
	// LoggerFactory.getLogger(AbstractGenericDaoHibernateImpl.class);
	private String name;

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();

	}

	public AbstractGenericDaoImpl() {
		setName(getDaoType());
	}

	/**
	 * Gets the dao type via reflection
	 * 
	 * @return the dao type
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class<T> getDaoType() {
		if (type == null) {
			Class clazz = getClass();
			while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
				clazz = clazz.getSuperclass();
			}
			type = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
		}

		return type;
	}

	/**
	 * returns the name of the dao's domain object
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	@SuppressWarnings("rawtypes")
	private void setName(Class clazz) {
		String name = clazz.getName();
		name = name.substring(name.lastIndexOf(".") + 1, name.length());
		System.out.println("Created Dao of type[" + name + "]");
		this.name = name;

	}

	public void create(T persistObject) {
		this.getSession().persist(persistObject);
	}

	public T read(PK id) {
		return (T) this.getSession().get(getDaoType(), id);
	}

	public void update(T persistObject) {
		this.getSession().update(persistObject);
	}

	public void update(String hql) {
		this.getSession().createQuery(hql).executeUpdate();
	}

	public void createOrUpdate(T persistObject) {
		this.getSession().saveOrUpdate(persistObject);
	}

	public void delete(T persistObject) {
		this.getSession().delete(persistObject);
	}

	public void deleteById(PK id) {
		this.getSession().delete(findById(id));
	}

	public boolean exist(PK id) {
		Object o = read(id);
		if (o == null)
			return false;
		else
			return true;
	}

	public T findById(PK id) {
		return read(id);
	}

	@SuppressWarnings("rawtypes")
	public int getTotal() {
		int total = 0;

		DetachedCriteria dc = DetachedCriteria.forClass(getDaoType());
		dc.setProjection(Projections.rowCount());
		Criteria c = dc.getExecutableCriteria(getSession());

		List result = c.list();
		if (result.size() > 0) {
			try {
				total = ((Integer) result.get(0)).intValue();
			} catch (Exception e) {
				// logger.error("Error getting total[" + getName() + "]", e);
				total = ((Long) result.get(0)).intValue();
			}

		}

		return total;
	}

	/**
	 * returns all objects available.
	 */
	@SuppressWarnings("unchecked")
	public List<T> listAll() {
		return this.getSession().createCriteria(getDaoType()).list();
	}

	public void evict(T entity) {
		this.getSession().evict(entity);
	}

	public void merge(T entity) {
		this.getSession().merge(entity);
	}

	// public void initialize(T entity) {
	// this.getSession()
	// this.getHibernateTemplate().initialize(entity);
	// }
	//

	public abstract String getPersistenceClassId();

	public abstract List<String> getPersistenceClassSkippedProperties();
}
