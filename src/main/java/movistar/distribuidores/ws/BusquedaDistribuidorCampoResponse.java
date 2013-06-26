
package movistar.distribuidores.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import movistar.distribuidores.bean.xsd.DistribuidorOut;


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
 *         &lt;element name="return" type="{http://bean.distribuidores.movistar/xsd}DistribuidorOut" minOccurs="0"/>
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
    "_return"
})
@XmlRootElement(name = "busquedaDistribuidorCampoResponse")
public class BusquedaDistribuidorCampoResponse {

    @XmlElementRef(name = "return", namespace = "http://ws.distribuidores.movistar", type = JAXBElement.class)
    protected JAXBElement<DistribuidorOut> _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DistribuidorOut }{@code >}
     *     
     */
    public JAXBElement<DistribuidorOut> getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DistribuidorOut }{@code >}
     *     
     */
    public void setReturn(JAXBElement<DistribuidorOut> value) {
        this._return = ((JAXBElement<DistribuidorOut> ) value);
    }

}
