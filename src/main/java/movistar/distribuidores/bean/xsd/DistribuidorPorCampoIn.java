
package movistar.distribuidores.bean.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistribuidorPorCampoIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistribuidorPorCampoIn">
 *   &lt;complexContent>
 *     &lt;extension base="{http://bean.distribuidores.movistar/xsd}DistribuidorIn">
 *       &lt;sequence>
 *         &lt;element name="campo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistribuidorPorCampoIn", propOrder = {
    "campo"
})
public class DistribuidorPorCampoIn
    extends DistribuidorIn
{

    @XmlElementRef(name = "campo", namespace = "http://bean.distribuidores.movistar/xsd", type = JAXBElement.class)
    protected JAXBElement<String> campo;

    /**
     * Gets the value of the campo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCampo() {
        return campo;
    }

    /**
     * Sets the value of the campo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCampo(JAXBElement<String> value) {
        this.campo = ((JAXBElement<String> ) value);
    }

}
