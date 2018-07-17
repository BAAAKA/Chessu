
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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class GUI extends JFrame{
	
	private Logic l=new Logic();

	private JPanel Board=new JPanel();
	private JPanel mainFrame=new JPanel();
	private JPanel[] panelArray=new JPanel[64];
	private JPanel[] panelOnTopArray=new JPanel[64];
	private JLabel[] labelArray=new JLabel[64];
	private JLabel[] labelOnTopArray=new JLabel[64];
    private JLayeredPane lpane = new JLayeredPane();
    
    private boolean startBlackSquare=true;

	public GUI(){

		Board.setLayout(new GridLayout(8,8));
		mainFrame.setLayout(new BorderLayout());
		
		add(mainFrame, BorderLayout.CENTER);
		mainFrame.add(Board, BorderLayout.CENTER);
		
		setBordFields();
		setDefaultPositions();
		
		setLocation(400, 100);
		setTitle("Chesseru");  
		setSize(880,880);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public void setBordFields(){
		for(int i=0; i<labelArray.length; i++){
			labelArray[i]=new JLabel();
			labelOnTopArray[i]=new JLabel();
			panelArray[i]=new JPanel();
			panelOnTopArray[i]=new JPanel();
			
			panelOnTopArray[i].add(labelOnTopArray[i]);
			panelArray[i].add(labelArray[i]);
			Board.add(panelArray[i]);
			
			if(i % 8 == 0){
				if(startBlackSquare){
					startBlackSquare=false;}
				else{startBlackSquare=true;}
			}
			
//				if(i == 8 || i ==24 || i ==40 || i ==56 ){
//					BufferedImage imageF = getBufImage(PathToWhite);
//					labelArray[i].setIcon(new ImageIcon(imageF));}
//				else if(i == 16 || i == 32 || i == 48 || i == 64){
//					BufferedImage imageF = getBufImage(PathToBlack);
//					labelArray[i].setIcon(new ImageIcon(imageF));}
			labelArray[i].setIcon(new ImageIcon(l.getCorrectFieldImage(i, startBlackSquare)));
			
		}
	}
	
	public void setDefaultPositions(){
		System.out.println("Setting Default Positons");
		String b_Pawn="src/images/b_Pawn.png";
		String b_Knight="src/images/b_Knight.png";
		String b_Bishop="src/images/b_Bishop.png";
		String b_Rook="src/images/b_Rook.png";
		String b_Queen="src/images/b_Queen.png";
		String b_King="src/images/b_King.png";
		
		labelOnTopArray[0].setIcon(new ImageIcon(l.getBufImage(b_Rook)));
		
		
		
	}

	
}
