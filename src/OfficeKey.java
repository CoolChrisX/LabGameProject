
public class OfficeKey extends Item{

	public OfficeKey(String i) {
		super(i);
	}
	@Override
	public void use() {
		if(Game.CurrentRoom.getName().equals("Living Room")) {
			Room office = Room.SaveRoom.get("Office");
			if (office.isLocked()) {
				office.setLocked(false);
				Game.print("You unlocked the office using the key found");
			}else 
				Game.print("Its already unlcoked. Dumbass.");
		} else
			Game.print("You jam the key into every keyhole you find. No dice");
		
	}
}
