import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;
import java.awt.event.KeyAdapter;

public class MidiPianoPlayerWithMouseClickSimulation {
    // X coordinates for the white keys
	/*
	 private static final int[] WHITE_KEYS_X_COORDINATES = {
	        270, 290, 310, 330, 350, 370, 390, 410, 420, 440, 460, 475, 495, 515, 530, 550, 570, 590, 610, 620, 640, 660, 680, 700, 720, 740
	    };
	    
	    // Y coordinates for white and black keys
	    private static final int WHITE_KEY_Y = 420;
	*/
	/*
	private static final int[] WHITE_KEYS_X_COORDINATES = {
        55, 77, 99, 121, 143, 165, 187, 209, 231, 253, 275, 297,
        319, 341, 363, 385, 407, 429, 451, 473, 495, 517, 539, 561,
        583, 605, 627, 649, 671, 693, 715, 737, 759, 781, 803, 825,
        847, 869, 891, 913, 935, 957, 979, 1001, 1023, 1045, 1067,
        1089, 1111, 1133, 1155, 1177, 1199, 1221, 1243, 1265
    };

    // X coordinates for the black keys
    private static final int[] BLACK_KEYS_X_COORDINATES = {
        70, 90, 133, 155, 177, 225, 245, 288, 310, 332, 380, 400,
        442, 464, 486, 535, 555, 600, 622, 644, 690, 710, 750, 772,
        794, 842, 862, 905, 927, 949, 1000, 1020, 1060, 1082, 1104,
        1150, 1170, 1215, 1237, 1259
    };
    
    // Y coordinates for white and black keys
    private static final int WHITE_KEY_Y = 511;
    private static final int BLACK_KEY_Y = 480;
    */

	/*
	private static final int[] WHITE_KEYS_X_COORDINATES = {
        656, 606, 706, 556, 756, 506, 806, 456, 856, 406, 906, 356, 956, 306, 1006, 256, 1056
    };
	
	private static final int WHITE_KEY_Y = 500;
	*/
	/*
		private static final int[] WHITE_KEYS_X_COORDINATES = {
	        393, 483, 573, 663, 753, 843, 933,
	        393, 483, 573, 663, 753, 843, 933,
	        393, 483, 573, 663, 753, 843, 933
			328, 448, 568, 686, 806, 922, 1040,
			328, 448, 568, 686, 806, 922, 1040,
			328, 448, 568, 686, 806, 922, 1040
	    };
		
		private static final int[] WHITE_KEY_Y = { 
			660, 660, 660, 660, 660, 660, 660,
			570, 570, 570, 570, 570, 570, 570,
			480, 480, 480, 480, 480, 480, 480
		};
		
		private static final int[] WHITE_KEY_Y = { 
				680, 680, 680, 680, 680, 680, 680,
				580, 580, 580, 580, 580, 580, 580,
				480, 480, 480, 480, 480, 480, 480
			};
	*/
	
	/*
	private static final int[] WHITE_KEYS_X_COORDINATES = {
	    670, 603, 737, 536, 804, 469, 871, 402, 938, 335, 1005, 268, 1072, 201, 1139, 134, 1206
	};
		
	private static final int WHITE_KEY_Y = 150;
	*/
	
	//https://recursivearts.com/virtual-piano/	
	//35 25 126 30 138 35 650 500
	
	private static final int WHITE_KEY_COUNT = 35;
	private static final int BLACK_KEY_COUNT = 25;

	private static final int FIRST_WHITE_KEY_X = 66; // X position of the first white key
	private static final int WHITE_KEY_SPACING = 34; // Distance between white keys

	private static final int FIRST_BLACK_KEY_X = 82; // X position of the first black key
	private static final int BLACK_KEY_SPACING = 34; // Approximate spacing for black keys

	private static final int[] WHITE_KEYS_X_COORDINATES = new int[WHITE_KEY_COUNT];
	private static final int[] BLACK_KEYS_X_COORDINATES = new int[BLACK_KEY_COUNT];

	// Y coordinates for white and black keys
    private static final int WHITE_KEY_Y = 300;
    private static final int BLACK_KEY_Y = 200;
    
	/*
	private static final int WHITE_KEY_COUNT = 49;
	private static final int BLACK_KEY_COUNT = 35;

	private static final int FIRST_WHITE_KEY_X = 104; // X position of the first white key
	private static final int WHITE_KEY_SPACING = 24; // Distance between white keys

	private static final int FIRST_BLACK_KEY_X = 115; // X position of the first black key
	private static final int BLACK_KEY_SPACING = 25; // Approximate spacing for black keys

	private static final int[] WHITE_KEYS_X_COORDINATES = new int[WHITE_KEY_COUNT];
	private static final int[] BLACK_KEYS_X_COORDINATES = new int[BLACK_KEY_COUNT];

	// Y coordinates for white and black keys
    private static final int WHITE_KEY_Y = 460;
    private static final int BLACK_KEY_Y = 360;
    */
	
