package com.prosodie.geolocalizacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.prosodie.geolocalizacion.bean.Geolocation;
import com.prosodie.geolocalizacion.bean.Results;
import com.prosodie.geolocalizacion.persistence.domain.Store;
import com.prosodie.geolocalizacion.persistence.service.StoreService;

/*
https://developers.google.com/maps/documentation/geocoding/

http://universimmedia.pagesperso-orange.fr/geo/loc.htm

*/


/*
 * Use of the Google Geocoding API is subject to a query limit of 2,500 geolocation requests per day. 
 * (User of Google Maps API for Business may perform up to 100,000 requests per day.) 
 * This limit is enforced to prevent abuse and/or repurposing of the Geocoding API, 
 * and this limit may be changed in the future without notice. Additionally,
 *  we enforce a request rate limit to prevent abuse of the service. 
 *  If you exceed the 24-hour limit or otherwise abuse the service, the Geocoding API may stop working for you temporarily. 
 * If you continue to exceed this limit, your access to the Geocoding API may be blocked.
 */

public class GeolocalizacionMain
{

	private final String url = "http://maps.googleapis.com/maps/api/geocode/json";
	
	private final String charset = "UTF-8";
	
	
	public GeolocalizacionMain()
	{
		super();
		
	}

	
	
	public static void main(String[] a)
	{
		
		
		GeolocalizacionMain main = new GeolocalizacionMain();
		
		
		StoreService service = new StoreService();
		List<Store> ls = service.getStore();
		
		
		
		
		for (Store store: ls)
		{
			//System.out.println("[Store] Provincia" + store.getProvince() + "; Poblacion:" + store.getCity() + ";Calle:" + store.getStreet_Name() + ";Numero:" + store.getStreet_Number());
			
			
			
			Geolocation g = main.getGeolocation(store.getProvince() ,  store.getCity(), store.getStreet_Name() , store.getStreet_Number());
			if (g == null)
			{
				//System.out.println("[Store no located] Provincia:" + store.getProvince().trim() + "; Poblacion:" + store.getCity().trim() + ";Calle:" + store.getStreet_Name().trim() + ";Numero:" + store.getStreet_Number().trim());
			}
			else if ( !"OK".equals(g.getStatus()))
			{
				//System.out.println("[Store status location error][" + g.getStatus() + "] Provincia:" + store.getProvince().trim() + "; Poblacion:" + store.getCity().trim() + ";Calle:" + store.getStreet_Name().trim() + ";Numero:" + store.getStreet_Number().trim());
			}
			else
			{
				List<Results> lr = g.getResults();
				
				String latitud = null;
				String longitud = null;
				
				for (Results r: lr)
				{
					try
					{
						
						if ( latitud != null && !latitud.equals(r.getGeometry().getLocation().getLat()) )
						{
							latitud = null;
							longitud = null;
							
							continue;
						}
						
						latitud = String.valueOf(r.getGeometry().getLocation().getLat());
					
						if ( longitud != null && !longitud.equals(r.getGeometry().getLocation().getLng()) )
						{
							latitud = null;
							longitud = null;
							
							continue;
						}
						
						longitud = String.valueOf(r.getGeometry().getLocation().getLng());	
							
					}
					catch(Exception e)
					{
						//System.out.println("[Store latitude/longitude error][" + e.getMessage()+ "] Provincia:" + store.getProvince().trim() + "; Poblacion:" + store.getCity().trim() + ";Calle:" + store.getStreet_Name().trim() + ";Numero:" + store.getStreet_Number().trim());
					}
					
					
				}
				
				if ( latitud != null && longitud != null )
				{
					//System.out.println("[Store]" +  store.getStreet_Number() + " " +  store.getStreet_Name()  + " " +  store.getCity() + " " + store.getProvince());
					System.out.println("UPDATE dbo.shp_stores SET longitude= " +  longitud  + " , latitude= " + latitud + " WHERE id_store=" + store.getId_Store());
					
				}
				
				
				
			}
			
			
			
		}
		
		
		// Provincia:ALICANTE; Poblacion:ALICANTE-ALACANT;Calle:MAISONNAVE, AVD;Numero:33
		/*
		String provincia ="ALICANTE";
		String poblacion ="ALICANTE-ALACANT";
		String calle = "MAISONNAVE, AVD";
		String numero ="33";
		Geolocation g = main.getGeolocation(provincia ,  poblacion, calle , numero);
		
		if (g == null )			
			System.out.println("[Store] Error");
		else
		{
			
			System.out.println("[Store] Status:" + g.getStatus());
		}
		*/
		
		
		
		
		
		
		
	}
	
	
	private Geolocation getGeolocation(String provincia, String poblacion, String calle, String numero)
	{
		
		 BufferedReader br = null;
	     HttpURLConnection connection = null;
	        
		try
		{
			String sensor = "false";
			String direccion = numero + "," + calle + "," + poblacion  + "," + provincia; 
			
			String query = String.format("address=%s&sensor=%s", URLEncoder.encode(direccion, charset), URLEncoder.encode(sensor, charset));
			
			connection = (HttpURLConnection)(new URL(url + "?" + query).openConnection());
			
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestProperty("Accept-Charset", charset);
			
			//System.out.println("Requesting...[" + url + "?" + query + "]");
            int codigo = connection.getResponseCode();
			
			 //200 OK
            if (codigo != HttpURLConnection.HTTP_OK)
            {
            	//System.out.println("****CODE ERROR[" + codigo + "][" + url + "?" + query + "]");		
                throw new Exception("Response code error:" + codigo);
            }

            //System.out.println("Response OK [" + url + "?" + query + "]");
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(),charset));
			
            GeolocationBuilder gb = new GeolocationBuilderGS();
            Geolocation g = gb.build(br);
           
            
        	
        	return g;
			
			
		}
		catch(Exception e)
		{
				
			return null;
			
		}
		finally
		{
			//Calling the close() methods on the InputStream or OutputStream of an HttpURLConnection
			//after a request may free network resources associated with this instance but has no effect on any shared persistent connection.

			if (br != null)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}

			}
			// Calling the disconnect() method of HttpURLConnection may close the underlying socket
			// if a persistent connection is otherwise idle at that time
			/* if (conexion != null)
	            {
	                try
	                {
	                    conexion.disconnect();
	                }
	                catch (Exception e)
	                {
	                    e.printStackTrace();
	                }

	            }
			 */

		}

		

		
		
		
	}
	
	
}
