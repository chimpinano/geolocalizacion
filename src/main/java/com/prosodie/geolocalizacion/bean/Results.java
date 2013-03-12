package com.prosodie.geolocalizacion.bean;

import java.util.List;





public class Results
{
	
	private List<Address_components> address_components;
	
	private String formatted_address;
	private Geometry geometry;
	
	private boolean partial_match;
	
	private List<String> types;

	public List<Address_components> getAddress_components()
	{
		return this.address_components;
	}

	public void setAddress_components(
			List<Address_components> address_components)
	{
		this.address_components = address_components;
	}

	public String getFormatted_address()
	{
		return this.formatted_address;
	}

	public void setFormatted_address(String formatted_address)
	{
		this.formatted_address = formatted_address;
	}

	public Geometry getGeometry()
	{
		return this.geometry;
	}

	public void setGeometry(Geometry geometry)
	{
		this.geometry = geometry;
	}

	public boolean getPartial_match()
	{
		return this.partial_match;
	}

	public void setPartial_match(boolean partial_match)
	{
		this.partial_match = partial_match;
	}

	public List<String> getTypes()
	{
		return this.types;
	}

	public void setTypes(List<String> types)
	{
		this.types = types;
	}
}