	 //https://virtualpiano.net/ 35 25 47 35 66 34 530 450
	 //https://openclassroom.edu.vn/virtualpiano/ 35 25 66 34 82 34 300 200 
	 //https://recursivearts.com/virtual-piano/	
    //https://multiplayerpiano.com/ 49 35 104 24 115 25 460 360
	//21 15 291 38 313 35 510 475  
	/*
	private static final int WHITE_KEY_COUNT = 17;
	private static final int BLACK_KEY_COUNT = 15;

	private static final int FIRST_WHITE_KEY_X = 255; // X position of the first white key
	private static final int WHITE_KEY_SPACING = 51; // Distance between white keys

	private static final int FIRST_BLACK_KEY_X = 125; // X position of the first black key
	private static final int BLACK_KEY_SPACING = 25; // Approximate spacing for black keys

	private static final int[] WHITE_KEYS_X_COORDINATES = new int[WHITE_KEY_COUNT];
	private static final int[] BLACK_KEYS_X_COORDINATES = new int[BLACK_KEY_COUNT];

	// Y coordinates for white and black keys
    private static final int WHITE_KEY_Y = 455;
    private static final int BLACK_KEY_Y = 200;
    */
	//42 30 59 29 75 29 510 470
	//14 10 268 37 286 37 530 450
	/*
	private static final int WHITE_KEY_COUNT = 14;
	private static final int BLACK_KEY_COUNT = 10;

	private static final int FIRST_WHITE_KEY_X = 295; // X position of the first white key
	private static final int WHITE_KEY_SPACING = 32; // Distance between white keys

	private static final int FIRST_BLACK_KEY_X = 311; // X position of the first black key
	private static final int BLACK_KEY_SPACING = 32; // Approximate spacing for black keys

	private static final int[] WHITE_KEYS_X_COORDINATES = new int[WHITE_KEY_COUNT];
	private static final int[] BLACK_KEYS_X_COORDINATES = new int[BLACK_KEY_COUNT];

	// Y coordinates for white and black keys
    private static final int WHITE_KEY_Y = 680;
    private static final int BLACK_KEY_Y = 650;
	*/
    
	static {
	    // Generate white key positions
	    for (int i = 0; i < WHITE_KEY_COUNT; i++) {
	        WHITE_KEYS_X_COORDINATES[i] = FIRST_WHITE_KEY_X + i * WHITE_KEY_SPACING;
	    }
	    
	    BLACK_KEYS_X_COORDINATES[0] = FIRST_BLACK_KEY_X;
	    
	    // Generate black key positions
	    for (int i = 1; i < BLACK_KEY_COUNT; i++) {
	                                                                                                                //BLACK_KEYS_X_COORDINATES[i] = FIRST_BLACK_KEY_X + (i / 5) * (BLACK_KEY_SPACING * 2) + (i % 5) * BLACK_KEY_SPACING;
	    	if ((i % 5 == 2) || (i % 5 == 0)) {
	    		BLACK_KEYS_X_COORDINATES[i] = BLACK_KEYS_X_COORDINATES[i - 1] + BLACK_KEY_SPACING * 2;
	    	} else {
	    		BLACK_KEYS_X_COORDINATES[i] = BLACK_KEYS_X_COORDINATES[i - 1] + BLACK_KEY_SPACING;
	    	}
	    }
	}
	
