package com.prosodie.export;

import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import movistar.distribuidores.bean.xsd.DistribuidorOut;
import movistar.distribuidores.bean.xsd.DistribuidorPorCPIn;
import movistar.distribuidores.util.bean.xsd.Distribuidor;
import movistar.distribuidores.ws.BuscadorDistribuidoresPortType;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;


public class Export
{


	// MM
	protected final String host = "10.35.26.206";
	protected final String port = "8080";

	QName serviceName = new QName("http://ws.distribuidores.movistar", "BuscadorDistribuidoresService");
	QName portName = new QName("http://ws.distribuidores.movistar", "BuscadorDistribuidoresPortType");


	private movistar.distribuidores.bean.xsd.ObjectFactory factory1 = new movistar.distribuidores.bean.xsd.ObjectFactory();
	

	private BuscadorDistribuidoresPortType client;

	public Export()
	{
		super();
		

		Service service = Service.create(serviceName);
		service.addPort(portName,SOAPBinding.SOAP11HTTP_BINDING,"http://"+ host + ":"+ port+ "/MovistarDistribuidores/services/BuscadorDistribuidores.BuscadorDistribuidoresHttpSoap11Endpoint/");

		this.client = service.getPort(portName,BuscadorDistribuidoresPortType.class);

		// Logging
		Client c = ClientProxy.getClient(client);
		c.getInInterceptors().add(new LoggingInInterceptor());
		c.getOutInterceptors().add(new LoggingOutInterceptor());
		
		
		

	}

	public List<Distribuidor> exportDistribuidor(String cp)
	throws Exception
	{

		try
		{

			DistribuidorPorCPIn distribuidorPorCPIn = factory1.createDistribuidorPorCPIn();

			distribuidorPorCPIn.setCp(factory1.createDistribuidorPorCPInCp(cp));
			DistribuidorOut out = client.busquedaDistribuidorCP(distribuidorPorCPIn);

			List<Distribuidor> lDistribuidor = out.getListaDistribuidor();

			return lDistribuidor;

		}
		catch (Exception e)
		{

			throw e;
		}

	}
		    


}
