package TestClass;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import Proxemic.Dilmo;
import Proxemic.ProxZone;

public class TestDilm {
	public static void main(String[] args) {
		
		//CASE DIO
		Boolean DIO= true;
    //CASE DI
		Boolean DI= false;
	ProxZone pz= new ProxZone(0.5,1,2,50);
	Dilmo dilmo= new Dilmo(pz);
	
	double d=  4;
 
	dilmo.setProxemicDI("paulo1", d);
	dilmo.setProxemicDI("paulo2", d);
	dilmo.setProxemicDI("paulo3", d);
	System.out.println(dilmo.getProxemicDI("paulo1"));
	System.out.println(dilmo.getProxemicDI("paulo2"));
	System.out.println(dilmo.getProxemicDI("paulo3"));
	System.out.println(pz.getEntities().size()); 
    for (int i = 0; i < pz.getEntities().size(); i++) {
		System.out.println(pz.getEntities().get(i).getIdenEntityName());;
	}
	}
	
	
}
