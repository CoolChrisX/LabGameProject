
public class Flashlight extends Item {
	
	public Flashlight() {
		super("Flashlight");
		foundkey=false;
	}
}	@Override
	public void use() {
		if(Game.getCurrentRoom()).getName().equals("Bedroom"));
			Game.print("You turn on the flashlight and start search for"
					+"clues and hidden treasure. Instead, find the"
					+"office key hidden under the bed.");
			Game.getCurrentRoom().setItem(new OfficeKey());
			foundkey=true;
			}
	}else 
		Game.print("You turn the flashlight on and off for giggles.");
}
