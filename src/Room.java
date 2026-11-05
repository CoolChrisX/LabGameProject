import java.io.Serializable;
import java.util.HashMap;
public class Room implements Serializable {
	private String name;
	private Room[] Rooms;
	private HashMap<String, Item> Inventory;
	public static HashMap<String, Room>SaveRoom;
	public boolean locked;

	public Room(String n, boolean lock) {
		name = n;
		Rooms = new Room[6];
		Inventory= new HashMap<>();
		SaveRoom= new HashMap<>();
		SaveRoom.put(name, this);
		locked = lock;
		
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return Game.rooms.get(name);
	}
	

	public void setName(String n) {
		name = n;
	}

	public void setDescription(String description) {
		Game.rooms.put(name, description);
	}

	public String toString() {
		String s = name + "\n" + Game.rooms.get(name);
		return s;
	}

	public void addExit(Room r, int direction) {
		Rooms[direction] = r;
	}

	public Room getExit(int direction) {
		return Rooms[direction];
	}

	public void setItem(Item i) {
		Inventory.put(i.getItem_name(), i);
	}

	public Item getItem(String itemname) {
		return Inventory.get(itemname);
	}
	public void removeItem(String itemname) {
		Inventory.remove(itemname);
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	}
