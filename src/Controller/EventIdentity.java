package Controller;

public class EventIdentity {
	String location;
	Double movement;
	Boolean orientation;
	String identity;
	int event;
	public EventIdentity(String location, Double movement, Boolean orientation, String identity) {
		super();
		this.location = location;
		this.movement = movement;
		this.orientation = orientation;
		this.identity = identity;
	}
	
	
	public String getEvent(String zone) {
		String event= "";
		if(location.equals("null")) {
			event ="event-05";
		}
		
		else {
			
			if(orientation) {
				String m= Double.toString(movement);
				switch (m) {
				case "-1.0": event="event-01"; 	;break;
				case "1.0":event="event-02";	break;
				case "0.0":event="event-03";	break;
				}
				
			}
			 event="event-04";
		}
		
		return event+"-"+zone;
	
	}
	

	

}
