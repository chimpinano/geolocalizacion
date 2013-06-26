
package movistar.distribuidores.util.bean.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the movistar.distribuidores.util.bean.xsd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DistribuidorPoblacion_QNAME = new QName("http://bean.util.distribuidores.movistar/xsd", "poblacion");
    private final static QName _DistribuidorEmail_QNAME = new QName("http://bean.util.distribuidores.movistar/xsd", "email");
    private final static QName _DistribuidorCodigoPostal_QNAME = new QName("http://bean.util.distribuidores.movistar/xsd", "codigoPostal");
    private final static QName _DistribuidorNombreComercial_QNAME = new QName("http://bean.util.distribuidores.movistar/xsd", "nombreComercial");
    private final static QName _DistribuidorCalle_QNAME = new QName("http://bean.util.distribuidores.movistar/xsd", "calle");
    private final static QName _DistribuidorNumero_QNAME = new QName("http://bean.util.distribuidores.movistar/xsd", "numero");
    private final static QName _DistribuidorProvincia_QNAME = new QName("http://bean.util.distribuidores.movistar/xsd", "provincia");
    private final static QName _DistribuidorListaServicio_QNAME = new QName("http://bean.util.distribuidores.movistar/xsd", "listaServicio");
    private final static QName _DistribuidorTelefono_QNAME = new QName("http://bean.util.distribuidores.movistar/xsd", "telefono");
    private final static QName _CoordenadasLat_QNAME = new QName("http://bean.util.distribuidores.movistar/xsd", "lat");
    private final static QName _CoordenadasLng_QNAME = new QName("http://bean.util.distribuidores.movistar/xsd", "lng");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: movistar.distribuidores.util.bean.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Distribuidor }
     * 
     */
    public Distribuidor createDistribuidor() {
        return new Distribuidor();
    }

    /**
     * Create an instance of {@link Coordenadas }
     * 
     */
    public Coordenadas createCoordenadas() {
        return new Coordenadas();
    }

    /**
     * Create an instance of {@link Servicio }
     * 
     */
    public Servicio createServicio() {
        return new Servicio();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.util.distribuidores.movistar/xsd", name = "poblacion", scope = Distribuidor.class)
    public JAXBElement<String> createDistribuidorPoblacion(String value) {
        return new JAXBElement<String>(_DistribuidorPoblacion_QNAME, String.class, Distribuidor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.util.distribuidores.movistar/xsd", name = "email", scope = Distribuidor.class)
    public JAXBElement<String> createDistribuidorEmail(String value) {
        return new JAXBElement<String>(_DistribuidorEmail_QNAME, String.class, Distribuidor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.util.distribuidores.movistar/xsd", name = "codigoPostal", scope = Distribuidor.class)
    public JAXBElement<String> createDistribuidorCodigoPostal(String value) {
        return new JAXBElement<String>(_DistribuidorCodigoPostal_QNAME, String.class, Distribuidor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.util.distribuidores.movistar/xsd", name = "nombreComercial", scope = Distribuidor.class)
    public JAXBElement<String> createDistribuidorNombreComercial(String value) {
        return new JAXBElement<String>(_DistribuidorNombreComercial_QNAME, String.class, Distribuidor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.util.distribuidores.movistar/xsd", name = "calle", scope = Distribuidor.class)
    public JAXBElement<String> createDistribuidorCalle(String value) {
        return new JAXBElement<String>(_DistribuidorCalle_QNAME, String.class, Distribuidor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.util.distribuidores.movistar/xsd", name = "numero", scope = Distribuidor.class)
    public JAXBElement<String> createDistribuidorNumero(String value) {
        return new JAXBElement<String>(_DistribuidorNumero_QNAME, String.class, Distribuidor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.util.distribuidores.movistar/xsd", name = "provincia", scope = Distribuidor.class)
    public JAXBElement<String> createDistribuidorProvincia(String value) {
        return new JAXBElement<String>(_DistribuidorProvincia_QNAME, String.class, Distribuidor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Servicio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.util.distribuidores.movistar/xsd", name = "listaServicio", scope = Distribuidor.class)
    public JAXBElement<Servicio> createDistribuidorListaServicio(Servicio value) {
        return new JAXBElement<Servicio>(_DistribuidorListaServicio_QNAME, Servicio.class, Distribuidor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.util.distribuidores.movistar/xsd", name = "telefono", scope = Distribuidor.class)
    public JAXBElement<String> createDistribuidorTelefono(String value) {
        return new JAXBElement<String>(_DistribuidorTelefono_QNAME, String.class, Distribuidor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.util.distribuidores.movistar/xsd", name = "lat", scope = Coordenadas.class)
    public JAXBElement<String> createCoordenadasLat(String value) {
        return new JAXBElement<String>(_CoordenadasLat_QNAME, String.class, Coordenadas.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.util.distribuidores.movistar/xsd", name = "lng", scope = Coordenadas.class)
    public JAXBElement<String> createCoordenadasLng(String value) {
        return new JAXBElement<String>(_CoordenadasLng_QNAME, String.class, Coordenadas.class, value);
    }

}
