package dungeoneering;

import java.util.ArrayList;
import java.util.List;

import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;

import utils.Task;

@Manifest(authors="Snoop Dogg", name = "ThaDogg'sDung", description="Rips shiz up")
public class Main extends PollingScript{
	public static String status;
	
	private List<Task> tasklist = new ArrayList<>();
	
	@Override
	public void start() {
		tasklist.add(new Start(getContext()));
	}

	@Override
	public int poll() {
		Room.mapRoom();
		return 50;
	}
		
	}
