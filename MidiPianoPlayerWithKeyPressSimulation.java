import javax.sound.midi.*;
import java.awt.*;
//import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;

public class MidiPianoPlayerWithKeyPressSimulation {

	private static final Map<String, Integer> WHITE_KEYS_MAP = new HashMap<>();
	//private static final Map<String, Integer> BLACK_KEYS_MAP = new HashMap<>();
	
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
			/*
			"KeyEvent.VK_A", "KeyEvent.VK_B", "KeyEvent.VK_C", "KeyEvent.VK_D", "KeyEvent.VK_E", "KeyEvent.VK_F", "KeyEvent.VK_G",
			"KeyEvent.VK_H", "KeyEvent.VK_I", "KeyEvent.VK_J", "KeyEvent.VK_K", "KeyEvent.VK_L", "KeyEvent.VK_M", "KeyEvent.VK_N",
			"KeyEvent.VK_O", "KeyEvent.VK_P", "KeyEvent.VK_Q", "KeyEvent.VK_R", "KeyEvent.VK_S", "KeyEvent.VK_T", "KeyEvent.VK_U",
			"KeyEvent.VK_V", "KeyEvent.VK_W", "KeyEvent.VK_X", "KeyEvent.VK_Y", "KeyEvent.VK_Z"
			*/
			
			
 			"KeyEvent.VK_Z", "KeyEvent.VK_X", "KeyEvent.VK_C", "KeyEvent.VK_V", "KeyEvent.VK_B", "KeyEvent.VK_N", "KeyEvent.VK_M", 
			"KeyEvent.VK_A", "KeyEvent.VK_S", "KeyEvent.VK_D", "KeyEvent.VK_F", "KeyEvent.VK_G", "KeyEvent.VK_H", "KeyEvent.VK_J", 
			"KeyEvent.VK_Q", "KeyEvent.VK_W", "KeyEvent.VK_E", "KeyEvent.VK_R", "KeyEvent.VK_T", "KeyEvent.VK_Y", "KeyEvent.VK_U"
			/*"KeyEvent.VK_1", "KeyEvent.VK_2", "KeyEvent.VK_3", "KeyEvent.VK_4", "KeyEvent.VK_5", "KeyEvent.VK_6", "KeyEvent.VK_7",	 
			"KeyEvent.VK_8", "KeyEvent.VK_9", "KeyEvent.VK_0", "KeyEvent.VK_MINUS", "KeyEvent.VK_EQUALS", "KeyEvent.VK_OPEN_BRACKET", "KeyEvent.VK_CLOSE_BRACKET"*/
			
			
			/*
			"KeyEvent.VK_Q", "KeyEvent.VK_W", "KeyEvent.VK_E", "KeyEvent.VK_R", "KeyEvent.VK_T", 
			"KeyEvent.VK_A", "KeyEvent.VK_S", "KeyEvent.VK_D", "KeyEvent.VK_F", "KeyEvent.VK_G",
			"KeyEvent.VK_Z", "KeyEvent.VK_X", "KeyEvent.VK_C", "KeyEvent.VK_V", "KeyEvent.VK_B"
			*/
			
			//"KeyEvent.VK_Z", "KeyEvent.VK_X" , "KeyEvent.VK_C", "KeyEvent.VK_V", "KeyEvent.VK_B", "KeyEvent.VK_N", "KeyEvent.VK_M", "KeyEvent.Q", "KeyEvent.W", "KeyEvent.VK_E", "KeyEvent.VK_R", "KeyEvent.VK_T", "KeyEvent.VK_Y", "KeyEvent.VK_U", "KeyEvent.VK_I", "KeyEvent.VK_O", "KeyEvent.VK_P", "KeyEvent.VK_OPEN_BRACKET", "KeyEvent.VK_CLOSE_BRACKET"

			
			//"KeyEvent.VK_1", "KeyEvent.VK_2", "KeyEvent.VK_3", "KeyEvent.VK_4", "KeyEvent.VK_5", "KeyEvent.VK_6", "KeyEvent.VK_7", "KeyEvent.VK_8", "KeyEvent.VK_9", "KeyEvent.VK_0", "KeyEvent.VK_Q", "KeyEvent.VK_W", "KeyEvent.VK_E", "KeyEvent.VK_R", "KeyEvent.VK_T", "KeyEvent.VK_Y", "KeyEvent.VK_U", "KeyEvent.VK_I", "KeyEvent.VK_O", "KeyEvent.VK_P", "KeyEvent.VK_A", "KeyEvent.VK_S", "KeyEvent.VK_D", "KeyEvent.VK_F", "KeyEvent.VK_G", "KeyEvent.VK_H", "KeyEvent.VK_J", "KeyEvent.VK_K", "KeyEvent.VK_L", "KeyEvent.VK_Z", "KeyEvent.VK_X", "KeyEvent.VK_C", "KeyEvent.VK_V", "KeyEvent.VK_B", "KeyEvent.VK_N", "KeyEvent.VK_M"

