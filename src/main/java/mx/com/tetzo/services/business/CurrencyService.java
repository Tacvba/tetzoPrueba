package mx.com.tetzo.services.business;

import java.util.List;

import mx.com.tetzo.services.business.vo.CurrencyVO;

public interface CurrencyService {
	List<CurrencyVO> getCurrencies();
}
