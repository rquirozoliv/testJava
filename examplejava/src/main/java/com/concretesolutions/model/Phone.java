package com.concretesolutions.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PHONE", catalog = "PUBLIC")
public class Phone implements Serializable {
	
	private static final long serialVersionUID = -1947039377380619834L;

	@Id
	@JsonIgnore
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NUMBER")
	private String number;

	@Column(name = "CITYCODE")
	private String cityCode;

	@Column(name = "COUNTRYCODE")
	private String countryCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}	
	
}
