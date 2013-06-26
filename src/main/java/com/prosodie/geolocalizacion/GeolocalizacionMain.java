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

/*
 * 
declare @t integer;
declare @n integer

select @t = count(*)  from shp_stores
select @n = count(*) from shp_stores where latitude is not null or longitude is not null

select STR((@n*100)/@t,6,2) as '% geolocalizados'


 */

public class GeolocalizacionMain
{
	
	

	private final String url = "http://maps.googleapis.com/maps/api/geocode/json";
	private final String charset = "UTF-8";
	
	
	private static enum ACCURACY
	{
		ROOFTOP,
		RANGE_INTERPOLATED,
		IMPORTED,
		APPROXIMATE,
		GEOMETRIC_CENTER;
		
		
		
		
		
	}
	
	/*
	private final static String ROOFTOP = "ROOFTOP";
	private final static String RANGE_INTERPOLATED = "RANGE_INTERPOLATED";
	private final static String APPROXIMATE = "APPROXIMATE";
	*/

	
	
	public GeolocalizacionMain()
	{
		super();
		
	}

	
	
	public static void main(String[] a)
	{
		
		// DEFAULT
		ACCURACY top = ACCURACY.RANGE_INTERPOLATED; 
		
		//
		boolean multiple = false;
		boolean scan = false;
		
		
		if ( a != null && a.length > 0)
		{
			
			for (int i=0; i<a.length; i++)
			{
				
				if ("-h".equals(a[i]))
				{
					System.err.println("Parámetros");
					System.err.println("-h :  Ayuda");
					System.err.println("-p [ROOFTOP|RANGE_INTERPOLATED|APPROXIMATE] : Precisión máxima");
					System.err.println("-m :  En caso de multiple (latitud, longitud) en una misma precisión, se toma la ultima. Por defecto, se descartan");					
					System.err.println("-r :  Recalcula la geolocalizacion de tiendas , modificando si la precision mejora");
					
					System.exit(0);
				}
				else if ("-m".equals(a[i]))
				{
					multiple = true;
					
				}
				else if ("-s".equals(a[i]))
				{
					scan = true;
					
				}
				else if ("-p".equals(a[i]))
				{

						try
						{
							top = ACCURACY.valueOf(a[i+1]);
						}
						catch(IllegalArgumentException e)
						{
							System.err.println("Precision no valida [ROOFTOP,RANGE_INTERPOLATED,APPROXIMATE]");
							System.exit(0);
						}
				
				}
				
			}
			
		}
		
		GeolocalizacionMain main = new GeolocalizacionMain();
		
		
		
		
		StoreService service = new StoreService();
		
		
		int n = service.getStoreCount();
		
		Random random = new Random();
		
		int length=  (int)Math.pow(10, String.valueOf(n).length() - 1) ;		// 1, 10 , 100, ...
		

		int start = random.nextInt(n+length);  
 		if (start > n)
			start = 0;

		List<Store> ls = service.getStore(start,length, scan);
		
		
		
		
		for (Store store: ls)
		{
			
			
			if (!scan && store.getLatitude() != null && store.getLongitude() != null)
				continue;
			
			System.err.println("\n\n");
			if (store.getLatitude() != null && store.getLongitude() != null)
			{
				System.err.println("Upgrading ....");
			}
			
			
			
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
					System.err.println("[Store status location error][" + g.getStatus() + "] Provincia:" + store.getProvince().trim() + "; Poblacion:" + store.getCity().trim() + ";Calle:" + store.getStreet_Name().trim() + ";Numero:" + store.getStreet_Number().trim());
					System.exit(0);	
				}
			}
			else
			{
				List<Results> lr = g.getResults();
				

				String latitud = null;
				String longitud = null;
				ACCURACY accuracy = null;
				boolean m = false;
				
				if (lr != null)
				{
					
					for (Results r: lr)
					{
						try
						{
							
		
							/*
							ROOFTOP indicates that the returned result is a precise geocode for which we have location information accurate down to street address precision.
							RANGE_INTERPOLATED indicates that the returned result reflects an approximation (usually on a road) interpolated between two precise points (such as intersections). Interpolated results are generally returned when rooftop geocodes are unavailable for a street address.
							GEOMETRIC_CENTER indicates that the returned result is the geometric center of a result such as a polyline (for example, a street) or polygon (region).
							APPROXIMATE indicates that the returned result is approximate.
							 */
							
							
							ACCURACY p = ACCURACY.valueOf(r.getGeometry().getLocation_type());
							
							
							
							if (p.compareTo(top) > 0)
							{
								System.err.println("[Store location accuracy][" + p + "] Provincia:" + store.getProvince().trim() + "; Poblacion:" + store.getCity().trim() + ";Calle:" + store.getStreet_Name().trim() + ";Numero:" + store.getStreet_Number().trim());
								continue;
							}
							
							
							if (accuracy != null)
							{
								
								if (accuracy.equals(p))
								{
									if (!multiple)
									{
										latitud = null;
										longitud = null;
	
										System.err.println("Store multiple accuracy ["  + accuracy + "]");
										
										continue;
									}
									else
									{
										m = true;
										
									}
									
								}
								else if (p.compareTo(accuracy) > 0 )
								{
									continue;
								}
									
								
							}
								
								
							
							latitud = String.valueOf(r.getGeometry().getLocation().getLat());
													
							longitud = String.valueOf(r.getGeometry().getLocation().getLng());	
							
							accuracy = p;
							
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
				
				if ( latitud != null && longitud != null && accuracy != null && (store.getAccuracy() == null || ACCURACY.valueOf(store.getAccuracy()).compareTo(accuracy) > 0))
				{
					
					if (store.getAccuracy()  != null && ACCURACY.valueOf(store.getAccuracy()).compareTo(accuracy) > 0)
					{
						System.out.println("-- [UPDATED][" + store.getAccuracy() + "]->[" + accuracy + "]");
						
					}
					
					
					if (m)
					{
						System.err.println("-- [MULTIPLE]");
					}
					
					System.err.println("*****[UPDATED]*******");
					
					System.out.println("DELETE FROM dbo.shp_location_accuracy WHERE id_store = " + store.getId_Store() + ";");
					System.out.println("INSERT INTO dbo.shp_location_accuracy(id_store, accuracy) VALUES(" + store.getId_Store()+ ",'" + accuracy + "');");
					System.out.println("UPDATE dbo.shp_stores SET longitude= " +  longitud  + " , latitude= " + latitud + " WHERE id_store=" + store.getId_Store() );
					
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
			else if ( "CORUÑA, LA".equals(provincia) || "A CORUÑA".equals(provincia))
			{
				provincia = "LA CORUÑA";
			}
			else if ("RIOJA, LA".equals(provincia))
			{
				provincia = "LA RIOJA";
			}
			else if ("ARABA/ALAVA".equals(provincia))
			{
				provincia = "ALAVA";
			}

			
			// CALLE
			
			calle = calle.trim();
		
			calle = calle.replaceAll("\\sKALEA,", ",");
						
			
			if ("VALENCIA".equals(provincia) && "VALENCIA".equals(poblacion) && "DE LAS CORTES, AVD".equals(calle) )
			{
				calle = "DE LAS CORTS, AVD";				
			}
						
			
			
				
			//
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
					return null;
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
