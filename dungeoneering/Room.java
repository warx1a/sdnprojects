package dungeoneering;

import java.util.ArrayList;

import org.powerbot.script.lang.BasicNamedQuery;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Npc;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TileMatrix;

import utils.Task;


///dungeoneering rooms are 13x13

public class Room extends Task {
	public static MethodContext d;
	private int index;
	private Door door1;
	private Door door2;
	private Door door3;
	private Door door4;
	public Room(MethodContext ctx, int index, Room room, Door door1, Door door2, Door door3, Door door4) {
		super(ctx);
		d = ctx;
		this.index = index;
		this.door1 = door1;
		this.door2 = door2;
		this.door3 = door3;
		this.door4 = door4;
		// TODO Auto-generated constructor stub
	}
	
	public Room(int index2, Integer integer, Integer integer2,
			Integer integer3, Integer integer4) {
		super(d);
	}

	public enum RoomState {
		COMPLETED,IN_PROGRESS,NOT_DONE,UNKNOWN
	}
	
	public static final int[] MONSTERLIST = {666,777,888,999};

	public static final int[] PUZZLE_DOORS = { 49306, 49335, 49336, 49337, 49338, 49375, 49376, 49377, 49378, 49379, 49380,
		49387, 49388, 49389, 49462, 49463, 49464, 49504, 49505, 49506, 49516, 49517, 49518, 49564, 49565, 49566,
		49574, 49575, 49576, 49577, 49578, 49579, 49603, 49604, 49605, 49606, 49607, 49608, 49625, 49626, 49627,
		49644, 49645, 49646, 49650, 49651, 49652, 49677, 49678, 49679, 53987, 53988, 53989, 53990, 53992, 54000,
		54001, 54006, 54067, 54070, 54071, 54072, 54073, 54106, 54107, 54108, 54109, 54236, 54274, 54284, 54299,
		54300, 54315, 54316, 54317, 54318, 54319, 54320, 54335, 54360, 54361, 54362, 54363, 54404, 54417, 54418,
		54620, 55478, 55479, 55480, 55481, 56079, 56081, 56526, 56527, 56528, 56529 };
	public static final int[] COMPLETED_DOORS = { 50342, 50343, 50344, 53948, 55762 };
	public static final int[] GUARDIAN_DOORS = { 50346, 50347, 50348,53949, 55763 };
	public final static ArrayList<Integer> ALL_DOORS = new ArrayList<>();
	
	public static int doorcount;
	
	public static ArrayList<Tile> doorarray = new ArrayList<>();
	
	public static ArrayList<Tile> tilearray = new ArrayList<>();
	
	public static ArrayList<Integer> doorids = new ArrayList<>();
	public static ArrayList<Integer> MONSTERARRAY;
	
	/*
	 * combines all the types of doors into one large list
	 * used farther down
	 */
	public static ArrayList<Integer> getAllDoors() {
		int index = 0;
		while(index < PUZZLE_DOORS.length) {
			ALL_DOORS.add(PUZZLE_DOORS[index]);
			index++;
		}
		index = 0;
		while(index < COMPLETED_DOORS.length) {
			ALL_DOORS.add(COMPLETED_DOORS[index]);
			index++;
		}
		index = 0;
		while(index < GUARDIAN_DOORS.length) {
			ALL_DOORS.add(GUARDIAN_DOORS[index]);
			index++;
		}
		return ALL_DOORS;
	}
	
	/*
	 * maps the dungeoneering room and accounts for not all rooms being square
	 * ALL dungeoneering rooms dimensions are 13x13 with some tiles being null,
	 * ex. in the heart shaped rooms or a chasm room
	 */
	
	public static Room createRoom(int index) {
		mapRoom();
		getDoorCount(tilearray);
		ArrayList<Integer> vars = getDoorIds(tilearray);
		Room room = new Room(index,vars.get(0),vars.get(1),vars.get(2),vars.get(3));
		System.out.print(room);
		return room;
	}
	
	public static ArrayList<Tile> mapRoom() {
		int index = 0;
		int secondary_index = 0;
		Tile start_map;
		///start_map = d.players.local().getLocation();
		start_map = new Tile(3000,3000,0);
		while(secondary_index <= 13) {
			while(index <= 13) {
				Tile tilemapper = (new Tile(start_map.getX() + index, start_map.getY() + secondary_index,0));
				if(d.movement.isReachable(start_map,tilemapper) && tilemapper.getMatrix(d).isValid()) {
					tilearray.add(tilemapper);
				}
				index++;
			} secondary_index++;
			index = 0;
		}
		System.out.println(tilearray);
		return tilearray;
	}
	
	/*return the ammount of doors in a room,
	 * should be used in conjunction with mapRoom()
	 * basically returns the tiles with no objects on it
	 */
	public static ArrayList<Tile> getObjects(ArrayList<Tile> list) {
		ArrayList<Tile> noObjList = new ArrayList<>();
		for(Tile t: list) {
			if(d.objects.at(t) == null) {
				noObjList.add(t);
			}
		}
		return noObjList;
	}
	/*get count of doors
	 * ex: if 4 doors exist:
	 * 		|	*	|
	 * 		*		*
	 * 		|	*	|
	 * you know there's a door on each side
	 */
	public static int getDoorCount(ArrayList<Tile> list) {
		getAllDoors();
		for(Tile t: list) {
			final BasicNamedQuery<GameObject> objectlist = d.objects.at(t);
			for (GameObject j:objectlist) {
				if(ALL_DOORS.contains(j.getId())) {
					doorcount++;
				}
			}
		}
		return doorcount;
	}
	
	/*
	 * gets the tile(s) location for each of the doors, will always return doubles
	 * since each door takes up 2 tiles, doesn't matter though just need to know the location
	 * of one of the tiles
	 */
	public static ArrayList<Tile> getDoorLocation(ArrayList<Tile> list) {
		getAllDoors();
		for(Tile t: list) {
			final BasicNamedQuery<GameObject> objectlist = d.objects.at(t);
			for (GameObject j:objectlist) {
				if(ALL_DOORS.contains(j.getId())) {
					doorarray.add(j.getLocation());
				}
			}
		}
		return doorarray;
	}
	/* should be used in conjunction with getDoorLocation()
	 * basically gets the id of all the doors from the door locations list
	 */
	public static ArrayList<Integer> getDoorIds(ArrayList<Tile> list) {
		getAllDoors();
		for(Tile t:list) {
			final BasicNamedQuery<GameObject> objectlist = d.objects.at(t);
			for(GameObject j:objectlist) {
				if(ALL_DOORS.contains(j.getId())) {
					doorids.add(j.getId());
				}
			}
		}
		return doorids;
	}
	
	/*
	 * returns the state of the room you are currently in, also currently means
	 * that you will have to go inside of every room of the dungeon
	 * to get state, will work on workaround for that later
	 */
	public static RoomState getRoomState(Room room) {
		Area area = new Area(tilearray.get(0),tilearray.get(169));
		BasicNamedQuery<Npc> npclist = d.npcs.within(area);
		mapRoom();
		for(int i:MONSTERLIST) {
			MONSTERARRAY.add(i);
		}
		
		
		if(tilearray.contains(d.players.local().getLocation())) {
			return RoomState.IN_PROGRESS;
		} else {
			for(Npc n: npclist) {
					if(MONSTERARRAY.contains(n.getId())) {
						return RoomState.IN_PROGRESS;
					}
				}
			}
		return RoomState.UNKNOWN;
		}
		

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		mapRoom();
	}
	

}
