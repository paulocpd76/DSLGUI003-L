package Controller;

import Proxemic.Dilmo;
import Proxemic.ProxZone;

public class ValtionDIL {
	Dilmo dilmo;
	public ValtionDIL(Double intimate, Double personal,Double social,Double publicZone) {
		super();
		// TODO Auto-generated constructor stub
		ProxZone p= new ProxZone(intimate, personal, social, publicZone);
	    this.dilmo= new Dilmo(p);
	}
	
	public Dilmo getDilmo() {
		return dilmo;
	}


}