    private static void minimizeProgram() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
    }
    
    public static void setupFrameWithKeyListener() {
        // Create a JFrame (the main window)
        JFrame frame = new JFrame("KeyPress Close Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a KeyListener to the frame
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);  // Close the application
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        /*
         * String midiFilePath = "E:\\Among us\\Để tôi ôm em bằng giai điệu này - Có hẹn với thanh xuân.mid";
    	 * Phố đã lên đèn.mid Grand_Escape-Weathering_With_You-Tenki_no_Ko.mid id_072019.mid 60282_you-dian-tian.mid 
         * Anh thanh niên.mid Love_Story_Taylors_Version.mid your smile.mid Phố đã lên đèn.mid
    	 * NOTHING_GONNA_CHANGE_MY_LOVE_FOR_YOU.mid Yêu đơn phương là gì.mid 今はいいんだよ_–_MIMI.mid For Ya - 蒋小呢.mid 
    	 * Công_Chúa_Bong_Bóng.mid Hạ còn vương nắng.mid 白月光與朱砂痣_bach nguyet quang va not chu sa.mid
    	 * Kẹo Bông Gòn.mid Ngày Tết quê em.mid Nothin on me.mid Tháng_Tư_Là_Lời_Nói_Dối_Của_Em.mid
    	 * fiona_fung_proud_of_you.mid 
    	 * What_Makes_You_Beautiful_-_One_Direction_for_solo_piano.mid
    	 * Kawaikute_Gomen.mid Em yêu trường em.mid 我愿意平凡的陪在你身旁 - Em nguyện làm một người bình thường ở bên cạnh anh.mid
    	 * Sekai_Wa_Koi_Ni_Ochiteiru_-_Ao_Haru_Ride_OP.mid
    	 * Yume wo Kanaete.mid
    	 * Rồi Em Sẽ Gặp Một Chàng Trai Khác.mid
    	 * When_Can_I_See_You_Again_-_Owl_City.mid 
    	 * way_back_home.mid
    	 *   回到夏天.mid
    	 */

        //String midiFilePath = "C:\\Users\\Nghia\\Downloads\\An_Enigmatic_Encounter.mid";
    	String midiFilePath = "E:\\MidiFile\\Kawaikute_Gomen.mid";
    	
        File midiFile = new File(midiFilePath);

        try {
            // Create a Robot instance
            Robot robot = new Robot();
            
            minimizeProgram();
            setupFrameWithKeyListener();
            
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
                        	/*// 21 D# || 22 23 || 24 C || 25 F# || 26 F || 27 E || 28 Nothin on me || 29 G
                        	 *   -36
    	                                
    	                         -21    C = 0, 7, 14, 21, ... (for C2, C3, C4, etc.)
    									D = 2, 9, 16, 23, ... (for D2, D3, D4, etc.)
    									E = 4, 11, 18, 25, ... (for E2, E3, E4, etc.)
    									F = 5, 12, 19, 26, ... (for F2, F3, F4, etc.)
    									G = 7, 14, 21, 28, ... (for G2, G3, G4, etc.)
    									A = 9, 16, 23, 30, ... (for A2, A3, A4, etc.)
    									B = 11, 18, 25, 32, ... (for B2, B3, B4, etc.)
    									// -24
    									*/
                            int key = sm.getData1() + 14;
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
                Thread.sleep(200);
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
        	int blackKeyIndex = getBlackKeyIndex(keyIndex);           
            if (blackKeyIndex >= 0 && blackKeyIndex < BLACK_KEYS_X_COORDINATES.length) {
                int x = BLACK_KEYS_X_COORDINATES[blackKeyIndex];
                robot.mouseMove(x, BLACK_KEY_Y);
                // Simulate key press
                try {
                	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                	Thread.sleep(10);
                	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);  
                } catch (InterruptedException e) {
                	e.printStackTrace();
                }
            }
        } else {
            int whiteKeyIndex = getWhiteKeyIndex(keyIndex);
            if (whiteKeyIndex >= 0 && whiteKeyIndex < WHITE_KEYS_X_COORDINATES.length) {
                int x = WHITE_KEYS_X_COORDINATES[whiteKeyIndex];
                //int y = WHITE_KEY_Y[whiteKeyIndex];
                //String keysToNote = WHITE_KEYS_X_COORDINATES[whiteKeyIndex];
                
                //Integer keyCode = WHITE_KEYS_MAP.get(keysToNote);
            	robot.mouseMove(x, WHITE_KEY_Y);
                //robot.mouseMove(x, y);
                // Simulate key press
            	try {
	                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	                Thread.sleep(10);
	                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); 
            	} catch (InterruptedException e) {
		            e.printStackTrace();  // Handle the interruption exception
		        }
            }
        }
    }

    private static boolean isBlackKey(int keyIndex) {
        // Check if the key is black based on its position in the octave
        int[] blackKeyPositions = {1, 3, 6, 8, 10};
        int positionInOctave = keyIndex % 12;
        for (int blackPos : blackKeyPositions) {
            if (positionInOctave == blackPos) {
                return true;
            }
        }
        return false;
    }

    private static int getBlackKeyIndex(int keyIndex) {
        // Calculate the black key index based on its position
        int[] blackKeyOffsets = {0, 1, 3, 4, 5, 7, 8, 10, 11};
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

    private static int getWhiteKeyIndex(int keyIndex) {
        // Calculate the white key index based on its position
        int[] whiteKeyOffsets = {0, 2, 4, 5, 7, 9, 11};
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



/*import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class MidiPianoPlayer {
    private static final int[] WHITE_KEYS_X_COORDINATES = {
        55, 77, 99, 121, 143, 165, 187, 209, 231, 253, 275, 297,
        319, 341, 363, 385, 407, 429, 451, 473, 495, 517, 539, 561,
        583, 605, 627, 649, 671, 693, 715, 737, 759, 781, 803, 825,
        847, 869, 891, 913, 935, 957, 979, 1001, 1023, 1045, 1067, 
        1089, 1111, 1133, 1155, 1177, 1199, 1221, 1243, 1265
    };
    
    private static final int[] BLACK_KEYS_X_COORDINATES = {
        70, 90, 133, 155, 177, 225, 245, 288, 310, 332, 380, 400,
        442, 464, 486, 535, 555, 600, 622, 644, 690, 710, 750, 772,
        794, 842, 862, 905, 927, 949, 1000, 1020, 1060, 1082, 1104,
        1150, 1170, 1215, 1237, 1259
    };

    private static final int WHITE_KEY_Y = 530;
    private static final int BLACK_KEY_Y = 500;

    private static void minimizeProgram() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
    }
    
    public static void main(String[] args) {
        String midiFilePath = "E:\\Among us\\Nơinàycóanh.mid";
        File midiFile = new File(midiFilePath);

        try {
            // Create a Robot instance
            Robot robot = new Robot();

            // Get a Sequencer and set the MIDI file
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.setSequence(MidiSystem.getSequence(midiFile));

            // Add a listener to handle MIDI events
            sequencer.addMetaEventListener(meta -> {
                // Process Meta messages if needed
            });
            
            minimizeProgram();
            
            // Add a Transmitter and Receiver to handle note events
            sequencer.getTransmitter().setReceiver(new Receiver() {
                @Override
                public void send(MidiMessage message, long timeStamp) {
                    if (message instanceof ShortMessage) {
                        ShortMessage sm = (ShortMessage) message;
                        if (sm.getCommand() == ShortMessage.NOTE_ON) {
                            int key = sm.getData1();
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
                Thread.sleep(100);
            }

            // Close the sequencer
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void playKey(Robot robot, int midiNote) {
        int keyIndex = midiNote - 21; // MIDI note 21 is A0

        if (keyIndex < 0 || keyIndex >= 88) {
            return; // Out of the 88-key range
        }

        if (isBlackKey(keyIndex)) {
            int blackKeyIndex = getBlackKeyIndex(keyIndex);
            if (blackKeyIndex >= 0 && blackKeyIndex < BLACK_KEYS_X_COORDINATES.length) {
                int x = BLACK_KEYS_X_COORDINATES[blackKeyIndex];
                robot.mouseMove(x, BLACK_KEY_Y);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            }
        } else {
            int whiteKeyIndex = getWhiteKeyIndex(keyIndex);
            if (whiteKeyIndex >= 0 && whiteKeyIndex < WHITE_KEYS_X_COORDINATES.length) {
                int x = WHITE_KEYS_X_COORDINATES[whiteKeyIndex];
                robot.mouseMove(x, WHITE_KEY_Y);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            }
        }
    }

    private static boolean isBlackKey(int keyIndex) {
        // Check if the key is black based on its position in the octave
        int[] blackKeyPositions = {1, 3, 6, 8, 10};
        int positionInOctave = keyIndex % 12;
        for (int blackPos : blackKeyPositions) {
            if (positionInOctave == blackPos) {
                return true;
            }
        }
        return false;
    }

    private static int getBlackKeyIndex(int keyIndex) {
        // Calculate the black key index based on its position
        int[] blackKeyOffsets = {0, 1, 3, 4, 5, 7, 8, 10, 11};
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

    private static int getWhiteKeyIndex(int keyIndex) {
        // Calculate the white key index based on its position
        int[] whiteKeyOffsets = {0, 2, 4, 5, 7, 9, 11};
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
*/
/*import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class MidiPianoPlayer {

    // Coordinate of white and black keys on the screen
    private static final int[] WHITE_KEY_X_COORDS = {55, 77, 99, 121, 143, 165, 187, 209, 231, 253, 275, 297, 319, 341, 363, 385, 407, 429, 451, 473, 495, 517, 539, 561, 583, 605, 627, 649, 671, 693, 715, 737, 759, 781, 803, 825, 847, 869, 891, 913, 935, 957, 979, 1001, 1023, 1045, 1067, 1089, 1111, 1133, 1155, 1177, 1199, 1221, 1243, 1265};
    private static final int[] BLACK_KEY_X_COORDS = {70, 90, 133, 155, 177, 225, 245, 288, 310, 332, 380, 400, 442, 464, 486, 535, 555, 600, 622, 644, 690, 710, 750, 772, 794, 842, 862, 905, 927, 949, 1000, 1020, 1060, 1082, 1104, 1150, 1170, 1215, 1237, 1259};
    private static final int WHITE_KEY_Y_COORD = 530;
    private static final int BLACK_KEY_Y_COORD = 500;

    private static void minimizeProgram() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
    }
    
    public static void main(String[] args) {
        try {
            String midiFilePath = "E:\\Among us\\Nơinàycóanh.mid";
            File midiFile = new File(midiFilePath);
            Sequence sequence = MidiSystem.getSequence(midiFile);
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.setSequence(sequence);
            sequencer.open();
            sequencer.start();
            minimizeProgram();
            // Create a Robot instance for simulating key presses
            Robot robot = new Robot();

            // Get the tracks and loop through them
            Track[] tracks = sequence.getTracks();
            for (Track track : tracks) {
                for (int i = 0; i < track.size(); i++) {
                    MidiEvent event = track.get(i);
                    MidiMessage message = event.getMessage();
                    
                    if (message instanceof ShortMessage) {
                        ShortMessage shortMessage = (ShortMessage) message;
                        if (shortMessage.getCommand() == ShortMessage.NOTE_ON) {
                            int note = shortMessage.getData1();
                            int velocity = shortMessage.getData2();

                            // Determine which key to press
                            if (note >= 21 && note <= 108) {
                                int keyIndex = note - 21;
                                if (isBlackKey(keyIndex)) {
                                    int blackKeyIndex = getBlackKeyIndex(keyIndex);
                                    if (blackKeyIndex >= 0) {
                                        robot.mouseMove(BLACK_KEY_X_COORDS[blackKeyIndex], BLACK_KEY_Y_COORD);
                                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                                    }
                                } else {
                                    int whiteKeyIndex = getWhiteKeyIndex(keyIndex);
                                    if (whiteKeyIndex >= 0) {
                                        robot.mouseMove(WHITE_KEY_X_COORDS[whiteKeyIndex], WHITE_KEY_Y_COORD);
                                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                                    }
                                }
                            }
                        }
                    }
                    Thread.sleep(10); // Adjust sleep time based on MIDI tempo
                }
            }
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isBlackKey(int keyIndex) {
        // Implement your logic to determine if the key is black
        // Placeholder implementation
        return false;
    }

    private static int getBlackKeyIndex(int keyIndex) {
        // Implement your logic to get the index of the black key
        // Placeholder implementation
        return -1;
    }

    private static int getWhiteKeyIndex(int keyIndex) {
        // Implement your logic to get the index of the white key
        // Placeholder implementation
        return -1;
    }
}


/*import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.HashMap;
import java.util.Map;

public class MidiPianoPlayer {
    
    // Coordinates of white and black keys
    private static final int[] WHITE_KEY_X_COORDS = {
        55, 77, 99, 121, 143, 165, 187, 209, 231, 253, 275, 297, 319, 341,
        363, 385, 407, 429, 451, 473, 495, 517, 539, 561, 583, 605, 627, 649,
        671, 693, 715, 737, 759, 781, 803, 825, 847, 869, 891, 913, 935, 957,
        979, 1001, 1023, 1045, 1067, 1089, 1111, 1133, 1155, 1177, 1199, 1221,
        1243, 1265
    };
    
    private static final int[] BLACK_KEY_X_COORDS = {
        70, 90, 133, 155, 177, 225, 245, 288, 310, 332, 380, 400, 442, 464,
        486, 535, 555, 600, 622, 644, 690, 710, 750, 772, 794, 842, 862, 905,
        927, 949, 1000, 1020, 1060, 1082, 1104, 1150, 1170, 1215, 1237, 1259
    };

    // Note to x-coordinate mapping (simplified example)
    private static final Map<Integer, Integer> WHITE_KEY_MAP = new HashMap<>();
    private static final Map<Integer, Integer> BLACK_KEY_MAP = new HashMap<>();

    static {
        // Mapping MIDI note numbers to white keys
        for (int i = 0; i < WHITE_KEY_X_COORDS.length; i++) {
            WHITE_KEY_MAP.put(60 + i, WHITE_KEY_X_COORDS[i]);  // Example mapping
        }
        
        // Mapping MIDI note numbers to black keys (example mapping)
        for (int i = 0; i < BLACK_KEY_X_COORDS.length; i++) {
            BLACK_KEY_MAP.put(61 + i, BLACK_KEY_X_COORDS[i]);  // Example mapping
        }
    }

    public static void main(String[] args) {
        try {
            // Load the MIDI file
            Sequence sequence = MidiSystem.getSequence(MidiPlayer.class.getResource("E:\\Among us\\Nơinàycóanh.mid"));
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.setSequence(sequence);
            
            // Open the sequencer
            sequencer.open();
            
            // Set up a listener to handle MIDI events
            sequencer.addMetaEventListener(meta -> {
                if (meta.getType() == 47) {
                    System.out.println("End of track reached.");
                }
            });

            // Start playback
            sequencer.start();

            // Create a robot instance for simulating key presses
            Robot robot = new Robot();

            // Process each MIDI event
            Track[] tracks = sequence.getTracks();
            for (Track track : tracks) {
                for (int i = 0; i < track.size(); i++) {
                    MidiEvent event = track.get(i);
                    ShortMessage message = (ShortMessage) event.getMessage();
                    
                    if (message.getCommand() == ShortMessage.NOTE_ON) {
                        int note = message.getData1();
                        int velocity = message.getData2();

                        if (velocity > 0) {
                            pressKey(robot, note);
                        } else {
                            releaseKey(robot, note);
                        }
                    }
                    
                    // Delay processing to match the timing of the MIDI file
                    Thread.sleep(event.getTick() / 10);
                }
            }
            
            // Clean up
            sequencer.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void pressKey(Robot robot, int note) {
        // Simulate key press
        int x = WHITE_KEY_MAP.getOrDefault(note, -1);
        if (x != -1) {
            robot.mouseMove(x, 530);  // Assuming all white keys have the same y-coordinate
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        }
        
        x = BLACK_KEY_MAP.getOrDefault(note, -1);
        if (x != -1) {
            robot.mouseMove(x, 500);  // Assuming all black keys have the same y-coordinate
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    private static void releaseKey(Robot robot, int note) {
        // Simulate key release
        int x = WHITE_KEY_MAP.getOrDefault(note, -1);
        if (x != -1) {
            robot.mouseMove(x, 530);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        
        x = BLACK_KEY_MAP.getOrDefault(note, -1);
        if (x != -1) {
            robot.mouseMove(x, 500);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }
}
*/
/*import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MidiPianoPlayer {

    // Coordinates for white keys
    private static final int[] WHITE_KEYS_X = {
        55, 77, 99, 121, 143, 165, 187, 209, 231, 253, 275, 297,
        319, 341, 363, 385, 407, 429, 451, 473, 495, 517, 539, 561,
        583, 605, 627, 649, 671, 693, 715, 737, 759, 781, 803, 825,
        847, 869, 891, 913, 935, 957, 979, 1001, 1023, 1045, 1067,
        1089, 1111, 1133, 1155, 1177, 1199, 1221, 1243, 1265
    };

    // Coordinates for black keys
    private static final int[] BLACK_KEYS_X = {
        70, 90, 133, 155, 177, 225, 245, 288, 310, 332, 380, 400,
        442, 464, 486, 535, 555, 600, 622, 644, 690, 710, 750, 772,
        794, 842, 862, 905, 927, 949, 1000, 1020, 1060, 1082, 1104,
        1150, 1170, 1215, 1237, 1259
    };

    private static final int WHITE_KEY_Y = 530;
    private static final int BLACK_KEY_Y = 500;

    // MIDI note to key mapping
    private static final Map<Integer, Integer> NOTE_TO_X = new HashMap<>();

    static {
        // Assuming standard 88-key piano (A0 to C8)
        // White keys
        int startNote = 21; // A0
        for (int i = 0; i < WHITE_KEYS_X.length; i++) {
            NOTE_TO_X.put(startNote + i, WHITE_KEYS_X[i]);
        }
        
        // Black keys (typically placed in-between white keys)
        int[] blackKeyNotes = {22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40, 42, 43, 45, 46, 48, 49, 51, 52, 54, 55, 57, 58, 60, 61, 63, 64, 66, 67, 69, 70, 72, 73, 75, 76, 78, 79, 81};
        for (int i = 0; i < blackKeyNotes.length; i++) {
            if (i < BLACK_KEYS_X.length) {
                NOTE_TO_X.put(blackKeyNotes[i], BLACK_KEYS_X[i]);
            }
        }
    }

    public static void main(String[] args) {
        try {
            File midiFile = new File("E:\\Nghia\\Nơinàycóanh.mid");
            Sequence sequence = MidiSystem.getSequence(midiFile);
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);

            Robot robot = new Robot();

            // Start playing MIDI sequence
            sequencer.start();

            Track[] tracks = sequence.getTracks();
            long previousTick = 0;
            long ticksPerQuarterNote = sequence.getResolution();

            for (Track track : tracks) {
                for (int i = 0; i < track.size(); i++) {
                    MidiEvent event = track.get(i);
                    MidiMessage message = event.getMessage();
                    long currentTick = event.getTick();
                    long tickDifference = currentTick - previousTick;

                    // Calculate delay based on ticks and tempo
                    long delay = (long) ((tickDifference * 60000.0) / (sequencer.getTempoInBPM() * ticksPerQuarterNote));
                    Thread.sleep(delay);

                    if (message instanceof ShortMessage) {
                        ShortMessage sm = (ShortMessage) message;
                        int command = sm.getCommand();
                        int note = sm.getData1();
                        if (command == ShortMessage.NOTE_ON) {
                            pressKey(note, robot);
                        } else if (command == ShortMessage.NOTE_OFF) {
                        	releaseKey(note, robot);
                        }
                    }

                    previousTick = currentTick;
                }
            }

            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void pressKey(int note, Robot robot) {
        Integer x = NOTE_TO_X.get(note);
        if (x != null) {
            int keyCode = getKeyCode(note);
            if (keyCode != -1) {
                robot.keyPress(keyCode);
            }
        }
    }

    private static void releaseKey(int note, Robot robot) {
        Integer x = NOTE_TO_X.get(note);
        if (x != null) {
            int keyCode = getKeyCode(note);
            if (keyCode != -1) {
                robot.keyRelease(keyCode);
            }
        }
    }

    private static int getKeyCode(int note) {
        // Mapping MIDI note number to key codes (simplified example)
        // Modify this mapping based on the actual key codes your virtual piano expects
        switch (note) {
        case 21: return KeyEvent.VK_Q; // A0
        case 22: return KeyEvent.VK_2; // A#0/Bb0
        case 23: return KeyEvent.VK_W; // B0
        case 24: return KeyEvent.VK_S; // C1
        case 25: return KeyEvent.VK_3; // C#1/Db1
        case 26: return KeyEvent.VK_E; // D1
        case 27: return KeyEvent.VK_4; // D#1/Eb1
        case 28: return KeyEvent.VK_R; // E1
        case 29: return KeyEvent.VK_T; // F1
        case 30: return KeyEvent.VK_5; // F#1/Gb1
        case 31: return KeyEvent.VK_Y; // G1
        case 32: return KeyEvent.VK_6; // G#1/Ab1
        case 33: return KeyEvent.VK_U; // A1
        case 34: return KeyEvent.VK_7; // A#1/Bb1
        case 35: return KeyEvent.VK_I; // B1
        case 36: return KeyEvent.VK_O; // C2
        case 37: return KeyEvent.VK_8; // C#2/Db2
        case 38: return KeyEvent.VK_P; // D2
        case 39: return KeyEvent.VK_LEFT_PARENTHESIS; // D#2/Eb2
        case 40: return KeyEvent.VK_LEFT_BRACKET; // E2
        case 41: return KeyEvent.VK_RIGHT_PARENTHESIS; // F2
        case 42: return KeyEvent.VK_9; // F#2/Gb2
        case 43: return KeyEvent.VK_MINUS; // G2
        case 44: return KeyEvent.VK_0; // G#2/Ab2
        case 45: return KeyEvent.VK_EQUALS; // A2
        case 46: return KeyEvent.VK_BACK_SLASH; // A#2/Bb2
        case 47: return KeyEvent.VK_BACK_QUOTE; // B2
        case 48: return KeyEvent.VK_F1; // C3
        case 49: return KeyEvent.VK_F2; // C#3/Db3
        case 50: return KeyEvent.VK_F3; // D3
        case 51: return KeyEvent.VK_F4; // D#3/Eb3
        case 52: return KeyEvent.VK_F5; // E3
        case 53: return KeyEvent.VK_F6; // F3
        case 54: return KeyEvent.VK_F7; // F#3/Gb3
        case 55: return KeyEvent.VK_F8; // G3
        case 56: return KeyEvent.VK_F9; // G#3/Ab3
        case 57: return KeyEvent.VK_F10; // A3
        case 58: return KeyEvent.VK_F11; // A#3/Bb3
        case 59: return KeyEvent.VK_F12; // B3
        case 60: return KeyEvent.VK_F13; // C4
        case 61: return KeyEvent.VK_F14; // C#4/Db4
        case 62: return KeyEvent.VK_F15; // D4
        case 63: return KeyEvent.VK_F16; // D#4/Eb4
        case 64: return KeyEvent.VK_F17; // E4
        case 65: return KeyEvent.VK_F18; // F4
        case 66: return KeyEvent.VK_F19; // F#4/Gb4
        case 67: return KeyEvent.VK_F20; // G4
        case 68: return KeyEvent.VK_F21; // G#4/Ab4
        case 69: return KeyEvent.VK_F22; // A4
        case 70: return KeyEvent.VK_F23; // A#4/Bb4
        case 71: return KeyEvent.VK_F24; // B4
        case 72: return KeyEvent.VK_F25; // C5
        case 73: return KeyEvent.VK_F26; // C#5/Db5
        case 74: return KeyEvent.VK_F27; // D5
        case 75: return KeyEvent.VK_F28; // D#5/Eb5
        case 76: return KeyEvent.VK_F29; // E5
        case 77: return KeyEvent.VK_F30; // F5
        case 78: return KeyEvent.VK_F31; // F#5/Gb5
        case 79: return KeyEvent.VK_F32; // G5
        case 80: return KeyEvent.VK_F33; // G#5/Ab5
        case 81: return KeyEvent.VK_F34; // A5
        case 82: return KeyEvent.VK_F35; // A#5/Bb5
        case 83: return KeyEvent.VK_F36; // B5
        case 84: return KeyEvent.VK_F37; // C6
        case 85: return KeyEvent.VK_F38; // C#6/Db6
        case 86: return KeyEvent.VK_F39; // D6
        case 87: return KeyEvent.VK_F40; // D#6/Eb6
        case 88: return KeyEvent.VK_F41; // E6
        case 89: return KeyEvent.VK_F42; // F6
            default: return -1; // Invalid key code
        }
    }

    private static boolean isBlackKey(int note) {
        // Check if note is black key (C#, D#, F#, G#, A# in each octave)
        return note % 12 == 1 || note % 12 == 3 || note % 12 == 6 || note % 12 == 8 || note % 12 == 10;
    }
}
*/



/*import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.awt.AWTException;

public class MidiPianoPlayer {
    private static final int WHITE_KEY_HEIGHT = 530;
    private static final int BLACK_KEY_HEIGHT = 500;
    
    private static final Map<Integer, Integer> whiteKeyCoordinates = new HashMap<>();
    private static final Map<Integer, Integer> blackKeyCoordinates = new HashMap<>();

    static {
        // Initialize white key coordinates (vertical coordinate is constant)
    	int[] whiteKeyHorizontalCoords = {55, 77, 99, 121, 143, 165, 187, 209, 231, 253, 275, 297, 319, 341, 363, 385, 407, 429, 451, 473, 495, 517, 539, 561, 583, 605, 627, 649, 671, 693, 715, 737, 759, 781, 803, 825, 847, 869, 891, 913, 935, 957, 979, 1001, 1023, 1045, 1067, 1089, 1111, 1133, 1155, 1177, 1199, 1221, 1243, 1265};
        int startNote = 21; // A0
        for (int i = 0; i < whiteKeyHorizontalCoords.length; i++) {
            whiteKeyCoordinates.put(startNote + i, whiteKeyHorizontalCoords[i]);
        }
        
        // Initialize black key coordinates (vertical coordinate is constant)
        int[] blackKeyHorizontalCoords = {70, 90, 133, 155, 177, 225, 245, 288, 310, 332, 380, 400, 442, 464, 486, 535, 555, 600, 622, 644, 690, 710, 750, 772, 794, 842, 862, 905, 927, 949, 1000, 1020, 1060, 1082, 1104, 1150, 1170, 1215, 1237, 1259};
        startNote = 22; // A#0
        for (int i = 0; i < blackKeyHorizontalCoords.length; i++) {
            blackKeyCoordinates.put(startNote + i, blackKeyHorizontalCoords[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        // Hard-coded MIDI file path
        String midiFilePath = "E:\\Among us\\Nơinàycóanh.mid"; // Replace this with your actual file path

        File midiFile = new File(midiFilePath);
        if (!midiFile.exists()) {
            System.out.println("Error: The file " + midiFilePath + " does not exist.");
            return;
        }

        minimizeProgram();
        Sequence sequence = MidiSystem.getSequence(midiFile);
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.setSequence(sequence);
        sequencer.open();
        
        // Setup Robot for simulating key presses
        Robot robot = new Robot();

        // Play MIDI sequence
        Track[] tracks = sequence.getTracks();
        for (Track track : tracks) {
            for (int i = 0; i < track.size(); i++) {
                MidiEvent event = track.get(i);
                MidiMessage message = event.getMessage();

                if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    int command = sm.getCommand();
                    int note = sm.getData1();
                    int velocity = sm.getData2();

                    // Only process note on and note off events
                    if (command == ShortMessage.NOTE_ON && velocity > 0) {
                        simulateKeyPress(note, robot, true);
                    } else if (command == ShortMessage.NOTE_OFF || (command == ShortMessage.NOTE_ON && velocity == 0)) {
                        simulateKeyPress(note, robot, false);
                    }
                }

                // Delay for the next event
                long delay = event.getTick() * (sequencer.getMicrosecondLength() / sequence.getTickLength());
                Thread.sleep(delay / 1000);
            }
        }
        sequencer.close();
    }

    private static void simulateKeyPress(int note, Robot robot, boolean press) {
        Integer x = whiteKeyCoordinates.get(note);
        int y = WHITE_KEY_HEIGHT; // Default to white key height

        if (x == null) {
            x = blackKeyCoordinates.get(note);
            y = BLACK_KEY_HEIGHT; // Set to black key height if note is a black key
        }

        if (x != null) {
            try {
                robot.mouseMove(x, y);
                if (press) {
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                } else {
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error: Note not found in coordinate mappings - note: " + note);
        }
    }
    
    private static void minimizeProgram() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
    }
}*/
/*import javax.sound.midi.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MidiToPiano {

    // Coordinates for white and black keys
    private static final int[] WHITE_KEYS_X = {55, 77, 99, 121, 143, 165, 187, 209, 231, 253, 275, 297, 319, 341, 363, 385, 407, 429, 451, 473, 495, 517, 539, 561, 583, 605, 627, 649, 671, 693, 715, 737, 759, 781, 803, 825, 847, 869, 891, 913, 935, 957, 979, 1001, 1023, 1045, 1067, 1089, 1111, 1133, 1155, 1177, 1199, 1221, 1243, 1265};
    private static final int WHITE_KEY_Y = 530;
    
    private static final int[] BLACK_KEYS_X = {70, 90, 133, 155, 177, 225, 245, 288, 310, 332, 380, 400, 442, 464, 486, 535, 555, 600, 622, 644, 690, 710, 750, 772, 794, 842, 862, 905, 927, 949, 1000, 1020, 1060, 1082, 1104, 1150, 1170, 1215, 1237, 1259};
    private static final int BLACK_KEY_Y = 500;
    
    private static final Map<Integer, Integer> KEY_COORDINATES = new HashMap<>();
    
    static {
        for (int i = 0; i < WHITE_KEYS_X.length; i++) {
            KEY_COORDINATES.put(21 + i * 2, WHITE_KEYS_X[i]); // white keys
        }
        for (int i = 0; i < BLACK_KEYS_X.length; i++) {
            KEY_COORDINATES.put(22 + i * 2, BLACK_KEYS_X[i]); // black keys
        }
    }
    
    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException, IOException, AWTException {
        if (args.length != 1) {
            System.out.println("Usage: java MidiToPiano <path_to_midi_file>");
            return;
        }
        
        String midiFilePath = args[0];
        File midiFile = new File(midiFilePath);
        
        // Setup MIDI sequencer
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequencer.setSequence(MidiSystem.getSequence(midiFile));
        
        // Setup Robot for simulating key presses
        Robot robot = new Robot();
        
        // Start playing MIDI sequence
        sequencer.start();
        
        // Get track from sequence
        Track[] tracks = sequencer.getSequence().getTracks();
        for (Track track : tracks) {
            for (int i = 0; i < track.size(); i++) {
                MidiEvent event = track.get(i);
                ShortMessage message = (ShortMessage) event.getMessage();
                
                if (message.getCommand() == ShortMessage.NOTE_ON) {
                    int note = message.getData1();
                    Integer xCoord = KEY_COORDINATES.get(note);
                    if (xCoord != null) {
                        // Calculate y coordinate based on whether the key is black or white
                        int yCoord = (note % 12 == 1 || note % 12 == 3 || note % 12 == 6 || note % 12 == 8 || note % 12 == 10) ? BLACK_KEY_Y : WHITE_KEY_Y;
                        robot.mouseMove(xCoord, yCoord);
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        Thread.sleep(50); // Delay to simulate key press duration
                    }
                }
            }
        }
        
        sequencer.stop();
        sequencer.close();
    }
}
*/