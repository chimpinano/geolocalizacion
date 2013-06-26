package com.prosodie.geolocalizacion.persistence.domain;

import java.io.Serializable;


/*
 * Clase que modela la tabla correspondiente a tiendas
 * 
 * Nota: Debe ser serializable si se pretende que sea cacheado
 * 
 */

public class Store implements Serializable
{


	private static final long serialVersionUID = 1L;
	
	
	private Integer id_Store;
	private String name;
	private String phoneNumber;
	private String email;
	private String province;
	private String city;
	private String street_Name;
	private String street_Number;
	private Integer postal_Code;
	
	private Double latitude;
	private Double longitude; 
	
	private String accuracy;
	
	
	

	public Integer getId_Store()
	{
		return id_Store;
	}
	public void setId_Store(Integer id_Store)
	{
		this.id_Store = id_Store;
	}
	public String getName()
	
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getProvince()
	{
		return province;
	}
	public void setProvince(String province)
	{
		this.province = province;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getStreet_Name()
	{
		return street_Name;
	}
	public void setStreet_Name(String street_Name)
	{
		this.street_Name = street_Name;
	}
	public String getStreet_Number()
	{
		return street_Number;
	}
	public void setStreet_Number(String street_Number)
	{
		this.street_Number = street_Number;
	}
	public Integer getPostal_Code()
	{
		return postal_Code;
	}
	public void setPostal_Code(Integer postal_Code)
	{
		this.postal_Code = postal_Code;
	}
	public Double getLatitude()
	{
		return latitude;
	}
	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}
	public Double getLongitude()
	{
		return longitude;
	}
	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

	public String getAccuracy()
	{
		return accuracy;
	}
	public void setAccuracy(String accuracy)
	{
		this.accuracy = accuracy;
	}	
	
	
	
}
