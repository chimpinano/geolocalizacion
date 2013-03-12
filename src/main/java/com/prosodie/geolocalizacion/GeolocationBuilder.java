package com.prosodie.geolocalizacion;

import java.io.Reader;

import com.prosodie.geolocalizacion.bean.Geolocation;

public interface GeolocationBuilder
{
	public  Geolocation build(Reader reader);
	
}
