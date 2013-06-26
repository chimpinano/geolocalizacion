
package movistar.distribuidores.bean.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import movistar.distribuidores.util.bean.xsd.Distribuidor;


/**
 * <p>Java class for DistribuidorOut complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistribuidorOut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="listaDistribuidor" type="{http://bean.util.distribuidores.movistar/xsd}Distribuidor" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistribuidorOut", propOrder = {
    "codigoError",
    "listaDistribuidor"
})
public class DistribuidorOut {

    protected Integer codigoError;
    @XmlElement(nillable = true)
    protected List<Distribuidor> listaDistribuidor;

    /**
     * Gets the value of the codigoError property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoError() {
        return codigoError;
    }

    /**
     * Sets the value of the codigoError property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoError(Integer value) {
        this.codigoError = value;
    }

    /**
     * Gets the value of the listaDistribuidor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaDistribuidor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaDistribuidor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Distribuidor }
     * 
     * 
     */
    public List<Distribuidor> getListaDistribuidor() {
        if (listaDistribuidor == null) {
            listaDistribuidor = new ArrayList<Distribuidor>();
        }
        return this.listaDistribuidor;
    }

}
