package dungeoneering;

import java.util.ArrayList;

import org.powerbot.script.wrappers.GameObject;

import dungeoneering.Room;

public class Door {
	public static final ArrayList<Integer> GUARDIAN_LIST = new ArrayList<>();
	public static final ArrayList<Integer> NONE_LIST = new ArrayList<>();
	public static final ArrayList<Integer> PUZZLE_LIST = new ArrayList<>();
	public GameObject id;
	public Door(GameObject id) {
		this.id = id;
	}
	
	public enum DoorType {
		GUARDIAN,SKILL,KEY,NONE,PUZZLE, UNKNOWN
	}
	
	public int getId() {
		return id.getId();
	}
	/*
	 * gets the type of the door, will be used in later methods
	 */
	public DoorType getDoorType(Door door) {
		getDoors();
		if(GUARDIAN_LIST.contains(door.getId())) {
			return DoorType.GUARDIAN;
		} else {
			if(NONE_LIST.contains(door.getId())) {
				return DoorType.NONE;
			} else {
				if(PUZZLE_LIST.contains(door.getId())) {
					return DoorType.PUZZLE;
				}
			}
		}
		
		return DoorType.UNKNOWN;
	}
	/*
	 * returns the ALL_DOORS list from dungoneering.Room
	 */
	public static ArrayList<Integer> getAllDoors() {
		return Room.ALL_DOORS;
	}
	/*
	 * return each individual ArrayList from each of dungeoneering.Room
	 * arrays
	 */
	public static ArrayList<Integer> getDoors() {
		for(int i:Room.GUARDIAN_DOORS) {
			GUARDIAN_LIST.add(i);
			return GUARDIAN_LIST;
		}
		for(int i:Room.COMPLETED_DOORS) {
			NONE_LIST.add(i);
			return NONE_LIST;
		}
		for(int i:Room.PUZZLE_DOORS) {
			PUZZLE_LIST.add(i);
			return PUZZLE_LIST;
		}
		return null;
	}

}
