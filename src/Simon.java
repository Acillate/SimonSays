import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Simon extends audio implements ActionListener, MouseListener
{
	
	audio sounds = new audio();
	Variables var = new Variables();

	public Simon()
	{
		JFrame frame = new JFrame("Simon"); // new JFrame displaying game name 

		renderer = new Renderer(); // new Renderer object 

		frame.setSize(WIDTH + 8, HEIGHT + 30);// setting the size for the screen hard coded to the height and width we set  
		frame.setVisible(true);
		frame.addMouseListener(this); // mouse listener to be able to do mouse inputs
		frame.setResizable(false); // Resizable is false so the user can't change the size for the window
		frame.add(renderer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		start(); //Go to the start method to be able to start the game

		timer.start(); // timer starts
	}
	
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// Method				:	void start
//
// Method parameters	:	No method parameters
//
// Method return		:	void
//
// Synopsis				:   This method sets everything up for the round of matchgame to be played
//								
//
// Modifications		:
//								Date			Developer				Notes
//								----			---------				-----
//							 2022-05-10		  A. Richardson		    Initial setup
//
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

	public void start()
	{
		random = new Random(); //New random object
		
		pattern = new ArrayList<Integer>(); // New Pattern array list
		
		indexPattern = level + 2; // set indexPattern to the amount of colors to be flashed
		
		flashed = 0; // set flashed to 0 
		
		creatingPattern = true; // creatingPattern becomes true so the CPU can create the pattern
		
		canClick = false; // canClick becomes false the user can't click while the pattern is being displayed
		
		matched = true;	// set matched to true
		
		clicks = 0; // Number of clicks the user does
		
		
		if(levelUpgrade == 4) {

			levelUpgrade = 0;
		}
		
		
		timer.start(); // Starts the timer 
		
	}

	public static void main(String[] args)
	{
		simon = new Simon(); 
	}
	
	
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// Method				:	void actionPerformed(ActionEvent e)
//
// Method parameters	:	ActionEvent - indicates that a component-defined action occurred.
//
// Method return		:	void
//
// Synopsis				:   This method randomly picks colors to be flashed 
//							
//
// Modifications		:
//							Date			Developer				Notes
//							----			---------				-----
//						 2022-05-10		  A. Richardson		    Initial setup
//
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

	@Override
	public void actionPerformed(ActionEvent e)
	{

		if (creatingPattern) //Boolean for creating a pattern
		{

			if (indexPattern >= pattern.size())
			{
				flashed = random.nextInt(20) % 4 + 1; //creates the randomly colors to be flashed
				pattern.add(flashed); //adds the random colors to the arrayList
			}
			else
			{
				timer.stop(); //Stop the timer
				canClick = true; // Can click becomes true after the pattern is created so the user cant click on the screen while the pattern is being displayed
				indexPattern = 0; // Reset indexPattern to 0 

			}

			creatingPattern = false; // creatingPattern becomes false so it wont create another pattern

		}
		else {

			if (indexPattern <= pattern.size()) {
				timer.stop(); 
				canClick = true;
				indexPattern = 0;

			} else {

				creatingPattern = true;
			}


			flashed = 0;


		}

		renderer.repaint(); // Repaint the screen every tick
	}
	
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// Method				:	void paint(Graphics2D g)
//
// Method parameters	:	(Graphics2D g)
//
// Method return		:	void
//
// Synopsis				:   This method paints our matchgame board onto the screen 
//									
//
// Modifications		:
//									Date			Developer				Notes
//									----			---------				-----
//								 2022-05-10		  A. Richardson		    Initial setup
//
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

	public void paint(Graphics2D g)
	{
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (flashed == 1) // If flashed is 1 then flash the color green
		{
			g.setColor(Color.GREEN); // Green becomes a brighter color if flashed is 1
		}
		else // Else don't flash green
		{
			g.setColor(Color.GREEN.darker()); //Sets color to a dark green if flashed is not 1
		}

		g.fillRect(0, 0, WIDTH / 2, HEIGHT / 2); // Draw green in the top left

		if (flashed == 2) // If flashed is 2 then flash the color red
		{
			g.setColor(Color.RED); // Red becomes a brighter color if flashed is 2
		}
		else // Else don't flash red
		{
			g.setColor(Color.RED.darker()); //Sets color to a dark red if flashed is not 2
		}

		g.fillRect(WIDTH / 2, 0, WIDTH / 2, HEIGHT / 2); // Draw red in the top right

		if (flashed == 3) // If flashed is 3 then flash the color orange
		{
			g.setColor(Color.ORANGE); // Orange becomes a brighter color if flashed is 3
		}
		else // Else don't flash orange
		{
			g.setColor(Color.ORANGE.darker()); //Sets color to a dark orange if flashed is not 3
		}

		g.fillRect(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2); // draw orange in the bottom left

		if (flashed == 4) // If flashed is 4 then flash the color blue
		{
			g.setColor(Color.BLUE); // Blue becomes a brighter color if flashed is 4
		}
		else // Else don't flash blue
		{
			g.setColor(Color.BLUE.darker()); //Sets color to a dark blue if flashed is not 4
		}

		g.fillRect(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2); // draw blue in the bottom right

		g.setColor(Color.BLACK); // Color black
		g.fillRoundRect(220, 220, 350, 350, 300, 300); // Draw a round rectangle 
		g.fillRect(WIDTH / 2 - WIDTH / 12, 0, WIDTH / 7, HEIGHT); // Draw black lines
		g.fillRect(0, WIDTH / 2 - WIDTH / 12, WIDTH, HEIGHT / 7); // Draw black lines

		g.setColor(Color.GRAY); // Color gray
		g.setStroke(new BasicStroke(200)); 
		g.drawOval(-100, -100, WIDTH + 200, HEIGHT + 200); // draw grey oval in the background

		g.setColor(Color.BLACK);// color black
		g.setStroke(new BasicStroke(10)); // draw a black stroke around the match game board
		g.drawOval(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.WHITE); // color white
		g.setFont(new Font("Arial", 1, 50)); // set font type and size
		g.drawString("Points = " + points, 270, HEIGHT / 2 - 50); // displaying points on the screen

		g.setColor(Color.WHITE); // color white
		g.setFont(new Font("Arial", 1, 50)); // set font type and size
		g.drawString("Level = " + level, 280, 500); // displaying the level on the screen
	}

// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// Method				:	void mousePressed(MouseEvent e)
//
// Method parameters	:	(MouseEvent e)
//
// Method return		:	void
//
// Synopsis				:   This method lets the user click on the screen 
//										
//
// Modifications		:
//										Date			Developer				Notes
//										----			---------				-----
//									 2022-05-10		  A. Richardson		    Initial setup
//
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	@Override
	public void mousePressed(MouseEvent e)
	{
		int x = e.getX(), y = e.getY(); // Gets the the coords of the x and y of the mouse

		if (canClick) // If canClick is true do this code
		{
			if (x > 0 && x < WIDTH / 2 && y > 0 && y < HEIGHT / 2) // If our mouse is in the top left flashed becomes 1
			{
				flashed = 1; // Flashed becomes 1 so green is flashed
			}
			else if (x > WIDTH / 2 && x < WIDTH && y > 0 && y < HEIGHT / 2) // If our mouse is in the top right flashed becomes 2
			{
				flashed = 2; // Flashed becomes 2 so red is flashed	
			}
			else if (x > 0 && x < WIDTH / 2 && y > HEIGHT / 2 && y < HEIGHT) // If our mouse is in the bottom left then flashed becomes 3
			{
				flashed = 3; // Flashed becomes 3 so orange is flashed
			}
			else if (x > WIDTH / 2 && x < WIDTH && y > HEIGHT / 2 && y < HEIGHT) // If our mouse is in the bottom right then flashed becomes 4
			{
				flashed = 4; // Flashed becomes 4 so blue is flashed
			}

			if (flashed != pattern.get(clicks)) { 

				matched = false;	
			}

			clicks += 1; // Clicks increase every time the user clicks on one of the colors

			if(clicks == level + 2) // If clicks is equal to the level + 2 (The amount of colors flashed) then check if it matched with the CPU colors
			{

				if (matched) { // If matched the do code inside of if statement
					 
					audioCorrect(); // Play audioCorrect sound 
					points += level * 10; // Add points to the user
					JOptionPane.showMessageDialog(null, "Match you got + " + level * 10, " points", 3);
					
					

					levelUpgrade += 1; // levelUpgrade is increased

					if(levelUpgrade == 4) { //If levelUpgrade becomes 4 level is increased
						level += 1;
						JOptionPane.showMessageDialog(null, "LEVEL UP: your now on level " + level, "", 3); 
					}
					
				}

				else if (!matched) // If not matched 
				{
					points -= level * 20; //The user loses points
					audioIncorrect(); //Play audioIncorrect sound
					JOptionPane.showMessageDialog(null, "Not a match you lost - " + level * 20, " points", 0);

					if(points < 0) { // if points are less than 0 close the program the user lost 
						JOptionPane.showMessageDialog(null, "Your points are below zero you lose");
						System.exit(0);
					}

				}

				start(); // recall start to start over
				
			}
 
			renderer.repaint();	// repaint every time the user clicks	
		}

	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

	
}