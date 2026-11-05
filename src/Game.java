import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Game {

	static ArrayList<Item> Inventory = new ArrayList<>();

	public static void takeItem(String itemName) {
		Item item = CurrentRoom.getItem(itemName);
		if (World.Weight.get(itemName).equals("Heavy")) {
			print("This item is too heavy to carry");
		} else {
			if ((item != null) && (item.getItem_name().equals(itemName))) {
				Inventory.add(item);
				CurrentRoom.removeItem(itemName);
				print("This item is light enough to carryy");
			} else
				print("This item doesn't exist in this room");
		}
	}

	public static void print(Object obj) {
		System.out.println(obj);
	}
	public static HashMap<String, String> rooms = new HashMap<>();
	
	public static void Loadrooms() {
		try {
			Scanner fileScan = new Scanner(new File("Room_descripton.txt"));
			String r_name = "";
			String r_desc = "";
			
			while(fileScan.hasNextLine()) {
				String line = fileScan.nextLine();
				
				if (!line.equals("#")) {
					if (!r_name.equals("")) {
						r_name = line;
					} else {
						r_desc += line;
					}
				} else {
					rooms.put(r_name, r_desc);
					r_name = "";
					r_desc = "";
				}
			}
			fileScan.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void SaveFile() {
		try {
			File saveFile = new File("save0.sav"); 
			saveFile.createNewFile(); 
			
			ObjectOutputStream outStream=new ObjectOutputStream(new FileOutputStream(saveFile));
			
			outStream.writeObject(CurrentRoom);
			outStream.writeObject(Room.SaveRoom);
			outStream.writeObject(Inventory);
		outStream.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	
	}
	public static void LoadSaveFile() {
		try {
			File SaveFile = new File("save0.sav"); 
			
			ObjectInputStream InputStream=new ObjectInputStream(new FileInputStream(SaveFile));
			CurrentRoom=(Room) InputStream.readObject();
			Room.SaveRoom=(HashMap<String, Room>) InputStream.readObject();
			Inventory=(ArrayList<Item>) InputStream.readObject();
		InputStream.close();
		}
		catch(Exception ex){
			ex.printStackTrace();}
	}
	
	public static Room CurrentRoom = World.buildWorld();

	public static void move(String dir) {
		if (dir.equals("up")) {
			if (CurrentRoom.getExit(4) == null) {
				print("You cannot go this direction");
			} else
				CurrentRoom = CurrentRoom.getExit(4);
		} else if (dir.equals("down")) {
			CurrentRoom = CurrentRoom.getExit(5);
			if (CurrentRoom.getExit(5) == null) {
				print("You cannot go this direction");
			}else {
				CurrentRoom = CurrentRoom.getExit(5);
			}
		} else if (dir.equals("west")) {
				CurrentRoom = CurrentRoom.getExit(1);
				if (CurrentRoom.getExit(1) == null) {
					print("You cannot go this direction");
				} else {
					CurrentRoom = CurrentRoom.getExit(1);
				}
		} else if (dir.equals("east")) {
				CurrentRoom = CurrentRoom.getExit(0);
				if (CurrentRoom.getExit(0) == null) {
					print("You cannot go this direction");
				}else {
					CurrentRoom = CurrentRoom.getExit(0);
				}
		} else if (dir.equals("north")) {
				CurrentRoom = CurrentRoom.getExit(2);
				if (CurrentRoom.getExit(2) == null) {
					print("You cannot go this direction");
				}else {
					CurrentRoom = CurrentRoom.getExit(2);
				}
		} else if (dir.equals("south")) {
				CurrentRoom = CurrentRoom.getExit(3);
				if (CurrentRoom.getExit(3) == null) {
					print("You cannot go this direction");
				}else {
					CurrentRoom = CurrentRoom.getExit(4);
				}
		} else {
			print("This isn't a direction you can go");
		}
	}

	public static void main(String[] args) {
		Loadrooms();
		runGame();
	}

	public static void runGame() {
		String direction = "A";
		Scanner input = new Scanner(System.in);

		while (!direction.equals("exit")) {
			System.out.print("\nEnter a direction you would like to go (0,1,2,3,4,5): ");
			direction = input.nextLine().toLowerCase();
			String[] commands = direction.split(" ");
			String command = commands[0];
			

			switch (command) {
			case "go":
				if (CurrentRoom.locked) {
					print("Locked!");
				} else {
					move(commands[1]);
					print(CurrentRoom);
				}
				break;
			case "save":
				SaveFile();
				print("Game is saved");
				break;
			case "load":
				LoadSaveFile();
				print("Game uploaded");
				break;
			case "exit":
				print("Farewell");
			case "take":
				takeItem(commands[1]);
				break;
			case "i":
				for (Item i : Inventory) {
					print(i);
				}
				break;
			case "use":
				for(Item i: Inventory) {
					if (commands[1].equals(Inventory)) {
						i.use();
					}
					else {
						print("Cannot use this item");
					}
				}
			default:
				print("That is not a valid move");
			}
		}
		input.close();
	}

}
