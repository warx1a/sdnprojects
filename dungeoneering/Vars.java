package dungeoneering;

public class Vars {
	
	public static int dung_entrance = 48498;
	
	public enum Doors {
		FROZEN_GUARD(50346,50342),
		FROZEN_KEY(666,666);
		
		private int id;
		private int door;

		Doors(int id, int door) {
			this.id = id;
			this.door = door;
		}
		
		public int getId() {
			return id;
		}
		public int getDoor() {
			return door;
		}
	}
	
	public enum Keys {
		CHRIMSON(8768,6456),
		BLUE(7858,8563);
		
		private int id;
		private int door;

		Keys(int id, int door) {
			this.id = id;
			this.door = door;
		}
		
		public int getId() {
			return id;
		}
		public int getDoor() {
			return door;
		}
	}
	
	public static void main(String[] args) {
		System.out.print(Keys.CHRIMSON.getId());
	}

}
