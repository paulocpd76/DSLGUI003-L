package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import dilmo004.Proxemic;
import dilmo004.Proxemic.Entity;
import dilmo004.Proxemic.Zone;

public class DilmoXML {

	public DilmoXML() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static boolean validateXMLSchema(String xsdPath, String xmlPath){
        try {
           SchemaFactory factory =
              SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
              Schema schema = factory.newSchema(new File(xsdPath));
              Validator validator = schema.newValidator();
              validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException e){
           System.out.println("Exception: "+e.getMessage());
           return false;
        }catch(SAXException e1){
           System.out.println("SAX Exception: "+e1.getMessage());
           return false;
        }
  		
        return true;
  	
     }
	
	
    public void  getDilmlXmlFile(String fileName, String packName ) {
	//System.out.println(" DilmoXML");
    try {
	      JAXBContext jc = JAXBContext.newInstance(packName);
	      Unmarshaller unmarshaller = jc.createUnmarshaller();
	      String pathname = fileName;
	      File file = new File(pathname);
	      Proxemic pe=(Proxemic)unmarshaller.unmarshal(  new File(pathname));
	      List<Entity> e= (List<Proxemic.Entity>)pe.getEntity();
	 
	      for (Entity entity : e) {
			System.out.print(entity.getIdentity()+"="+entity.getDistance());
			if(entity.isOrientation()) {System.out.println(" is facing to CPS");}
			else {System.out.println("**");}
		}		      
	      System.out.println("*****Proxemic Zone***********************************");
	      System.out.println(pe.getZone().getIntimate()+"/"+pe.getZone().getPersonal()+"/"+pe.getZone().getSocial()+"/"+pe.getZone().getPublic()+"/");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	
	
    }
    public List<Entity>  getLitsOfEntity(String fileName, String packName ) {
    	//System.out.println(" DilmoXML");
        try {
    	      JAXBContext jc = JAXBContext.newInstance(packName);
    	      Unmarshaller unmarshaller = jc.createUnmarshaller();
    	      String pathname = fileName;
    	      File file = new File(pathname);
    	      Proxemic pe=(Proxemic)unmarshaller.unmarshal(  new File(pathname));
    	      return (List<Proxemic.Entity>)pe.getEntity();
    	      //List<Entity> e= (List<Proxemic.Entity>)pe.getEntity();
    	 /*
    	      for (Entity entity : e) {
    			System.out.print(entity.getIdentity()+"="+entity.getDistance());
    			if(entity.isOrientation()) {System.out.println(" is facing to CPS");}
    			else {System.out.println("**");}
    		}		      
    	   */   
    	    } catch (Exception e) {
    	      e.printStackTrace();
    	    }
		return null;
    	
    	
        }
    
    public String getCPSinfo(String fileName, String packName ) {
    	try {
  	      JAXBContext jc = JAXBContext.newInstance(packName);
  	      Unmarshaller unmarshaller = jc.createUnmarshaller();
  	      String pathname = fileName;
  	      File file = new File(pathname);
  	      Proxemic pe=(Proxemic)unmarshaller.unmarshal(  new File(pathname));
  	    // System.out.println("*****Proxemic Zone***********************************");
  	    // pe.getCps();
  	     // System.out.println(pe.getZone().getIntimate()+"/"+pe.getZone().getPersonal()+"/"+pe.getZone().getSocial()+"/"+pe.getZone().getPublic()+"/");
			  	  
    	return pe.getZone().getIntimate()+"-"+pe.getZone().getPersonal()+"-"+pe.getZone().getSocial()+"-"+pe.getZone().getPublic()+"-"+pe.getCps();
    	} catch (Exception e) {
  	      e.printStackTrace();
  	    }
		return "error CPS";
	    	
    	///return Zone;
    }
  
}
