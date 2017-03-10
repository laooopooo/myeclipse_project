package domain;

/**
 * Description: <br/>
 * ÍøÕ¾: <a href="http://www.crazyit.org">·è¿ñJavaÁªÃË</a> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class Address {
	private Integer id;
	private String detail;
	private String zip;
	private String country;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String detail, String zip, String country) {
		super();
		this.detail = detail;
		this.zip = zip;
		this.country = country;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}