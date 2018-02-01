package mx.com.tetzo.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tetzo.persistence.HibernateConfigurationSTANDALONE;
import mx.com.tetzo.services.business.CurrencyService;
import mx.com.tetzo.services.business.impl.CurrencyServiceImpl;
import mx.com.tetzo.services.business.vo.CurrencyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class,
		HibernateConfigurationSTANDALONE.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles("STANDALONE")
public class CurrencyServiceTest {

	@Autowired
	@Qualifier("currencyService")
	CurrencyService currencyServices;

	@Test
	@Transactional
	public void getConfigDto() {
		List<CurrencyVO> lista = new ArrayList<CurrencyVO>();
		try {
			lista = currencyServices.getCurrencies();
		} catch (Exception e) {
			e.printStackTrace();
		}
		lista.forEach(config -> {
			System.out.println("Id " + config.getIso4217());

		});

	}

	@Test
	@Transactional
	public void prueba() {
		System.out.println("hola");

	}

}
