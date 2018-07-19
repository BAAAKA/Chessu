import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class test {

    public static void main(String[] args) {
    	int position=15;
    	position++;
    	int row=0;
		for(int i=8; i>0; i--){
			if((position+i)%8==0){
				if(row==0){
					row=8;
					System.out.println("row: "+ row);
					break;
				}
				System.out.println("row: "+ row);
				break;
			}
			row++;
		}
		System.out.println("Error, posToX row not found!");
    }
    //7->8
    //8->1
    //15->8

}