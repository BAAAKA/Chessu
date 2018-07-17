import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUI extends JFrame{
	
	String PathToBlack="src/images/black.jpg";
	
	JPanel Board=new JPanel();
	JPanel mainFrame=new JPanel();
	JPanel[] panelArray=new JPanel[64];
	JLabel[] labelArray=new JLabel[64];
	
	public GUI(){

		Board.setLayout(new GridLayout(8,8));
		mainFrame.setLayout(new BorderLayout());
		
		add(mainFrame, BorderLayout.CENTER);
		mainFrame.add(Board, BorderLayout.CENTER);
		
		setBordFields();

		
		setLocation(400, 100);
		setTitle("Chesseru");  
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public void setBordFields(){
		for(int i=0; i<labelArray.length-1; i++){
			labelArray[i]=new JLabel();
			panelArray[i]=new JPanel();
			panelArray[i].add(labelArray[i]);
			Board.add(panelArray[i]);
	
			try {
				if(i % 2 == 0){
				BufferedImage imageF = ImageIO.read(new File("src/images/black.jpg"));
				labelArray[i].setIcon(new ImageIcon(imageF));}
				else{
				BufferedImage imageF = ImageIO.read(new File("src/images/white.jpg"));
				labelArray[i].setIcon(new ImageIcon(imageF));}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
