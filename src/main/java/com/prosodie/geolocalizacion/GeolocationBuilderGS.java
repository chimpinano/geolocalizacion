package com.prosodie.geolocalizacion;

import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prosodie.geolocalizacion.bean.Geolocation;

public class GeolocationBuilderGS implements GeolocationBuilder
{

	public Geolocation build(Reader reader)
	{

        Gson gson = new GsonBuilder().create();
        Geolocation g = gson.fromJson(reader, Geolocation.class);
        
        return g;
       
        
        
	}

	
	
	
}
