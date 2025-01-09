import javax.sound.midi.*;
import java.awt.*;
//import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;

public class MidiPianoPlayerWithKeyPressSimulation {

	private static final Map<String, Integer> WHITE_KEYS_MAP = new HashMap<>();
	//private static final Map<String, Integer> BLACK_KEYS_MAP = new HashMap<>(); Add black keys if nesscessary 
	
	static {	
		WHITE_KEYS_MAP.put("KeyEvent.VK_A", KeyEvent.VK_A);
		WHITE_KEYS_MAP.put("KeyEvent.VK_B", KeyEvent.VK_B);
		WHITE_KEYS_MAP.put("KeyEvent.VK_C", KeyEvent.VK_C);
		WHITE_KEYS_MAP.put("KeyEvent.VK_D", KeyEvent.VK_D);
		WHITE_KEYS_MAP.put("KeyEvent.VK_E", KeyEvent.VK_E);
		WHITE_KEYS_MAP.put("KeyEvent.VK_F", KeyEvent.VK_F);
		WHITE_KEYS_MAP.put("KeyEvent.VK_G", KeyEvent.VK_G);
		WHITE_KEYS_MAP.put("KeyEvent.VK_H", KeyEvent.VK_H);
		WHITE_KEYS_MAP.put("KeyEvent.VK_I", KeyEvent.VK_I);
		WHITE_KEYS_MAP.put("KeyEvent.VK_J", KeyEvent.VK_J);
		WHITE_KEYS_MAP.put("KeyEvent.VK_K", KeyEvent.VK_K);
		WHITE_KEYS_MAP.put("KeyEvent.VK_L", KeyEvent.VK_L);
		WHITE_KEYS_MAP.put("KeyEvent.VK_M", KeyEvent.VK_M);
		WHITE_KEYS_MAP.put("KeyEvent.VK_N", KeyEvent.VK_N);
		WHITE_KEYS_MAP.put("KeyEvent.VK_O", KeyEvent.VK_O);
		WHITE_KEYS_MAP.put("KeyEvent.VK_P", KeyEvent.VK_P);
		WHITE_KEYS_MAP.put("KeyEvent.VK_Q", KeyEvent.VK_Q);
		WHITE_KEYS_MAP.put("KeyEvent.VK_R", KeyEvent.VK_R);
		WHITE_KEYS_MAP.put("KeyEvent.VK_S", KeyEvent.VK_S);
		WHITE_KEYS_MAP.put("KeyEvent.VK_T", KeyEvent.VK_T);
		WHITE_KEYS_MAP.put("KeyEvent.VK_U", KeyEvent.VK_U);
		WHITE_KEYS_MAP.put("KeyEvent.VK_V", KeyEvent.VK_V);
		WHITE_KEYS_MAP.put("KeyEvent.VK_W", KeyEvent.VK_W);
		WHITE_KEYS_MAP.put("KeyEvent.VK_X", KeyEvent.VK_X);
		WHITE_KEYS_MAP.put("KeyEvent.VK_Y", KeyEvent.VK_Y);
		WHITE_KEYS_MAP.put("KeyEvent.VK_Z", KeyEvent.VK_Z);	
		WHITE_KEYS_MAP.put("KeyEvent.VK_1", KeyEvent.VK_1);
		WHITE_KEYS_MAP.put("KeyEvent.VK_2", KeyEvent.VK_2);
		WHITE_KEYS_MAP.put("KeyEvent.VK_3", KeyEvent.VK_3);
		WHITE_KEYS_MAP.put("KeyEvent.VK_4", KeyEvent.VK_4);
		WHITE_KEYS_MAP.put("KeyEvent.VK_5", KeyEvent.VK_5);
		WHITE_KEYS_MAP.put("KeyEvent.VK_6", KeyEvent.VK_6);
		WHITE_KEYS_MAP.put("KeyEvent.VK_7", KeyEvent.VK_7);
		WHITE_KEYS_MAP.put("KeyEvent.VK_8", KeyEvent.VK_8);
		WHITE_KEYS_MAP.put("KeyEvent.VK_9", KeyEvent.VK_9);
		WHITE_KEYS_MAP.put("KeyEvent.VK_0", KeyEvent.VK_0);
		WHITE_KEYS_MAP.put("KeyEvent.VK_MINUS", KeyEvent.VK_MINUS);
		WHITE_KEYS_MAP.put("KeyEvent.VK_EQUALS", KeyEvent.VK_EQUALS);
		WHITE_KEYS_MAP.put("KeyEvent.VK_VK_OPEN_BRACKET", KeyEvent.VK_OPEN_BRACKET);
		WHITE_KEYS_MAP.put("KeyEvent.VK_VK_CLOSE_BRACKET", KeyEvent.VK_CLOSE_BRACKET);
		WHITE_KEYS_MAP.put("KeyEvent.VK_COMMA", KeyEvent.VK_COMMA);
	}
	/*
	private static final String[] BLACK_KEYS_X_COORDINATES = {

			"KeyEvent.VK_A", "KeyEvent.VK_S", "KeyEvent.VK_F", "KeyEvent.VK_G", "KeyEvent.VK_J", "KeyEvent.VK_K", "KeyEvent.VK_L",
			"KeyEvent.VK_4", "KeyEvent.VK_5", "KeyEvent.VK_7", "KeyEvent.VK_8", "KeyEvent.VK_9"
	
	};
	*/
	private static final String[] WHITE_KEYS_X_COORDINATES = { 
 			"KeyEvent.VK_Z", "KeyEvent.VK_X", "KeyEvent.VK_C", "KeyEvent.VK_V", "KeyEvent.VK_B", "KeyEvent.VK_N", "KeyEvent.VK_M", 
			"KeyEvent.VK_A", "KeyEvent.VK_S", "KeyEvent.VK_D", "KeyEvent.VK_F", "KeyEvent.VK_G", "KeyEvent.VK_H", "KeyEvent.VK_J", 
			"KeyEvent.VK_Q", "KeyEvent.VK_W", "KeyEvent.VK_E", "KeyEvent.VK_R", "KeyEvent.VK_T", "KeyEvent.VK_Y", "KeyEvent.VK_U",
			"KeyEvent.VK_1", "KeyEvent.VK_2", "KeyEvent.VK_3", "KeyEvent.VK_4", "KeyEvent.VK_5", "KeyEvent.VK_6", "KeyEvent.VK_7",	 
			"KeyEvent.VK_8", "KeyEvent.VK_9", "KeyEvent.VK_0", "KeyEvent.VK_MINUS", "KeyEvent.VK_EQUALS", "KeyEvent.VK_OPEN_BRACKET", "KeyEvent.VK_CLOSE_BRACKET"			    
	};

