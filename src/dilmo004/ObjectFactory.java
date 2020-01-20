//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.12.30 à 11:13:13 PM CET 
//


package dilmo004;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dilmo004 package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dilmo004
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Proxemic }
     * 
     */
    public Proxemic createProxemic() {
        return new Proxemic();
    }

    /**
     * Create an instance of {@link Proxemic.Zone }
     * 
     */
    public Proxemic.Zone createProxemicZone() {
        return new Proxemic.Zone();
    }

    /**
     * Create an instance of {@link Proxemic.Entity }
     * 
     */
    public Proxemic.Entity createProxemicEntity() {
        return new Proxemic.Entity();
    }

}
