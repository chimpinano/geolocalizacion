package com.prosodie.geolocalizacion.persistence.service;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.prosodie.geolocalizacion.persistence.domain.Store;
import com.prosodie.geolocalizacion.persistence.mapper.StoreMapper;





public class StoreService 
{
		
		SqlSessionFactory sqlSessionFactory;
			
		public StoreService()
		{
			super();
			
			try
			{
				String resource = "com/prosodie/geolocalizacion/persistence/configuration.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				
				this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				this.sqlSessionFactory.getConfiguration().addMapper(StoreMapper.class);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		
	
	    public List<Store> getStore(int id)
	    {	    	
	    	
	    	SqlSession session = sqlSessionFactory.openSession();
	    	try 
	    	{

	    		StoreMapper mapper = session.getMapper(StoreMapper.class);
	    		List<Store> l = mapper.getStore(id);

	    		return l;

	    	} 
	    	finally 
	    	{
	    		session.close();
	    	}
	    	
	    }
	    
	    public List<String> getProvince()
	    {	    	
	    	
	    	SqlSession session = sqlSessionFactory.openSession();
	    	try 
	    	{

	    		StoreMapper mapper = session.getMapper(StoreMapper.class);
	    		List<String> l = mapper.getProvince();

	    		return l;

	    	} 
	    	finally 
	    	{
	    		session.close();
	    	}
	    	
	    }

	    public List<String> getCP(String province)
	    {	    	
	    	
	    	SqlSession session = sqlSessionFactory.openSession();
	    	try 
	    	{

	    		StoreMapper mapper = session.getMapper(StoreMapper.class);
	    		List<String> l = mapper.getCP(province);

	    		return l;

	    	} 
	    	finally 
	    	{
	    		session.close();
	    	}
	    	
	    }
	    
}



