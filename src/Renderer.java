

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Renderer extends JPanel
{
	@Override
	protected void paintComponent(Graphics draw) // Renders the game twice so ticks will not be skipped                           
	{
		super.paintComponent(draw);
		
		if(Simon.simon != null)
		{
			Simon.simon.paint((Graphics2D) draw);
		}
		
	}
	
	
}
