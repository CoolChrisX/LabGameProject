import java.util.HashMap;

public class World {
	static HashMap<String, String> Weight=new HashMap<>();
	public static HashMap<Room, String> Rooms=new HashMap<>();
	public static void main(String[] args){
		
	}
	
	public static Room buildWorld() {
		Room LivingRoom=new Room("LivingRoom", false);
		Room Office=new Room("Office", true);
		Room Kitchen=new Room("Kitchen", false);
		Room Bedroom=new Room("Bedroom", false);
		Room Attic=new Room("Attic", true);
		Room Garage=new Room("Garage", true);
		Rooms.put((Bedroom), "Bedroom");
		Rooms.put((LivingRoom), "LivingRoom");
		Rooms.put((Kitchen), "Kitchen");
		Rooms.put((Office), "Office");
		Rooms.put((Garage), "Garage");
		Attic.addExit(Bedroom, 3); // 3=south
		Bedroom.addExit(Attic, 4); // 4=up
		Bedroom.addExit(LivingRoom, 3);// 3=south
		LivingRoom.addExit(Office, 1);// 1=west
		LivingRoom.addExit(Kitchen, 0);// 0=east
		LivingRoom.addExit(Bedroom, 2); // 2=north
		Kitchen.addExit(Garage, 3);// 3=south
		Kitchen.addExit(LivingRoom, 1); // 1=west
		Office.addExit(LivingRoom, 0); // 0=east
		Garage.addExit(Kitchen, 2); // 2=north
		Item Office_key=new Tool();
		Item tool=new Tool();
		Item safe=new Tool();
		Item computer=new Tool();
		Item musicbox=new Tool();
		Item flashlight=new Tool();
		Item knife=new Tool();
		Item mysteriousorb=new Tool();
		
		
		Bedroom.setItem(Office_key);
		LivingRoom.setItem(tool);
		Office.setItem(computer);
		Office.setItem(safe);
		LivingRoom.setItem(musicbox);
		Kitchen.setItem(mysteriousorb);
		Kitchen.setItem(flashlight);
		Kitchen.setItem(knife);
		Weight.put("officekey", "Light");
		Weight.put("tool", "Light");
		Weight.put("computer","Heavy");
		Weight.put("safe", "Heavy");
		Weight.put("musicbox","Heavy");
		Weight.put("mysteriousorb","Light");
		Weight.put("flashlight","Light");
		Weight.put("knife", "Light");
		return LivingRoom;
	}
	
}