			/*
				//Kalimba
			"KeyEvent.VK_B", "KeyEvent.VK_V", "KeyEvent.VK_N", 
		    "KeyEvent.VK_C", "KeyEvent.VK_M", "KeyEvent.VK_X", 
		    "KeyEvent.VK_COMMA", "KeyEvent.VK_F", "KeyEvent.VK_H", 
		    "KeyEvent.VK_D", "KeyEvent.VK_J", "KeyEvent.VK_S", 
		    "KeyEvent.VK_K", "KeyEvent.VK_A", "KeyEvent.VK_U", 
		    "KeyEvent.VK_R", "KeyEvent.VK_I"
		    */
		    
	};

	private static void minimizeProgram() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
	}

	public static void main(String[] args) {
		/*
		 * String midiFilePath =
		 * "E:\\Among us\\Để tôi ôm em bằng giai điệu này - Có hẹn với thanh xuân.mid";
		 * Phố đã lên đèn.mid Grand_Escape-Weathering_With_You-Tenki_no_Ko.mid
		 * id_072019.mid 60282_you-dian-tian.mid Anh thanh niên.mid
		 * Love_Story_Taylors_Version.mid your smile.mid Phố đã lên đèn.mid
		 * NOTHING_GONNA_CHANGE_MY_LOVE_FOR_YOU.mid Yêu đơn phương là gì.mid
		 * 今はいいんだよ_–_MIMI.mid For Ya - 蒋小呢.mid Công_Chúa_Bong_Bóng.mid Hạ còn vương
		 * nắng.mid 白月光與朱砂痣_bach nguyet quang va not chu sa.mid Kẹo Bông Gòn.mid Ngày
		 * Tết quê em.mid Nothin on me.mid Tháng_Tư_Là_Lời_Nói_Dối_Của_Em.mid
		 * fiona_fung_proud_of_you.mid
		 * What_Makes_You_Beautiful_-_One_Direction_for_solo_piano.mid
		 * Kawaikute_Gomen.mid Em yêu trường em.mid 我愿意平凡的陪在你身旁 - Em nguyện làm một
		 * người bình thường ở bên cạnh anh.mid
		 * Sekai_Wa_Koi_Ni_Ochiteiru_-_Ao_Haru_Ride_OP.mid Yume wo Kanaete.mid Rồi Em Sẽ
		 * Gặp Một Chàng Trai Khác.mid When_Can_I_See_You_Again_-_Owl_City.mid
		 * way_back_home.mid 回到夏天.mid Nơinàycóanh.mid
		 * Emberfire_「燼火」_-_HOYO-MiX_from_&quot;The_Song_Burning_in_the_Embers&quot;_Genshin_Impact.mid
		 */

		// String midiFilePath =
		// "C:\\Users\\Nghia\\Downloads\\An_Enigmatic_Encounter.mid";
		//
		//yẽnfnsfhg
		
		//String midiFilePath = "C:\\Users\\Nghia\\Downloads\\Kawaikute_Gomen___feat._CV-_HoneyWorks.mid";
		//String midiFilePath = "C:\\Users\\Nghia\\Downloads\\Ăn sáng nha.mid";
		//String midiFilePath = "E:\\MidiFile\\4 MÙA THƯƠNG EM .mid";
		String midiFilePath = "E:\\MidiFile\\Tết đong đầy_1.mid";

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
							// Mute all channels except percussion (Channel 10 is typically percussion)
							/*
							 * // 21 D# || 22 23 || 24 C || 25 F# || 26 F || 27 E || 28 Nothin on me || 29 G
							 * -36
							 * 
							 * -21 C = 0, 7, 14, 21, ... (for C2, C3, C4, etc.) D = 2, 9, 16, 23, ... (for
							 * D2, D3, D4, etc.) E = 4, 11, 18, 25, ... (for E2, E3, E4, etc.) F = 5, 12,
							 * 19, 26, ... (for F2, F3, F4, etc.) G = 7, 14, 21, 28, ... (for G2, G3, G4,
							 * etc.) A = 9, 16, 23, 30, ... (for A2, A3, A4, etc.) B = 11, 18, 25, 32, ...
							 * (for B2, B3, B4, etc.) // -24
							 */
							//Lemon - 19
							// 15 10 3 //casfhgsadgf
							// Reine-Uchiha
							int key = sm.getData1() - 16;
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
		            //nvbbcc
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