package com.prosodie.geolocalizacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	
	private final static String ROOFTOP = "ROOFTOP";
	private final static String RANGE_INTERPOLATED = "RANGE_INTERPOLATED";
	private final static String APPROXIMATE = "APPROXIMATE";

	
	
	public GeolocalizacionMain()
	{
		super();
		
	}

	
	
	public static void main(String[] a)
	{
		
		
		GeolocalizacionMain main = new GeolocalizacionMain();
		
		
		StoreService service = new StoreService();
		
		Random random = new Random();
		int id = random.nextInt(7000);
		if (id > 6000)
			id = 0;
		
		List<Store> ls = service.getStore(id);
		
		
		
		
		for (Store store: ls)
		{
			System.err.println("");
			System.err.println("");
			System.err.println("");
			System.err.println("[Store] Provincia:" + store.getProvince() + "; Poblacion:" + store.getCity() + ";Calle:" + store.getStreet_Name() + ";Numero:" + store.getStreet_Number());
			
			
			
			Geolocation g = main.getGeolocation(store.getProvince() ,  store.getCity(), store.getStreet_Name() , store.getStreet_Number(), store.getPostal_Code());
			
						
			if (g == null)
			{
				System.err.println("[Store no located] Provincia:" + store.getProvince().trim() + "; Poblacion:" + store.getCity().trim() + ";Calle:" + store.getStreet_Name().trim() + ";Numero:" + store.getStreet_Number().trim());
			}
			else if ( !"OK".equals(g.getStatus()))
			{
				System.err.println("[Store status location error][" + g.getStatus() + "] Provincia:" + store.getProvince().trim() + "; Poblacion:" + store.getCity().trim() + ";Calle:" + store.getStreet_Name().trim() + ";Numero:" + store.getStreet_Number().trim());
				
				if ("OVER_QUERY_LIMIT".equals(g.getStatus()))
				{
					System.out.println("[Store status location error][" + g.getStatus() + "] Provincia:" + store.getProvince().trim() + "; Poblacion:" + store.getCity().trim() + ";Calle:" + store.getStreet_Name().trim() + ";Numero:" + store.getStreet_Number().trim());
					System.exit(0);	
				}
			}
			else
			{
				List<Results> lr = g.getResults();
				

				String latitud = null;
				String longitud = null;
				String accuracy = null;
				
				if (lr != null)
				{
					
					for (Results r: lr)
					{
						try
						{
							
		
							/*
							ROOFTOP indicates that the returned result is a precise geocode for which we have location information accurate down to street address precision.
							ACCURACY_RANGE_INTERPOLATED indicates that the returned result reflects an approximation (usually on a road) interpolated between two precise points (such as intersections). Interpolated results are generally returned when rooftop geocodes are unavailable for a street address.
							GEOMETRIC_CENTER indicates that the returned result is the geometric center of a result such as a polyline (for example, a street) or polygon (region).
							APPROXIMATE indicates that the returned result is approximate.
							 */
							if (!ROOFTOP.equals(r.getGeometry().getLocation_type()) && !RANGE_INTERPOLATED.equals(r.getGeometry().getLocation_type()) && !APPROXIMATE.equals(r.getGeometry().getLocation_type()))
							{
								System.err.println("[Store location accuracy][" + r.getGeometry().getLocation_type() + "] Provincia:" + store.getProvince().trim() + "; Poblacion:" + store.getCity().trim() + ";Calle:" + store.getStreet_Name().trim() + ";Numero:" + store.getStreet_Number().trim());
								continue;
							}
							
							
							if (accuracy != null)
							{
								
								if (accuracy.equals(r.getGeometry().getLocation_type()))
								{
									latitud = null;
									longitud = null;

									System.err.println("Store multiple accuracy ["  + accuracy + "]");
									continue;
								}
								else if (ROOFTOP.equals(accuracy) && !ROOFTOP.equals(r.getGeometry().getLocation_type()))
								{
									continue;
								}
								else if (RANGE_INTERPOLATED.equals(accuracy) && APPROXIMATE.equals(r.getGeometry().getLocation_type()))
								{
									continue;
								}
								
							}
								
								
							
							latitud = String.valueOf(r.getGeometry().getLocation().getLat());
													
							longitud = String.valueOf(r.getGeometry().getLocation().getLng());	
							
							accuracy = r.getGeometry().getLocation_type();
							
							System.err.println("[Store location setting] latitude [" + latitud + "] longitude [" + longitud + "] accuracy[" +  accuracy + "]");
							
								
						}
						catch(Exception e)
						{
							System.err.println("[Store latitude/longitude error][" + e.getMessage()+ "] Provincia:" + store.getProvince().trim() + "; Poblacion:" + store.getCity().trim() + ";Calle:" + store.getStreet_Name().trim() + ";Numero:" + store.getStreet_Number().trim());
						}
						
						
					}
				}
				else
				{
					
				}
				
				if ( latitud != null && longitud != null && accuracy != null )
				{
					System.err.println("*****[UPDATED]*******");
					System.out.println("DELETE FROM dbo.tmp_shp_location_accuracy WHERE id_store = " + store.getId_Store() + ";");
					System.out.println("INSERT INTO dbo.tmp_shp_location_accuracy(id_store, accuracy) VALUES(" + store.getId_Store()+ ",'" + accuracy + "');");
					System.out.println("UPDATE dbo.shp_stores SET longitude= " +  longitud  + " , latitude= " + latitud + " WHERE id_store=" + store.getId_Store() + ";");
					
				}
				
				
				
			}
			
			
			
		}
		
		
	}
	

	
	private Geolocation getGeolocation(String provincia, String poblacion, String calle, String numero, Integer cp)
	{
		
		 BufferedReader br = null;
	     HttpURLConnection connection = null;
	        
		try
		{
			String sensor = "false";
			
			
			// PROVINCIA
			
			if ("PALMAS DE GRAN CANARIA, LAS".equals(provincia))
			{
				provincia = "LAS PALMAS DE GRAN CANARIA";
			}
			else if ("CORUÑA, LA".equals(provincia))
			{
				provincia = "LA CORUÑA";
			}
			else if ("RIOJA, LA".equals(provincia))
			{
				provincia = "LA RIOJA";
			}

			
			// CALLE
			
			calle = calle.trim();
		
			calle = calle.replaceAll("\\sKALEA,", ",");
			
			
			Map<String,String> h = new HashMap<String,String>();
			
			
			h.put("CL",  "CALLE");
			h.put("AVD", "AVENIDA");
			h.put("CRA", "CARRETERA");
			h.put("PZA", "PLAZA"); 
			h.put("BDA", "BDA"); 
			h.put("PSO", "PSO");
			h.put("RAM", "RAM");
			h.put("ARR", "ARR");  
			h.put("POL", "POL"); 
			h.put("PJE", "PJE"); 
			h.put("MAS", "MAS"); 
			h.put("RDA", "RDA"); 
			h.put("PDA", "PDA"); 
			h.put("CNO", "CNO"); 
			h.put("BO",  "BO"); 
			h.put("BDA", "BDA"); 
			h.put("LUG", "LUG"); 
			h.put("PRL", "PRL"); 
			h.put("PQE", "PQE"); 
			h.put("TRV", "TRV"); 
			
			
		
			
			
			
			Matcher m1 = Pattern.compile(".+,\\s(\\w+)$").matcher(calle);
			if ( m1.matches())
			{
				String tipo = m1.group(1);
				if ("CRA".equals(tipo))
				{
					System.err.println("[Store location CARRETERA][" + calle + "]");
					return null;
				}
				else
				{
					if (h.containsKey(tipo))
					{
						calle = h.get(tipo) + " " + calle;
					}
					else
					{
						calle =  tipo + " " + calle;
					}
				}
				
				
			}
			else
			{
				System.err.println("[Store location MISSING STREET TYPE][" + calle + "]");
				return null;
			}
			
			
			calle = calle.replaceAll(",\\s\\w+$", "");
			calle = calle.replaceAll(",", " ");
			
			
			// NUMERO
			
			numero = numero.trim();
			
			if (Pattern.compile(".*KM.*").matcher(numero).matches())
			{
				System.err.println("Street number KM [" + numero + "]");
				return null;
	
			}
			
			
			if (Pattern.compile(".*S/N.*").matcher(numero).matches())
			{
				if (Pattern.compile(".*CC\\s.*|.*C\\.C\\..*|.*CC\\..*").matcher(numero).matches())
				{
					// CENTRO COMERCIAL SIN NUMERO
					System.err.println("[Store location CENTRO COMERCIAL][" + numero + "]");
					return null;
				}
				else
				{
					System.err.println("Street number [" + numero + "]->[S/N]");
					numero = null;
				}
				
			
			}
			else
			{
				Matcher m2 = Pattern.compile("^([0-9]+).*").matcher(numero);
				if (m2.matches())
				{
					numero = m2.group(1);
					
				}
				else
				{
					System.err.println("Weird street number...[" + numero + "]");
					return null;
				}
			}
			
			
			if (numero != null)
				numero = numero.replaceAll(",", " ");
			
			
			//CP
			
			String pc = String.format("%05d", cp);
			
			if (calle == null || poblacion == null || provincia == null || pc == null)
			{
				System.err.println("Missing required field");
				return null;
			}
			
	
			
			// METODO A
			String direccion = calle + "," + poblacion  + "," + provincia + ",ESPAÑA";
			
			if (numero != null)
			{
				direccion = numero + "," + direccion;
			}
			
			
			String query = String.format("address=%s&components=postal_code:" +  pc + "|country:ES&sensor=%s", URLEncoder.encode(direccion, charset), URLEncoder.encode(sensor, charset));
			
			connection = (HttpURLConnection)(new URL(url + "?" + query).openConnection());
			
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestProperty("Accept-Charset", charset);
			
			System.err.println("Requesting...[" + url + "?" + query + "]");
			
						
            int codigo = connection.getResponseCode();
			
			 //200 OK
            if (codigo != HttpURLConnection.HTTP_OK)
            {
            	System.err.println("****CODE ERROR[" + codigo + "][" + url + "?" + query + "]");		
                throw new Exception("Response code error:" + codigo);
            }

            System.err.println("Response OK [" + url + "?" + query + "]");
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(),charset));
			
            GeolocationBuilder gb = new GeolocationBuilderGS();
            Geolocation g = gb.build(br);
           
            
        	
        	return g;
			
			
		}
		catch(Exception e)
		{
				
			e.printStackTrace();
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
