
package movistar.distribuidores.bean.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import movistar.distribuidores.util.bean.xsd.Coordenadas;
import movistar.distribuidores.util.bean.xsd.Servicio;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the movistar.distribuidores.bean.xsd package. 
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

    private final static QName _CoordenadasOutCoordenadas_QNAME = new QName("http://bean.distribuidores.movistar/xsd", "coordenadas");
    private final static QName _DistribuidorInListaServicio_QNAME = new QName("http://bean.distribuidores.movistar/xsd", "listaServicio");
    private final static QName _CalleInPoblacion_QNAME = new QName("http://bean.distribuidores.movistar/xsd", "poblacion");
    private final static QName _CalleInProvincia_QNAME = new QName("http://bean.distribuidores.movistar/xsd", "provincia");
    private final static QName _DistribuidorPorCPInCp_QNAME = new QName("http://bean.distribuidores.movistar/xsd", "cp");
    private final static QName _DistribuidorPorDireccionInCalle_QNAME = new QName("http://bean.distribuidores.movistar/xsd", "calle");
    private final static QName _DistribuidorPorCampoInCampo_QNAME = new QName("http://bean.distribuidores.movistar/xsd", "campo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: movistar.distribuidores.bean.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PoblacionOut }
     * 
     */
    public PoblacionOut createPoblacionOut() {
        return new PoblacionOut();
    }

    /**
     * Create an instance of {@link CoordenadasOut }
     * 
     */
    public CoordenadasOut createCoordenadasOut() {
        return new CoordenadasOut();
    }

    /**
     * Create an instance of {@link DistribuidorIn }
     * 
     */
    public DistribuidorIn createDistribuidorIn() {
        return new DistribuidorIn();
    }

    /**
     * Create an instance of {@link CalleOut }
     * 
     */
    public CalleOut createCalleOut() {
        return new CalleOut();
    }

    /**
     * Create an instance of {@link CalleIn }
     * 
     */
    public CalleIn createCalleIn() {
        return new CalleIn();
    }

    /**
     * Create an instance of {@link ProvinciaOut }
     * 
     */
    public ProvinciaOut createProvinciaOut() {
        return new ProvinciaOut();
    }

    /**
     * Create an instance of {@link DistribuidorPorCPIn }
     * 
     */
    public DistribuidorPorCPIn createDistribuidorPorCPIn() {
        return new DistribuidorPorCPIn();
    }

    /**
     * Create an instance of {@link DistribuidorPorDireccionIn }
     * 
     */
    public DistribuidorPorDireccionIn createDistribuidorPorDireccionIn() {
        return new DistribuidorPorDireccionIn();
    }

    /**
     * Create an instance of {@link DistribuidorPorCoordenadasIn }
     * 
     */
    public DistribuidorPorCoordenadasIn createDistribuidorPorCoordenadasIn() {
        return new DistribuidorPorCoordenadasIn();
    }

    /**
     * Create an instance of {@link CoordenadasIn }
     * 
     */
    public CoordenadasIn createCoordenadasIn() {
        return new CoordenadasIn();
    }

    /**
     * Create an instance of {@link DistribuidorOut }
     * 
     */
    public DistribuidorOut createDistribuidorOut() {
        return new DistribuidorOut();
    }

    /**
     * Create an instance of {@link DistribuidorPorCampoIn }
     * 
     */
    public DistribuidorPorCampoIn createDistribuidorPorCampoIn() {
        return new DistribuidorPorCampoIn();
    }

    /**
     * Create an instance of {@link PoblacionIn }
     * 
     */
    public PoblacionIn createPoblacionIn() {
        return new PoblacionIn();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Coordenadas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.distribuidores.movistar/xsd", name = "coordenadas", scope = CoordenadasOut.class)
    public JAXBElement<Coordenadas> createCoordenadasOutCoordenadas(Coordenadas value) {
        return new JAXBElement<Coordenadas>(_CoordenadasOutCoordenadas_QNAME, Coordenadas.class, CoordenadasOut.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Servicio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.distribuidores.movistar/xsd", name = "listaServicio", scope = DistribuidorIn.class)
    public JAXBElement<Servicio> createDistribuidorInListaServicio(Servicio value) {
        return new JAXBElement<Servicio>(_DistribuidorInListaServicio_QNAME, Servicio.class, DistribuidorIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.distribuidores.movistar/xsd", name = "poblacion", scope = CalleIn.class)
    public JAXBElement<String> createCalleInPoblacion(String value) {
        return new JAXBElement<String>(_CalleInPoblacion_QNAME, String.class, CalleIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.distribuidores.movistar/xsd", name = "provincia", scope = CalleIn.class)
    public JAXBElement<String> createCalleInProvincia(String value) {
        return new JAXBElement<String>(_CalleInProvincia_QNAME, String.class, CalleIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.distribuidores.movistar/xsd", name = "cp", scope = DistribuidorPorCPIn.class)
    public JAXBElement<String> createDistribuidorPorCPInCp(String value) {
        return new JAXBElement<String>(_DistribuidorPorCPInCp_QNAME, String.class, DistribuidorPorCPIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.distribuidores.movistar/xsd", name = "poblacion", scope = DistribuidorPorDireccionIn.class)
    public JAXBElement<String> createDistribuidorPorDireccionInPoblacion(String value) {
        return new JAXBElement<String>(_CalleInPoblacion_QNAME, String.class, DistribuidorPorDireccionIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.distribuidores.movistar/xsd", name = "calle", scope = DistribuidorPorDireccionIn.class)
    public JAXBElement<String> createDistribuidorPorDireccionInCalle(String value) {
        return new JAXBElement<String>(_DistribuidorPorDireccionInCalle_QNAME, String.class, DistribuidorPorDireccionIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.distribuidores.movistar/xsd", name = "provincia", scope = DistribuidorPorDireccionIn.class)
    public JAXBElement<String> createDistribuidorPorDireccionInProvincia(String value) {
        return new JAXBElement<String>(_CalleInProvincia_QNAME, String.class, DistribuidorPorDireccionIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.distribuidores.movistar/xsd", name = "poblacion", scope = CoordenadasIn.class)
    public JAXBElement<String> createCoordenadasInPoblacion(String value) {
        return new JAXBElement<String>(_CalleInPoblacion_QNAME, String.class, CoordenadasIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.distribuidores.movistar/xsd", name = "provincia", scope = CoordenadasIn.class)
    public JAXBElement<String> createCoordenadasInProvincia(String value) {
        return new JAXBElement<String>(_CalleInProvincia_QNAME, String.class, CoordenadasIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.distribuidores.movistar/xsd", name = "campo", scope = DistribuidorPorCampoIn.class)
    public JAXBElement<String> createDistribuidorPorCampoInCampo(String value) {
        return new JAXBElement<String>(_DistribuidorPorCampoInCampo_QNAME, String.class, DistribuidorPorCampoIn.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.distribuidores.movistar/xsd", name = "provincia", scope = PoblacionIn.class)
    public JAXBElement<String> createPoblacionInProvincia(String value) {
        return new JAXBElement<String>(_CalleInProvincia_QNAME, String.class, PoblacionIn.class, value);
    }

}
