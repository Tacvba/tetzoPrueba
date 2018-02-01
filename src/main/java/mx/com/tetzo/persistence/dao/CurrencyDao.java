package mx.com.tetzo.persistence.dao;

import java.util.List;
import mx.com.tetzo.persistence.entities.Currency;

public interface CurrencyDao{

	public List<Currency> getListCurrency();
}
