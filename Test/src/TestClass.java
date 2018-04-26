import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class TestClass implements KeyListener {
	public TestClass() {
		frame.addKeyListener(this);
	}
	public PointerInfo p = MouseInfo.getPointerInfo();
	public static JFrame frame = new JFrame("MainFrame");
	public static  java.util.List<JButton> buttonList = new ArrayList<JButton>();
	public static int frameWidth = 500;
	public static int frameHeight = frameWidth + 120;
	public void keyPressed(KeyEvent e) {

	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'a') {
			JButton butt = new JButton();
			Point loc = p.getLocation();
			butt.setLocation(loc);
			butt.setSize(new Dimension(50,50));
			buttonList.add(butt);
			frame.add(butt);
			frame.repaint();
			System.out.println("Button created at " + butt.location());
		}
	}
	public static void createFile(String fileName){
		try {
		File f = new File("E:\\" + fileName + ".txt");
		if (f.exists()) {
			System.out.println("file Already Exits in " + f.getPath());
		}else 
		{
			FileWriter fileWriter = new FileWriter(f, true);
			fileWriter.close();
		}
		} catch (IOException ex) {
			System.out.println(ex);
		}
		finally {
			
		}
	}
	public static void writeToFile(String fileName, String text){
		try {
		File f = new File("E:\\"+ fileName + ".txt");
		FileWriter fileWriter = new FileWriter(f, true);
		fileWriter.write(text + "\r\n");
		fileWriter.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
	public static void main(String[] args){
		TestClass t = new TestClass();
		System.out.println("hi");
		createFile("Test");
		writeToFile("Test", "TestText");
		frame.addMouseListener(new MouseListener() {
		    public void mouseClicked(MouseEvent e) {
				JButton butt = new JButton();
				butt.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Clicked");
						
					}
				});
				Point loc = e.getLocationOnScreen();
				butt.setLocation(loc.x - 15, loc.y - 50);;
				butt.setSize(new Dimension(50,50));
				writeToFile("swag", "butt Location = " + butt.getLocation());
				frame.add(butt);
				frame.repaint();
				System.out.println("Button created at " + butt.location());
		    }
		    public void mouseEntered(MouseEvent e) {
		    	
		    }
		    public void mouseExited(MouseEvent e) {
		    	
		    }
		    public void mousePressed(MouseEvent e) {
	
		    }
		    public void mouseReleased(MouseEvent e) {
	
		    }
		});
		frame.setSize(frameWidth, frameHeight);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
