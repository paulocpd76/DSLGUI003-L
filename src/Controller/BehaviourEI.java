package Controller;

public class BehaviourEI {
public String zone, location,movement;

private String orientation;

public BehaviourEI(String zone, String location, String movement, String orientation) {
	super();
	this.zone = zone.trim();
	this.location = location.trim();
	this.movement = movement.trim();
	this.orientation = orientation.trim();
}


public String getZone() {
	return zone;
}
public void setZone(String zone) {
	this.zone = zone;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getMovement() {
	return movement;
}
public void setMovement(String movement) {
	this.movement = movement;
}
public String isOrientation() {
	return orientation;
}
public void setOrientation(String orientatio) {
	this.orientation = orientatio;
}

public String getEvent() {
	String inter="";
	
  //M
  if(this.getLocation().equals("null") & (this.movement.equals("positive") || 
  this.movement.equals("negative"))& this.isOrientation().equals("false")) inter="010";
  //MO
  if(this.getLocation().equals("null") & (this.movement.equals("positive") || 
		  this.movement.equals("negative"))& this.isOrientation().equals("true")) inter="011";
 
  
    if(this.getLocation().equals("null")) {
    	//000
    	if(this.movement.equals("static") & this.isOrientation().equals("false")) inter="000";
    	//0
    	if(this.movement.equals("static") & this.isOrientation().equals("true")) inter="001";
    }
    else { 
    	//LO
    	  if( this.movement.equals("static") & this.isOrientation().equals("true")) inter="101";
    	 //LM
    	if((this.movement.equals("positive") ||
    	this.movement.equals("negative")) & this.isOrientation().equals("false")) inter="110";
    	 //L
    	if(this.movement.equals("static") & this.isOrientation().equals("false")) inter="100";
    	//LMO
    	if((this.movement.equals("positive") || 
    			  this.movement.equals("negative")) & this.isOrientation().equals("true")) inter="111";
    
       }
    	String ZonTem="";
    	switch (this.getZone()) {
		case "intimiZone":ZonTem="IZ";break;
		case "personalZone":ZonTem="PZ";break;
		case "socialZone":ZonTem="SZ";break;
		case "publicZone":ZonTem="PUZ";break;
		default:break;
		}
    	
      return ZonTem+inter;
}

 
}
