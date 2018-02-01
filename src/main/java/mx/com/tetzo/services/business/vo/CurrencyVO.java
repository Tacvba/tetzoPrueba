package mx.com.tetzo.services.business.vo;

import java.util.Date;

public class CurrencyVO {
	
	private Integer id;
	private Integer countryId;
	private String iso4217;
	private Date created;
	private Date updated;

	public CurrencyVO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getIso4217() {
		return iso4217;
	}

	public void setIso4217(String iso4217) {
		this.iso4217 = iso4217;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
 
}
