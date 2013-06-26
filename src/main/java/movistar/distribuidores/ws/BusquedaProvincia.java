
package movistar.distribuidores.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import movistar.distribuidores.util.bean.xsd.Servicio;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listaServicio" type="{http://bean.util.distribuidores.movistar/xsd}Servicio" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listaServicio"
})
@XmlRootElement(name = "busquedaProvincia")
public class BusquedaProvincia {

    @XmlElementRef(name = "listaServicio", namespace = "http://ws.distribuidores.movistar", type = JAXBElement.class)
    protected JAXBElement<Servicio> listaServicio;

    /**
     * Gets the value of the listaServicio property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Servicio }{@code >}
     *     
     */
    public JAXBElement<Servicio> getListaServicio() {
        return listaServicio;
    }

    /**
     * Sets the value of the listaServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Servicio }{@code >}
     *     
     */
    public void setListaServicio(JAXBElement<Servicio> value) {
        this.listaServicio = ((JAXBElement<Servicio> ) value);
    }

}
