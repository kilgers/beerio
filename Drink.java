package beerio;

public class Drink {
	public int drinkId;

	public String name;
	public long size;
	public long abv;

	public int getDrinkId() {
		return drinkId;
	}
	public void setDrinkId(int drinkId) {
		this.drinkId = drinkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public long getAbv() {
		return abv;
	}
	public void setAbv(long abv) {
		this.abv = abv;
	}
}
