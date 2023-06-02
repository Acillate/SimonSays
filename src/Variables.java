import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class Variables implements ActionListener {
	
	public static Simon simon; // make an instance of simon

	public Renderer renderer; // make an instance of renderer

	Timer timer = new Timer(1000, this); // new timer object

	public static final int WIDTH = 800, HEIGHT = 800;

	public int flashed = 0, levelUpgrade , points, clicks = 0;

	public int level = 1; //Set level int

	public int indexPattern = level + 2; // indexPattern is level + 2 for how many colors are to be displayed

	public boolean canClick = false; // canClick is set to false so the user can't click while the CPU is displaying the colors

	public boolean creatingPattern = true; // creatingPattern is true so the CPU can create the pattern

	public ArrayList<Integer> pattern; //Create an arrayList and call it pattern

	public Random random; // Random Number Gen and call it random

	public boolean matched = false; // set matched to false

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
