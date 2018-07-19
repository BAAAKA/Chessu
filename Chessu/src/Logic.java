import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;



public class Logic {

	field[] fields=new field[64];
	String turnColor="White";
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
	public int posToY(int position){
		for(int i=1; i<64; i++){
			if(position>(63-(8*i))){
				return i;
			}
		}
		System.out.println("Error, posToY row not found!");
		return 0;
	}
	public int posToX(int position){
    	position++;
    	int row=0;
		for(int i=8; i>0; i--){
			if((position+i)%8==0){
				if(row==0){
					row=8;
					return row;
				}
				return row;
			}
			row++;
		}
		System.out.println("Error, posToX row not found!");
		return 0;
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
//		if(!correctTurnColor(theField)){ //Temporary disable
//			return false;
//		}
		
		
		
		endOfTurn();
		return true;
	}
	private boolean correctTurnColor(field theField){
		if(theField.getFigureColor().equals("b")&&turnColor.equals("Black")){
			return true;
		}
		else if(theField.getFigureColor().equals("w")&&turnColor.equals("White")){
			return true;
		}else{
			System.out.println("Wrong Turn! Turn: " + turnColor);
			return false;
		}
	}
	private boolean figureMove(field fieldFrom, field fieldTo){
		int startX=posToX(fieldFrom.aranmbr);
		int endX=posToX(fieldTo.aranmbr);
		int startY=posToY(fieldFrom.aranmbr);
		int endY=posToY(fieldTo.aranmbr);
		String figure=fieldFrom.getFigure();
		String NoColorFigure=figure.substring(2);
		if(figure.equals("b_Pawn")){
			if(fieldFrom.getAranmbr()==fieldTo.getAranmbr()-8){
				if(fieldTo.getFigure()==null){
					return true;
				}else{return false;}
			}else if(fieldFrom.getAranmbr()==fieldTo.getAranmbr()-7 || fieldFrom.getAranmbr()==fieldTo.getAranmbr()-9){
				if(fieldTo.getFigure()!=null){
					return true;
				}
			}else if(fieldFrom.getAranmbr()==fieldTo.getAranmbr()-16 && posToY(fieldFrom.getAranmbr())==7){
				if(fields[fieldTo.getAranmbr()-8].getFigure()==null){
					return true;
				}
			}
		return false;
		}else if(figure.equals("w_Pawn")){
			if(fieldFrom.getAranmbr()==fieldTo.getAranmbr()+8){
				if(fieldTo.getFigure()==null){
					return true;
				}else{return false;}
			}else if(fieldFrom.getAranmbr()==fieldTo.getAranmbr()+7 || fieldFrom.getAranmbr()==fieldTo.getAranmbr()+9){
				if(fieldTo.getFigure()!=null){
					return true;
				}
			}			
			else if(fieldFrom.getAranmbr()==fieldTo.getAranmbr()+16 && posToY(fieldFrom.getAranmbr())==2){
				if(fields[fieldTo.getAranmbr()+8].getFigure()==null){
					return true;
				}
			}
			return false;
		}else if(NoColorFigure.equals("Rook")){
			if(startX==endX){
				return true;
			}
			else if(startY==endY){
				return true;
			}else{return false;}

		}else if(NoColorFigure.equals("Knight")){

			if(startX==endX+2 || startX==endX-2){
				System.out.println("StartX2");
				if(startY==endY+1||startY==endY-1){
					return true;
				}else{return false;}
			}
			else if(startY==endY+2 || startY==endY-2){
				if(startX==endX+1||startX==endX-1){
					return true;
				}else{return false;}
			}
			return false;
		}else if(NoColorFigure.equals("Bishop")){
			if(startX-endX==startY-endY){
				return true;
			}else if(startX+startY==endX+endY){
				return true;
			}else{return false;}
		}else if(NoColorFigure.equals("Queen")){
			//Bishop
			if(startX-endX==startY-endY){
				return true;
			}else if(startX+startY==endX+endY){
				return true;
			}
			//Rook
			if(startX==endX){
				return true;
			}
			else if(startY==endY){
				return true;
			}else{return false;}

		}else if(NoColorFigure.equals("King")){
			if(startX==endX+1 || startX==endX || startX==endX-1){
				if(startY==endY+1 || startY==endY || startY==endY-1){
					return true;
				}
			}
			return false;
		}
		System.out.println("Error,Logic figureMove figure not found!!!");
		System.out.println("########################################");
		System.out.println("########################################");

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
	public void endOfTurn(){
		if(turnColor=="White"){
			turnColor="Black";
		}else{
			turnColor="White";
		}
	}
}
