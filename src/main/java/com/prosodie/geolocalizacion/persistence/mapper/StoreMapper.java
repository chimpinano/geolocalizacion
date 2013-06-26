package com.prosodie.geolocalizacion.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.prosodie.geolocalizacion.persistence.domain.Store;



public interface StoreMapper
{
	
	@Select("SELECT TOP ${length} * FROM shp_stores a WHERE a.id_store > #{start} AND ( a.latitude IS NULL OR a.longitude IS NULL)")	
	public List<Store> getStoreL(@Param("start") int start, @Param("length") int length);
	
	
	@Select("SELECT TOP ${length} * FROM shp_stores a LEFT JOIN shp_location_accuracy b ON a.id_store = b.id_store WHERE a.id_store > #{start}")	
	public List<Store> getStoreA(@Param("start") int start, @Param("length") int length);
	
	@Select("SELECT COUNT(*) FROM shp_stores")	
	public int getStoreCount();
	
	
	@Select("SELECT DISTINCT(province) FROM shp_stores ORDER BY province ASC")
	public List<String> getProvince();
	
	@Select("SELECT DISTINCT(postal_code) FROM shp_stores WHERE province = #{province} ORDER by postal_code ASC")
	public List<String> getCP(String province);
	

}


