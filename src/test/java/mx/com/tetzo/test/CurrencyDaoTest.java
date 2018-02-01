package mx.com.tetzo.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tetzo.persistence.HibernateConfigurationSTANDALONE;
import mx.com.tetzo.persistence.dao.CurrencyDao;
import mx.com.tetzo.persistence.entities.Currency;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfigurationSTANDALONE.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles("STANDALONE")
public class CurrencyDaoTest {
	@Autowired
	CurrencyDao currencyDao;
	
	@Test
	@Transactional
	public void getCurrencies(){
		List<Currency> currencyList = currencyDao.getListCurrency();
		currencyList.forEach(currency ->{
			System.out.println("Id " + currency.getIso4217());
		});
	}

}
