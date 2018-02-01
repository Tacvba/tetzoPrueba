package mx.com.tetzo.services.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.tetzo.services.business.impl.CurrencyServiceImpl;
import mx.com.tetzo.services.business.vo.CurrencyVO;
import mx.com.tetzo.services.controller.dto.CurrencyDTO;


@RestController
@RequestMapping("/currency")
public class CurrencyController {

	@Autowired
	private CurrencyServiceImpl currencyServiceImpl;
	
	Logger logger = LogManager.getLogger();
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=*/*", value = "listar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CurrencyVO> getCurrencies(@RequestBody CurrencyDTO request){
		List<CurrencyVO> response = currencyServiceImpl.getCurrencies();
		return response;
	}
	
}
