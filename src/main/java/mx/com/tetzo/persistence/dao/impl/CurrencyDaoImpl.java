package mx.com.tetzo.persistence.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import mx.com.tetzo.persistence.dao.CurrencyDao;
import mx.com.tetzo.persistence.entities.Currency;
import mx.com.tetzo.persistence.impl.AbstractGenericDaoImpl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

@Repository("currencyDaoImpl")
public class CurrencyDaoImpl extends AbstractGenericDaoImpl<Currency, Integer> implements CurrencyDao {

	public static Logger logger = LogManager.getLogger();
	
	public CurrencyDaoImpl() {
		super();
	}

	/**
	 * TODO: cambiar create criteria por algo así: 
	 * // Create CriteriaBuilder
	 * CriteriaBuilder builder = session.getCriteriaBuilder();	 * 
	 * // Create CriteriaQuery CriteriaQuery<YourClass> criteria =
	 * builder.createQuery(YourClass.class);
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Currency> getListCurrency() {
		Criteria cr = this.getSession().createCriteria(Currency.class);
		return cr.list();
	}

	@Override
	public String getPersistenceClassId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPersistenceClassSkippedProperties() {
		// TODO Auto-generated method stub
		return null;
	}

}
