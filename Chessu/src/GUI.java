
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class GUI extends JFrame implements MouseListener{
	
	private Logic l=new Logic();

	private JPanel Board=new JPanel();
	private JPanel mainFrame=new JPanel();
	private JPanel[] panelArray=new JPanel[64];
	private JPanel[] panelOnTopArray=new JPanel[64];
	private JLabel[] labelArray=new JLabel[64];
	private JLabel[] labelOnTopArray=new JLabel[64];
    private JLayeredPane[] lpane=new JLayeredPane[64];
    
    private boolean startBlackSquare=true;
    
    private field selectedField;

	public GUI(){

		Board.setLayout(new GridLayout(8,8));
		mainFrame.setLayout(new BorderLayout());
		
		add(mainFrame, BorderLayout.CENTER);
		mainFrame.add(Board, BorderLayout.CENTER);
		
		setBordFields();
		l.setDefaultPositions();
		updateBoard();
		
		setLocation(400, 100);
		setTitle("Chesseru");  
		setSize(880,880);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public void setBordFields(){
		for(int i=0; i<labelArray.length; i++){
			//initialize 
			labelArray[i]=new JLabel();
			labelOnTopArray[i]=new JLabel();
			panelArray[i]=new JPanel();
			panelOnTopArray[i]=new JPanel();
			lpane[i]=new JLayeredPane();
			
			//Adding to the Panel
			panelOnTopArray[i].add(labelOnTopArray[i]);
			panelArray[i].add(labelArray[i]);
			panelArray[i].setBackground(Color.WHITE);

			//Setting Bounds
			panelOnTopArray[i].setBounds(0, 0, 110, 110);
			panelArray[i].setBounds(0, 0, 110, 110);

			panelOnTopArray[i].setOpaque(false);
			
			//Adding to Main JLayeredPane
	        lpane[i].add(panelArray[i], new Integer(0), 0);
	        lpane[i].add(panelOnTopArray[i], new Integer(1), 0);
			Board.add(lpane[i]);
			
			panelOnTopArray[i].addMouseListener(this);
			
			//Changing for Chess Quares
			if(i % 8 == 0){
				if(startBlackSquare){
					startBlackSquare=false;}
				else{startBlackSquare=true;}
			}
			//Putting the Chess Squares into the Frame
			labelArray[i].setIcon(new ImageIcon(l.getCorrectFieldImage(i, startBlackSquare)));
			
		}
	}
	public void updateBoard(){
		for(int i=0; i<labelArray.length; i++){
			String figure=l.getFieldInfoPos(i);
			if(figure=="nothing"){
				labelOnTopArray[i].setIcon(null);
			}
			else{
				labelOnTopArray[i].setIcon(new ImageIcon(l.getBufImage(figure)));
			}
		}
	}
	


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JPanel temp=(JPanel)arg0.getSource();
		for(int i=0; i<panelOnTopArray.length; i++){
			if(temp==panelOnTopArray[i]){
				System.out.println("Click on field nr: " + i);
				System.out.println("X: " + l.posToX(i) + "  Y:" + l.posToY(i));
				if(selectedField==null){
					if(l.getField(i).getFigure()!=null){
						System.out.println("Selecting field...");
						selectedField=l.getField(i);
					}
				}
				else if(selectedField.getFigure()!=null){
						if(l.testMoveLegal(selectedField, l.getField(i))){
							System.out.println("Setting Figure...");
							l.createFigure(i, selectedField.getFigure());
							selectedField.setFigure(null);
							updateBoard();
							selectedField=null;
						}else{
							selectedField=null;
							System.out.println("Move illegal!");
						}
				}
			}

		}


	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
