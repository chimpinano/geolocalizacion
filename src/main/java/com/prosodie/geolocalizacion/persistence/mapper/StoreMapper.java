package com.prosodie.geolocalizacion.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.prosodie.geolocalizacion.persistence.domain.Store;



public interface StoreMapper
{
	@Select("SELECT TOP 1000 * FROM shp_stores WHERE latitude IS NULL OR longitude IS NULL")
	public List<Store> getStore();

}


