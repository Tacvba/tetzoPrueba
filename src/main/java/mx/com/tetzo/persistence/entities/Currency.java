package mx.com.tetzo.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currencies")
public class Currency {
	
	/**TODO:
	 * esta clase es un catalogo, checar los nullables
	 * mapeo de la llave foranea*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, insertable = false, updatable = false, nullable = false)
	private Integer id;
	
	@Column(name = "country_id", nullable = false)
	private Integer countryId;
	
	@Column(name = "iso4217_code", nullable = false )
	private String iso4217;
	
	@Column(name = "created_at", nullable = false)
	private Date created;
	
	@Column(name = "updated_at", nullable = false)
	private Date updated;	
	
	public Currency() {
		super();
	}
	
	public Currency(Integer id, String iso4217, Date created, Date updated, Integer countryId) {
		super();
		this.id = id;
		this.iso4217 = iso4217;
		this.created = created;
		this.updated = updated;
		this.countryId = countryId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIso4217() {
		return iso4217;
	}
	public void setIso4217(String iso4217) {
		this.iso4217 = iso4217;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	
}