	private static void minimizeProgram() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
	}

	public static void main(String[] args) {
		String midiFilePath = "....\\.mid";

		File midiFile = new File(midiFilePath);

		try {
			// Create a Robot instance
			Robot robot = new Robot();

			minimizeProgram();

			// Get a Sequencer and set the MIDI file
			Sequencer sequencer = MidiSystem.getSequencer(false); // Use false to avoid default sound
			sequencer.setSequence(MidiSystem.getSequence(midiFile));

			// Add a listener to handle MIDI events
			sequencer.addMetaEventListener(meta -> {
				// Process Meta messages if needed
			});

			// Add a Transmitter and Receiver to handle note events
			sequencer.getTransmitter().setReceiver(new Receiver() {
				@Override
				public void send(MidiMessage message, long timeStamp) {
					if (message instanceof ShortMessage) {
						ShortMessage sm = (ShortMessage) message;
						if (sm.getCommand() == ShortMessage.NOTE_ON && sm.getChannel() != 9) {
							// Mute all channels except percussion					
							int key = sm.getData1() - 12; // change this key suitable for each songsong
							int velocity = sm.getData2();

							if (velocity > 0) {
								playKey(robot, key);
							}
						}
					}
				}

				@Override
				public void close() {
					// Handle close
				}
			});

			// Start playing the MIDI file
			sequencer.open();
			sequencer.start();

			// Wait for playback to finish
			while (sequencer.isRunning()) {
				Thread.sleep(450);
			}

			// Close the sequencer
			sequencer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void playKey(Robot robot, int midiNote) {
		if (midiNote < 21 || midiNote > 108) {
			return; // Out of the range of keys we are considering
		}

		int keyIndex = midiNote - 36; // Adjust for the starting key C2

		if (keyIndex < 0 || keyIndex >= 96) {
			return; // Out of the 96-key range
		}

		if (isBlackKey(keyIndex)) {
		/*
			int blackKeyIndex = getBlackKeyIndex(keyIndex);
		    if (blackKeyIndex >= 0 && blackKeyIndex < BLACK_KEYS_X_COORDINATES.length) {
		        String keysToNote = WHITE_KEYS_X_COORDINATES[blackKeyIndex];
		        Integer keyCode = BLACK_KEYS_MAP.get(keysToNote);
		        try {
		            // Simulate key press
		            robot.keyPress(keyCode);
		            // Add a delay (e.g., 100 milliseconds) before releasing the key
		            Thread.sleep(100);  // Adjust the delay as needed
		            // Simulate key release
		            robot.keyRelease(keyCode);
		        } catch (InterruptedException e) {
		            e.printStackTrace();  // Handle the interruption exception
		        }
		    }
		*/
		} else {	
			int whiteKeyIndex = getWhiteKeyIndex(keyIndex);
		    if (whiteKeyIndex >= 0 && whiteKeyIndex < WHITE_KEYS_X_COORDINATES.length) {
		        String keysToNote = WHITE_KEYS_X_COORDINATES[whiteKeyIndex];
		        Integer keyCode = WHITE_KEYS_MAP.get(keysToNote);
		        try {
		            // Simulate key press
		            robot.keyPress(keyCode);        
		            // Add a delay (e.g., 100 milliseconds) before releasing the key
		            Thread.sleep(50);  // Adjust the delay as needed
		            // Simulate key release
		            robot.keyRelease(keyCode);
		        } catch (InterruptedException e) {
		            e.printStackTrace();  // Handle the interruption exception
		        }
		    }
		}
	}

	private static boolean isBlackKey(int keyIndex) {
		// Check if the key is black based on its position in the octave
		int[] blackKeyPositions = { 1, 3, 6, 8, 10 };
		int positionInOctave = keyIndex % 12;
		for (int blackPos : blackKeyPositions) {
			if (positionInOctave == blackPos) {
				return true;
			}
		}
		return false;
	}
/*
	private static int getBlackKeyIndex(int keyIndex) {
		// Calculate the black key index based on its position
		int[] blackKeyOffsets = { 0, 1, 3, 4, 5, 7, 8, 10, 11 };
		int octave = keyIndex / 12;
		int positionInOctave = keyIndex % 12;

		int offsetIndex = 0;
		for (int i = 0; i < blackKeyOffsets.length; i++) {
			if (blackKeyOffsets[i] == positionInOctave) {
				offsetIndex = i;
				break;
			}
		}

		return octave * 5 + offsetIndex;
	}
*/
	private static int getWhiteKeyIndex(int keyIndex) {
		// Calculate the white key index based on its position
		int[] whiteKeyOffsets = { 0, 2, 4, 5, 7, 9, 11 };
		int octave = keyIndex / 12;
		int positionInOctave = keyIndex % 12;

		int offsetIndex = 0;
		for (int i = 0; i < whiteKeyOffsets.length; i++) {
			if (whiteKeyOffsets[i] == positionInOctave) {
				offsetIndex = i;
				break;
			}
		}

		return octave * 7 + offsetIndex;
	}
}
