
package movistar.distribuidores.bean.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistribuidorPorCPIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistribuidorPorCPIn">
 *   &lt;complexContent>
 *     &lt;extension base="{http://bean.distribuidores.movistar/xsd}DistribuidorIn">
 *       &lt;sequence>
 *         &lt;element name="cp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DistribuidorPorCPIn", propOrder = {
    "cp"
})
public class DistribuidorPorCPIn
    extends DistribuidorIn
{

    @XmlElementRef(name = "cp", namespace = "http://bean.distribuidores.movistar/xsd", type = JAXBElement.class)
    protected JAXBElement<String> cp;

    /**
     * Gets the value of the cp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCp() {
        return cp;
    }

    /**
     * Sets the value of the cp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCp(JAXBElement<String> value) {
        this.cp = ((JAXBElement<String> ) value);
    }

}
