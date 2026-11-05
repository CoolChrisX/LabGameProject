import java.io.Serializable;
import java.util.HashMap;

public class Item implements Serializable {
	private String item_name;
	private HashMap SaveItem;
	public Item(String i) {
		item_name=i;
		SaveItem=new HashMap<>();
		SaveItem.put(i, this);
	}	
	public String getItem_name() {
		return item_name;
	}
	
	public void setName(String i) {
		item_name=i;
	}
	
	public String toString() {
		return item_name;
	}
	public void use() {
		System.out.print("This item cannnot be used");
	}
}
	
