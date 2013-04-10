package com.prosodie.geolocalizacion.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.prosodie.geolocalizacion.persistence.domain.Store;



public interface StoreMapper
{
	@Select("SELECT TOP 1000 * FROM shp_stores WHERE id_store > #{id} AND (latitude IS NULL OR longitude IS NULL)")
	public List<Store> getStore(int id);
	
	
	@Select("SELECT DISTINCT(province) FROM shp_stores ORDER BY province ASC")
	public List<String> getProvince();
	
	@Select("SELECT DISTINCT(postal_code) FROM shp_stores WHERE province = #{province} ORDER by postal_code ASC")
	public List<String> getCP(String province);

}


