
package movistar.distribuidores.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import movistar.distribuidores.bean.xsd.CoordenadasIn;


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
 *         &lt;element name="entrada" type="{http://bean.distribuidores.movistar/xsd}CoordenadasIn" minOccurs="0"/>
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
    "entrada"
})
@XmlRootElement(name = "busquedaCoordenadas")
public class BusquedaCoordenadas {

    @XmlElementRef(name = "entrada", namespace = "http://ws.distribuidores.movistar", type = JAXBElement.class)
    protected JAXBElement<CoordenadasIn> entrada;

    /**
     * Gets the value of the entrada property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CoordenadasIn }{@code >}
     *     
     */
    public JAXBElement<CoordenadasIn> getEntrada() {
        return entrada;
    }

    /**
     * Sets the value of the entrada property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CoordenadasIn }{@code >}
     *     
     */
    public void setEntrada(JAXBElement<CoordenadasIn> value) {
        this.entrada = ((JAXBElement<CoordenadasIn> ) value);
    }

}
