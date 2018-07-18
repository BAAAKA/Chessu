import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;



public class Logic {

	field[] fields=new field[64];
	
	public BufferedImage getCorrectFieldImage(int i, boolean startBlack){
		System.out.println("return getCorrectFieldImage");
		fields[i]=new field(null, null, i);
		String PathToBlack=fields[0].getPathToBlack();
		String PathToWhite=fields[0].getPathToWhite();

		BufferedImage imageF;
		if(startBlack){
			if(i % 2 == 0){	
				imageF = getBufImage(PathToBlack);
				fields[i]=new field("black", null, i);
			}
			else{			
				imageF = getBufImage(PathToWhite);
				fields[i]=new field("white", null, i);
			}
		} 
		else{
			if(i % 2 == 0){	
				imageF = getBufImage(PathToWhite);
				fields[i]=new field("white", null, i);
			}
			else{			
				imageF = getBufImage(PathToBlack);
				fields[i]=new field("black", null, i);
			}
		}
		return imageF;
	}
	
	public BufferedImage getBufImage(String Path){
		BufferedImage imageF=null;
		try {
			imageF = ImageIO.read(new File(Path));
			return imageF;
		} catch (IOException e) {
			System.out.println("getBufImage");
			e.printStackTrace();
		}
		System.out.println("Error in getBufImage, no Image found! Path: " + Path);
		return imageF;
	}
	public void setFigure(int i, String figure){
		System.out.println("logic.setFigure Setting Figure " + figure+ " on " + i);
		fields[i].setFigure(figure);
	}
	public String getFigure(int i){
		String figure = fields[i].getFigure();
		return figure;
	}
	public field getField(int i){
		field temp= fields[i];
		return temp;
	}
	public String getFieldInfoPos(int i){
		String figure=fields[i].getFigurePath();
		return figure;
	}
	
	
	///TestMoveLegal
	public boolean testMoveLegal(field theField, field figureTo){
		System.out.println("Testmovelegals theField " + theField.getFigure());
		System.out.println("Testmovelegals figureTo " + figureTo.getFigure());
		if(!figureSameTeam(theField.getFigure(), figureTo.getFigure())){
			return false;
		}
		if(!figureMove(theField, figureTo)){
			return false;
		}
		return true;
	}
	private boolean figureMove(field fieldFrom, field fieldTo){
		String figure=fieldFrom.getFigure();
		String NoColorFigure=figure.substring(2);
		if(figure.equals("b_Pawn")){
			if(fieldFrom.getAranmbr()==fieldTo.getAranmbr()-8){
				return true;
			}else{return false;}
		}else if(figure.equals("w_Pawn")){
			if(fieldFrom.getAranmbr()==fieldTo.getAranmbr()+8){
				return true;
			}else{return false;}
		}else if(NoColorFigure.equals("Rook")){
			ArrayList<Integer> correctnumbers=new ArrayList<Integer>();
			correctnumbers.addAll(Arrays.asList(-8,-16,-24,-32,-40,-48,-56,8,16,24,32,40,48,56));
			if(correctnumbers.contains(fieldFrom.getAranmbr()-fieldTo.getAranmbr())){ //Vertikale test
				return true;
			}else{return false;}
			//For the horizontal test:
			//Test if any number betwen start and end position is....  8,16 etc (umber of ArrayliSt correctnumbers)
		}else if(NoColorFigure.equals("Knight")){
			
		}else if(NoColorFigure.equals("Bishop")){
			
		}else if(NoColorFigure.equals("Queen")){
			
		}else if(NoColorFigure.equals("King")){
			
		}
		System.out.println("Error,Loic figureMove figure not found!");
		return true;
	}
	private boolean figureSameTeam(String figureFrom, String figureTo){
		if(figureTo==null){
			return true;
		}
		else {
			if(figureFrom.substring(0, 1).equals(figureTo.substring(0, 1))){
				return false;
			}
			else{
				return true;
			}
		}
	}
}
