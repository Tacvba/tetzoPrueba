package mx.com.tetzo.services.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tetzo.persistence.dao.CurrencyDao;
import mx.com.tetzo.persistence.dao.impl.CurrencyDaoImpl;
import mx.com.tetzo.persistence.entities.Currency;
import mx.com.tetzo.services.business.CurrencyService;
import mx.com.tetzo.services.business.vo.CurrencyVO;

//@Component
@Service("currencyServices")
@Qualifier("currencyService")
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	CurrencyDao currencyDao;

	public CurrencyServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public List<CurrencyVO> getCurrencies() {
		List<CurrencyVO> currenciesVO = new ArrayList<CurrencyVO>();

		for (Currency currency : currencyDao.getListCurrency()) {
			CurrencyVO currencyVO = new CurrencyVO();
			currencyVO.setCountryId(currency.getCountryId());
			currencyVO.setCreated(currency.getCreated());
			currencyVO.setUpdated(currency.getCreated());
			currencyVO.setIso4217(currency.getIso4217());
			currenciesVO.add(currencyVO);
			System.out.println("-->" + currency.getIso4217());
		}
		return currenciesVO;
	}

}
