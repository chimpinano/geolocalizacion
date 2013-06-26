package com.prosodie.export;


import java.io.File;
import java.io.FileWriter;
import java.util.List;

import movistar.distribuidores.util.bean.xsd.Distribuidor;

import com.prosodie.geolocalizacion.persistence.service.StoreService;


/*
 * Exporta la base de datos de tiendas consultando el servicio de tiendas 
 * 
 */


public class ExportMain
{


	public static void main(String[] args)
	{
		

		System.out.println("[INFO] ========= =========");
		ExportMain main = new ExportMain();
		main.export();
		System.out.println("[INFO] ========= =========");
		
	}
	
	
	private void export()
	{
		
		
		StoreService service = new StoreService();
		List<String> lp = service.getProvince();
		
			
		if ( lp == null)
		{
			System.err.println("[ERROR] Province empty list");
			return;
			
		}
		
		for (String provincia:lp)
		{
			
			
			// PROVINCIA
			if (!provincia.matches("^[A-Z].*"))
			{
				continue;
			}
			
			
			List<String> lcp = service.getCP(provincia);
			if ( lcp == null)
			{
				System.err.println("[ERROR] CP empty list");
				continue;
				
			}
			
			System.out.println("[INFO] Provincia:" +provincia );
			File f = new File("C:\\EXPORT\\" + provincia.replaceAll("/", "_") + ".csv");
			if (f.exists())
			{
				System.err.println("[ERROR] Already exported[" + provincia + "]");
				continue;
			}
			
			this.sleep(15000);
			
			File error = new File("C:\\EXPORT\\" + provincia.replaceAll("/", "_") + ".error");
			if (error.exists())
			{
				error.delete();
			}
			
			try
			{
				this.head(f);
			}
			catch(Exception e)
			{
				if (f.exists())
				{
					if (!f.delete())
						System.err.println("************[ERROR] Cannot delete file[" + provincia + "]**********************");
	
				}
				
				continue;
			}
			
			for (String cp:lcp)
			{
				
				cp = String.format("%05d", Integer.valueOf(cp));
				System.out.println("[INFO] Exporting [" + provincia + "][" + cp + "]");
				
	
				this.sleep(5000);
				
				
				Export test = new Export();

				
				try
				{
					List<Distribuidor> l = test.exportDistribuidor(cp);
					
				
				
					if (l != null && l.size() > 0)
					{
						
						this.print(f, l);
	
					}
					else
					{
						
						this.error(error, "[ERROR] Export empty list[" + provincia + "][" + cp + "]");
						
						
						System.err.println("[ERROR] Export empty list[" + provincia + "][" + cp + "]");

						continue;
						
					}
					
				}
				catch(Exception e)
				{
					
					this.error(error, "[ERROR] Export exception[" + provincia + "][" + cp + "][" + e.getMessage() + "]");
					
					if (f.exists())
					{
						if (!f.delete())
							System.err.println("************[ERROR] Cannot delete file[" + provincia + "]**********************");
						
						
					}
					
					break;
				}
					
				
			}
			
			
		}
		

		
	}
	
	
	/**
	 * 
	 * Escribe cabecera
	 * 
	 */
	
	private void head(File f)
	throws Exception
	{
		

		FileWriter writer = null;
		
		if (f == null)
		{
			System.err.println("[ERROR] Export heading exception [ file not initializated ]");
		}
		
		try
		{
			
			writer = new FileWriter(f,true);
			writer.append("name|phone_number|email|province|city|street_name|street_number|postal_code|latitude|longitude\n");
		   

		}
		catch(Exception e)
		{
			
			System.err.println("[ERROR] Export heading exception[" + f.getName() + "][" + e.getMessage() + "]");
			throw e;
		}
		finally
		{

			if (writer != null)
			{
				try
				{
					writer.flush();
					writer.close();
				}
				catch(Exception e)
				{
					
					System.err.println("[ERROR] Export heading exception[" + f.getName() + "]");
					throw e;
				}
				
			}
		}
		
	}
	
	/**
	 * 
	 * Escribe error
	 * 
	 */
	
	private void error(File f, String text) 
	{
		FileWriter writer = null;
		try
		{
			writer = new FileWriter(f,true);
			writer.append(text + "\n");

			
		}
		catch (Exception e)
		{

			System.err.println("[ERROR] Export error exception["+ f.getName() + "][" + e.getMessage() + "]");

		}
		finally
		{

			if (writer != null)
			{
				try
				{
					writer.flush();
					writer.close();
				}
				catch (Exception e)
				{

					System.err.println("[ERROR] Export error exception[" + f.getName() + "]");
				}

			}
		}
	}
			
			
	/**
	 * 
	 *  Escribe lista de distribuidores
	 * 
	 */
	private void print(File f, List<Distribuidor> l) 
	throws Exception
	{
		
		FileWriter writer = null;
		
		if (f == null)
		{
			System.err.println("[ERROR] Export printing exception [ file not initializated ]");
		}
		
		try
		{
			
			writer = new FileWriter(f,true);
		
		    for (Distribuidor distribuidor: l)
		    {
		    	this.print(distribuidor);
		    	
		    	writer.append(distribuidor.getNombreComercial().getValue() + "|" +  distribuidor.getTelefono().getValue() +  "|" +  distribuidor.getEmail().getValue() +  "|" +  distribuidor.getProvincia().getValue()  + "|" +  distribuidor.getPoblacion().getValue() + "|" + distribuidor.getCalle().getValue() +  "|" + distribuidor.getNumero().getValue() + "|" + distribuidor.getCodigoPostal().getValue() + "|" + distribuidor.getLatitud() + "|" + distribuidor.getLongitud() + "\n");
		    }


		}
		catch(Exception e)
		{
			
			System.err.println("[ERROR] Export printing exception[" + f.getName() + "][" + e.getMessage() + "]");
			throw e;
		}
		finally
		{

			if (writer != null)
			{
				try
				{
					writer.flush();
					writer.close();
				}
				catch(Exception e)
				{
					
					System.err.println("[ERROR] Export printing exception[" + f.getName() + "]");
					throw e;
				}
				
			}
		}
		
	}
	
	
	private void print(Distribuidor distribuidor)
	{
		
		System.out.println("[Distribuidores] name:" +   distribuidor.getNombreComercial().getValue() + ";phone_number:" +  distribuidor.getTelefono().getValue() +  ";email:" +  distribuidor.getEmail().getValue() +  ";province:" +  distribuidor.getProvincia().getValue()  + ";city:" +  distribuidor.getPoblacion().getValue() + ";street_name:" + distribuidor.getCalle().getValue() +  ";street_number:" + distribuidor.getNumero().getValue() + ";postal_code:" + distribuidor.getCodigoPostal().getValue() + ";latituded:" + distribuidor.getLatitud() + ";longitude:" + distribuidor.getLongitud());
	}
	
	
	private void sleep(long t)
	{
		
		
		try
		{
			System.out.println("Waiting ....");
			Thread.sleep(t);
		}
		catch(Exception e)
		{
			
		}
	}


}
