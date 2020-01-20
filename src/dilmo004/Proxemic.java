//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2019.12.30 � 11:13:13 PM CET 
//


package dilmo004;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cps" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zone">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="intimate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="personal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="social" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="public" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="entity" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="identity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="movement" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="orientation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "cps",
    "zone",
    "entity"
})
@XmlRootElement(name = "proxemic")
public class Proxemic {

    @XmlElement(required = true)
    protected String cps;
    @XmlElement(required = true)
    protected Proxemic.Zone zone;
    @XmlElement(required = true)
    protected List<Proxemic.Entity> entity;

    /**
     * Obtient la valeur de la propri�t� cps.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCps() {
        return cps;
    }

    /**
     * D�finit la valeur de la propri�t� cps.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCps(String value) {
        this.cps = value;
    }

    /**
     * Obtient la valeur de la propri�t� zone.
     * 
     * @return
     *     possible object is
     *     {@link Proxemic.Zone }
     *     
     */
    public Proxemic.Zone getZone() {
        return zone;
    }

    /**
     * D�finit la valeur de la propri�t� zone.
     * 
     * @param value
     *     allowed object is
     *     {@link Proxemic.Zone }
     *     
     */
    public void setZone(Proxemic.Zone value) {
        this.zone = value;
    }

    /**
     * Gets the value of the entity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Proxemic.Entity }
     * 
     * 
     */
    public List<Proxemic.Entity> getEntity() {
        if (entity == null) {
            entity = new ArrayList<Proxemic.Entity>();
        }
        return this.entity;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="identity" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="movement" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="orientation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "distance",
        "identity",
        "location",
        "movement",
        "orientation"
    })
    public static class Entity {

        protected double distance;
        @XmlElement(required = true)
        protected String identity;
        @XmlElement(required = true)
        protected String location;
        protected double movement;
        protected boolean orientation;

        /**
         * Obtient la valeur de la propri�t� distance.
         * 
         */
        public double getDistance() {
            return distance;
        }

        /**
         * D�finit la valeur de la propri�t� distance.
         * 
         */
        public void setDistance(double value) {
            this.distance = value;
        }

        /**
         * Obtient la valeur de la propri�t� identity.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIdentity() {
            return identity;
        }

        /**
         * D�finit la valeur de la propri�t� identity.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIdentity(String value) {
            this.identity = value;
        }

        /**
         * Obtient la valeur de la propri�t� location.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocation() {
            return location;
        }

        /**
         * D�finit la valeur de la propri�t� location.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocation(String value) {
            this.location = value;
        }

        /**
         * Obtient la valeur de la propri�t� movement.
         * 
         */
        public double getMovement() {
            return movement;
        }

        /**
         * D�finit la valeur de la propri�t� movement.
         * 
         */
        public void setMovement(double value) {
            this.movement = value;
        }

        /**
         * Obtient la valeur de la propri�t� orientation.
         * 
         */
        public boolean isOrientation() {
            return orientation;
        }

        /**
         * D�finit la valeur de la propri�t� orientation.
         * 
         */
        public void setOrientation(boolean value) {
            this.orientation = value;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="intimate" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="personal" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="social" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="public" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
        "intimate",
        "personal",
        "social",
        "_public"
    })
    public static class Zone {

        protected double intimate;
        protected double personal;
        protected double social;
        @XmlElement(name = "public")
        protected double _public;

        /**
         * Obtient la valeur de la propri�t� intimate.
         * 
         */
        public double getIntimate() {
            return intimate;
        }

        /**
         * D�finit la valeur de la propri�t� intimate.
         * 
         */
        public void setIntimate(double value) {
            this.intimate = value;
        }

        /**
         * Obtient la valeur de la propri�t� personal.
         * 
         */
        public double getPersonal() {
            return personal;
        }

        /**
         * D�finit la valeur de la propri�t� personal.
         * 
         */
        public void setPersonal(double value) {
            this.personal = value;
        }

        /**
         * Obtient la valeur de la propri�t� social.
         * 
         */
        public double getSocial() {
            return social;
        }

        /**
         * D�finit la valeur de la propri�t� social.
         * 
         */
        public void setSocial(double value) {
            this.social = value;
        }

        /**
         * Obtient la valeur de la propri�t� public.
         * 
         */
        public double getPublic() {
            return _public;
        }

        /**
         * D�finit la valeur de la propri�t� public.
         * 
         */
        public void setPublic(double value) {
            this._public = value;
        }

    }

}
