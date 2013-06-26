
package movistar.distribuidores.bean.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistribuidorPorDireccionIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistribuidorPorDireccionIn">
 *   &lt;complexContent>
 *     &lt;extension base="{http://bean.distribuidores.movistar/xsd}DistribuidorIn">
 *       &lt;sequence>
 *         &lt;element name="calle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poblacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "DistribuidorPorDireccionIn", propOrder = {
    "calle",
    "poblacion",
    "provincia"
})
public class DistribuidorPorDireccionIn
    extends DistribuidorIn
{

    @XmlElementRef(name = "calle", namespace = "http://bean.distribuidores.movistar/xsd", type = JAXBElement.class)
    protected JAXBElement<String> calle;
    @XmlElementRef(name = "poblacion", namespace = "http://bean.distribuidores.movistar/xsd", type = JAXBElement.class)
    protected JAXBElement<String> poblacion;
    @XmlElementRef(name = "provincia", namespace = "http://bean.distribuidores.movistar/xsd", type = JAXBElement.class)
    protected JAXBElement<String> provincia;

    /**
     * Gets the value of the calle property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCalle() {
        return calle;
    }

    /**
     * Sets the value of the calle property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCalle(JAXBElement<String> value) {
        this.calle = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the poblacion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPoblacion() {
        return poblacion;
    }

    /**
     * Sets the value of the poblacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPoblacion(JAXBElement<String> value) {
        this.poblacion = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the provincia property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProvincia() {
        return provincia;
    }

    /**
     * Sets the value of the provincia property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProvincia(JAXBElement<String> value) {
        this.provincia = ((JAXBElement<String> ) value);
    }

}
