
package movistar.distribuidores.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import movistar.distribuidores.bean.xsd.CalleIn;
import movistar.distribuidores.bean.xsd.CalleOut;
import movistar.distribuidores.bean.xsd.CoordenadasIn;
import movistar.distribuidores.bean.xsd.CoordenadasOut;
import movistar.distribuidores.bean.xsd.DistribuidorOut;
import movistar.distribuidores.bean.xsd.DistribuidorPorCPIn;
import movistar.distribuidores.bean.xsd.DistribuidorPorCampoIn;
import movistar.distribuidores.bean.xsd.DistribuidorPorCoordenadasIn;
import movistar.distribuidores.bean.xsd.DistribuidorPorDireccionIn;
import movistar.distribuidores.bean.xsd.PoblacionIn;
import movistar.distribuidores.bean.xsd.PoblacionOut;
import movistar.distribuidores.bean.xsd.ProvinciaOut;
import movistar.distribuidores.util.bean.xsd.Servicio;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the movistar.distribuidores.ws package. 
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

    private final static QName _BusquedaDistribuidorEntrada_QNAME = new QName("http://ws.distribuidores.movistar", "entrada");
    private final static QName _BusquedaCalleResponseReturn_QNAME = new QName("http://ws.distribuidores.movistar", "return");
    private final static QName _BusquedaProvinciaListaServicio_QNAME = new QName("http://ws.distribuidores.movistar", "listaServicio");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: movistar.distribuidores.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BusquedaDistribuidor }
     * 
     */
    public BusquedaDistribuidor createBusquedaDistribuidor() {
        return new BusquedaDistribuidor();
    }

    /**
     * Create an instance of {@link BusquedaDistribuidorCampo }
     * 
     */
    public BusquedaDistribuidorCampo createBusquedaDistribuidorCampo() {
        return new BusquedaDistribuidorCampo();
    }

    /**
     * Create an instance of {@link BusquedaDistribuidorDireccion }
     * 
     */
    public BusquedaDistribuidorDireccion createBusquedaDistribuidorDireccion() {
        return new BusquedaDistribuidorDireccion();
    }

    /**
     * Create an instance of {@link BusquedaCalleResponse }
     * 
     */
    public BusquedaCalleResponse createBusquedaCalleResponse() {
        return new BusquedaCalleResponse();
    }

    /**
     * Create an instance of {@link BusquedaDistribuidorCPResponse }
     * 
     */
    public BusquedaDistribuidorCPResponse createBusquedaDistribuidorCPResponse() {
        return new BusquedaDistribuidorCPResponse();
    }

    /**
     * Create an instance of {@link BusquedaDistribuidorDireccionResponse }
     * 
     */
    public BusquedaDistribuidorDireccionResponse createBusquedaDistribuidorDireccionResponse() {
        return new BusquedaDistribuidorDireccionResponse();
    }

    /**
     * Create an instance of {@link BusquedaDistribuidorCampoResponse }
     * 
     */
    public BusquedaDistribuidorCampoResponse createBusquedaDistribuidorCampoResponse() {
        return new BusquedaDistribuidorCampoResponse();
    }

    /**
     * Create an instance of {@link BusquedaDistribuidorCP }
     * 
     */
    public BusquedaDistribuidorCP createBusquedaDistribuidorCP() {
        return new BusquedaDistribuidorCP();
    }

    /**
     * Create an instance of {@link BusquedaPoblacionResponse }
     * 
     */
    public BusquedaPoblacionResponse createBusquedaPoblacionResponse() {
        return new BusquedaPoblacionResponse();
    }

    /**
     * Create an instance of {@link BusquedaCoordenadas }
     * 
     */
    public BusquedaCoordenadas createBusquedaCoordenadas() {
        return new BusquedaCoordenadas();
    }

    /**
     * Create an instance of {@link BusquedaCalle }
     * 
     */
    public BusquedaCalle createBusquedaCalle() {
        return new BusquedaCalle();
    }

    /**
     * Create an instance of {@link BusquedaDistribuidorResponse }
     * 
     */
    public BusquedaDistribuidorResponse createBusquedaDistribuidorResponse() {
        return new BusquedaDistribuidorResponse();
    }

    /**
     * Create an instance of {@link BusquedaProvincia }
     * 
     */
    public BusquedaProvincia createBusquedaProvincia() {
        return new BusquedaProvincia();
    }

    /**
     * Create an instance of {@link BusquedaCoordenadasResponse }
     * 
     */
    public BusquedaCoordenadasResponse createBusquedaCoordenadasResponse() {
        return new BusquedaCoordenadasResponse();
    }

    /**
     * Create an instance of {@link BusquedaPoblacion }
     * 
     */
    public BusquedaPoblacion createBusquedaPoblacion() {
        return new BusquedaPoblacion();
    }

    /**
     * Create an instance of {@link BusquedaProvinciaResponse }
     * 
     */
    public BusquedaProvinciaResponse createBusquedaProvinciaResponse() {
        return new BusquedaProvinciaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistribuidorPorCoordenadasIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "entrada", scope = BusquedaDistribuidor.class)
    public JAXBElement<DistribuidorPorCoordenadasIn> createBusquedaDistribuidorEntrada(DistribuidorPorCoordenadasIn value) {
        return new JAXBElement<DistribuidorPorCoordenadasIn>(_BusquedaDistribuidorEntrada_QNAME, DistribuidorPorCoordenadasIn.class, BusquedaDistribuidor.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistribuidorPorCampoIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "entrada", scope = BusquedaDistribuidorCampo.class)
    public JAXBElement<DistribuidorPorCampoIn> createBusquedaDistribuidorCampoEntrada(DistribuidorPorCampoIn value) {
        return new JAXBElement<DistribuidorPorCampoIn>(_BusquedaDistribuidorEntrada_QNAME, DistribuidorPorCampoIn.class, BusquedaDistribuidorCampo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistribuidorPorDireccionIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "entrada", scope = BusquedaDistribuidorDireccion.class)
    public JAXBElement<DistribuidorPorDireccionIn> createBusquedaDistribuidorDireccionEntrada(DistribuidorPorDireccionIn value) {
        return new JAXBElement<DistribuidorPorDireccionIn>(_BusquedaDistribuidorEntrada_QNAME, DistribuidorPorDireccionIn.class, BusquedaDistribuidorDireccion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalleOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "return", scope = BusquedaCalleResponse.class)
    public JAXBElement<CalleOut> createBusquedaCalleResponseReturn(CalleOut value) {
        return new JAXBElement<CalleOut>(_BusquedaCalleResponseReturn_QNAME, CalleOut.class, BusquedaCalleResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistribuidorOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "return", scope = BusquedaDistribuidorCPResponse.class)
    public JAXBElement<DistribuidorOut> createBusquedaDistribuidorCPResponseReturn(DistribuidorOut value) {
        return new JAXBElement<DistribuidorOut>(_BusquedaCalleResponseReturn_QNAME, DistribuidorOut.class, BusquedaDistribuidorCPResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistribuidorOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "return", scope = BusquedaDistribuidorDireccionResponse.class)
    public JAXBElement<DistribuidorOut> createBusquedaDistribuidorDireccionResponseReturn(DistribuidorOut value) {
        return new JAXBElement<DistribuidorOut>(_BusquedaCalleResponseReturn_QNAME, DistribuidorOut.class, BusquedaDistribuidorDireccionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistribuidorOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "return", scope = BusquedaDistribuidorCampoResponse.class)
    public JAXBElement<DistribuidorOut> createBusquedaDistribuidorCampoResponseReturn(DistribuidorOut value) {
        return new JAXBElement<DistribuidorOut>(_BusquedaCalleResponseReturn_QNAME, DistribuidorOut.class, BusquedaDistribuidorCampoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistribuidorPorCPIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "entrada", scope = BusquedaDistribuidorCP.class)
    public JAXBElement<DistribuidorPorCPIn> createBusquedaDistribuidorCPEntrada(DistribuidorPorCPIn value) {
        return new JAXBElement<DistribuidorPorCPIn>(_BusquedaDistribuidorEntrada_QNAME, DistribuidorPorCPIn.class, BusquedaDistribuidorCP.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PoblacionOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "return", scope = BusquedaPoblacionResponse.class)
    public JAXBElement<PoblacionOut> createBusquedaPoblacionResponseReturn(PoblacionOut value) {
        return new JAXBElement<PoblacionOut>(_BusquedaCalleResponseReturn_QNAME, PoblacionOut.class, BusquedaPoblacionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordenadasIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "entrada", scope = BusquedaCoordenadas.class)
    public JAXBElement<CoordenadasIn> createBusquedaCoordenadasEntrada(CoordenadasIn value) {
        return new JAXBElement<CoordenadasIn>(_BusquedaDistribuidorEntrada_QNAME, CoordenadasIn.class, BusquedaCoordenadas.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalleIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "entrada", scope = BusquedaCalle.class)
    public JAXBElement<CalleIn> createBusquedaCalleEntrada(CalleIn value) {
        return new JAXBElement<CalleIn>(_BusquedaDistribuidorEntrada_QNAME, CalleIn.class, BusquedaCalle.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Servicio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "listaServicio", scope = BusquedaProvincia.class)
    public JAXBElement<Servicio> createBusquedaProvinciaListaServicio(Servicio value) {
        return new JAXBElement<Servicio>(_BusquedaProvinciaListaServicio_QNAME, Servicio.class, BusquedaProvincia.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistribuidorOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "return", scope = BusquedaDistribuidorResponse.class)
    public JAXBElement<DistribuidorOut> createBusquedaDistribuidorResponseReturn(DistribuidorOut value) {
        return new JAXBElement<DistribuidorOut>(_BusquedaCalleResponseReturn_QNAME, DistribuidorOut.class, BusquedaDistribuidorResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PoblacionIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "entrada", scope = BusquedaPoblacion.class)
    public JAXBElement<PoblacionIn> createBusquedaPoblacionEntrada(PoblacionIn value) {
        return new JAXBElement<PoblacionIn>(_BusquedaDistribuidorEntrada_QNAME, PoblacionIn.class, BusquedaPoblacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordenadasOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "return", scope = BusquedaCoordenadasResponse.class)
    public JAXBElement<CoordenadasOut> createBusquedaCoordenadasResponseReturn(CoordenadasOut value) {
        return new JAXBElement<CoordenadasOut>(_BusquedaCalleResponseReturn_QNAME, CoordenadasOut.class, BusquedaCoordenadasResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProvinciaOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.distribuidores.movistar", name = "return", scope = BusquedaProvinciaResponse.class)
    public JAXBElement<ProvinciaOut> createBusquedaProvinciaResponseReturn(ProvinciaOut value) {
        return new JAXBElement<ProvinciaOut>(_BusquedaCalleResponseReturn_QNAME, ProvinciaOut.class, BusquedaProvinciaResponse.class, value);
    }

}
