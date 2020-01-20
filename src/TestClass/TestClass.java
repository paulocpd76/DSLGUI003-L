package TestClass;


import java.util.List;

import Controller.DilmoXML;
import dilmo004.Proxemic.Entity;

public class TestClass {
public static void main(String[] args) {
	DilmoXML d= new DilmoXML();
	List<Entity> e = d.getLitsOfEntity("dilmo002.xml", "dilmo002");
	   for (Entity entity : e) {
			System.out.print(entity.getIdentity()+"="+entity.getDistance());
			if(entity.isOrientation()) {System.out.println(" is facing to CPS");}
			else {System.out.println("**");}
		}	
	//List<Entity> a = d.getDilmlXmlE("dilmo002.xm;l", "dilmo002");
	//System.out.println(a.get(0).getIdentity());

}  
}
