package com.prosodie.geolocalizacion;

import java.io.Reader;

import com.prosodie.geolocalizacion.bean.Geolocation;

public class GeolocationBuilderXS implements GeolocationBuilder
{

	public Geolocation build(Reader reader)
	{
		
		//XStream xstream = new XStream(new JettisonMappedXmlDriver());
    	/*
        XStream xstream = new XStream(new JsonHierarchicalStreamDriver() 
        {
            public HierarchicalStreamWriter createWriter(Writer writer) {
                return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
            }
        });
        */
    	
        /*
    	xstream.processAnnotations(Address_components.class);
		xstream.processAnnotations(Geolocation.class);
		xstream.processAnnotations(Bounds.class);
		xstream.processAnnotations(Geometry.class);
		xstream.processAnnotations(Location.class);
		xstream.processAnnotations(Northeast.class);
		xstream.processAnnotations(Results.class);
		xstream.processAnnotations(Southwest.class);
		xstream.processAnnotations(Viewport.class);
		*/
		
		/*
    	Geolocation geolocation =  (Geolocation)xstream.fromXML(br);
		System.out.println(geolocation.getStatus());
		*/

		/*
    	Geolocation geolocation = new Geolocation();
    	
    	List<Results> results = new ArrayList<Results>();
    	
    	Results r1 = new Results();
    	r1.setFormatted_address("JOSE ARCONES GIL");
    	r1.setPartial_match(false);
    	
    	List<Address_components> address_components = new ArrayList<Address_components>();
    	Address_components address_component1 = new Address_components();
    	address_component1.setLong_name("84");
    	address_component1.setShort_name("84");
    	
    	List<String> types11 = new ArrayList<String>();
    	types11.add("street_number");
    	address_component1.setTypes(types11);
    	
    	address_components.add(address_component1);
    	
    	r1.setAddress_components(address_components);
    	
    	List<String> types1 = new ArrayList<String>();
    	types1.add("street_address");
    	r1.setTypes(types1);
    	
    	
    	results.add(r1);
    	
        geolocation.setResults(results);
    	geolocation.setStatus("OK");
    	
    	System.out.println(xstream.toXML(geolocation));
    	*/
    	
    	
    	
    	
    	return null;
	}

	
	
	
}
