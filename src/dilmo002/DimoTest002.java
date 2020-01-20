package dilmo002;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import dilmo002.Proxemic;
import dilmo002.Proxemic.Entity;

public class DimoTest002 {
	  public static void main(String[] args) {
		    try {
		      JAXBContext jc = JAXBContext.newInstance("dilmo002");
		      Unmarshaller unmarshaller = jc.createUnmarshaller();
		      Proxemic pe=(Proxemic)unmarshaller.unmarshal(  new File("dilmo002.xml"));
		      List<Entity> e= (List<Proxemic.Entity>)pe.getEntity();
		    //  System.out.println(e.size());
		      //System.out.println(e.get(0).getDistance());
		     // System.out.println(e.get(1).getDistance());
		      //if(e.get(0).isOrientation())System.out.println("Facing to CPS");
		      
		      for (Entity entity : e) {
				System.out.print(entity.getIdentity()+"="+entity.getDistance());
				if(entity.isOrientation()) {System.out.println(" is facing to CPS");}
				else {System.out.println("**");}
			}		      
		      System.out.println("*****Proxemic Zone***********************************");
		      System.out.println(pe.getCps()+"/"+pe.getZone().getIntimate()+"/"+pe.getZone().getPersonal()+"/"+pe.getZone().getSocial()+"/"+pe.getZone().getPublic()+"/");
		     
		      
		      
		   //   Shiporder sh = (Shiporder) unmarshaller.unmarshal(  new File("biblio.xml"));
		    //  List<Item> ite= (List<Item>) sh.getItem();
		     // System.out.println(ite.size());
		   //  System.out.println(sh.getShipto().getName());
		     // ite.get(0).getNote();
		    //  sh.getShipto().getName();
		      //ite.get(0).getPrice();
		      /*
		      List<Livre> livres = bibliotheque.getLivre();
		      for (int i = 0; i < livres.size(); i++) {
		      Livre livre = livres.get(i);
		      System.out.println("Livre ");
		      System.out.println("Titre : " + livre.getTitre());
		      System.out.println("Auteur : " + livre.getAuteur().getNom() 
		        + " " +livre.getAuteur().getPrenom());
		      System.out.println("Editeur : " + livre.getEditeur());
		      System.out.println();
		      }
		      
		      */
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
}
