import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class audio extends Variables {
	
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// Method				:	void audioCorrect()
//
// Method parameters	:	No method parameters
//
// Method return		:	void
//
// Synopsis				:   This method lets us play a sound at certain point in our game
//									
//
// Modifications		:
//									Date			Developer				Notes
//									----			---------				-----
//								 2022-05-10		  A. Richardson		    Initial setup
//
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

	protected void audioCorrect(){

		{
			String dingLocation = "Audio/ding.wav";

			try {
				File dingFile = new File(dingLocation);

				AudioInputStream dingAudioFile = AudioSystem.getAudioInputStream(dingFile);

				Clip dingSound = AudioSystem.getClip();

				dingSound.open(dingAudioFile);
				dingSound.start();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Problem playing sound");
			}

		}


	}
	
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// Method				:	void audioIncorrect()
//
// Method parameters	:	No method parameters
//
// Method return		:	void
//
// Synopsis				:   This method lets us play a sound at certain point in our game
//										
//
// Modifications		:
//										Date			Developer				Notes
//										----			---------				-----
//									 2022-05-10		  A. Richardson		    Initial setup
//
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

	protected void audioIncorrect(){

		{
			String incorrectLocation = "Audio/Incorrect.wav";

			try {
				File incorrectFile = new File(incorrectLocation);

				AudioInputStream incorrectAudioFile = AudioSystem.getAudioInputStream(incorrectFile);

				Clip incorrectSound = AudioSystem.getClip();

				incorrectSound.open(incorrectAudioFile);
				incorrectSound.start();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Problem playing sound");
			}

		}


	}

}
