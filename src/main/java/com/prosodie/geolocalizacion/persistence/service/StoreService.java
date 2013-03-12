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

		
	
	    public List<Store> getStore()
	    {	    	
	    	
	    	SqlSession session = sqlSessionFactory.openSession();
	    	try 
	    	{

	    		StoreMapper mapper = session.getMapper(StoreMapper.class);
	    		List<Store> l = mapper.getStore();

	    		return l;

	    	} 
	    	finally 
	    	{
	    		session.close();
	    	}
	    	
	    }
	    
	   

	    
	    
}



