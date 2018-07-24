import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;



public class Logic {

	Cfigure b_Rook1=new Cfigure("b", "Rook");
	Cfigure b_Rook2=new Cfigure("b", "Rook");
	Cfigure b_Knight1=new Cfigure("b", "Knight");
	Cfigure b_Knight2=new Cfigure("b", "Knight");
	Cfigure b_Bishop1=new Cfigure("b", "Bishop");
	Cfigure b_Bishop2=new Cfigure("b", "Bishop");
	Cfigure b_Queen=new Cfigure("b", "Queen");
	Cfigure b_King=new Cfigure("b", "King");
	
	Cfigure b_Pawn1=new Cfigure("b", "Pawn");
	Cfigure b_Pawn2=new Cfigure("b", "Pawn");
	Cfigure b_Pawn3=new Cfigure("b", "Pawn");
	Cfigure b_Pawn4=new Cfigure("b", "Pawn");
	Cfigure b_Pawn5=new Cfigure("b", "Pawn");
	Cfigure b_Pawn6=new Cfigure("b", "Pawn");
	Cfigure b_Pawn7=new Cfigure("b", "Pawn");
	Cfigure b_Pawn8=new Cfigure("b", "Pawn");
	
	//white
	Cfigure w_Rook1=new Cfigure("w", "Rook");
	Cfigure w_Rook2=new Cfigure("w", "Rook");
	Cfigure w_Knight1=new Cfigure("w", "Knight");
	Cfigure w_Knight2=new Cfigure("w", "Knight");
	Cfigure w_Bishop1=new Cfigure("w", "Bishop");
	Cfigure w_Bishop2=new Cfigure("w", "Bishop");
	Cfigure w_Queen=new Cfigure("w", "Queen");
	Cfigure w_King=new Cfigure("w", "King");
	
	Cfigure w_Pawn1=new Cfigure("w", "Pawn");
	Cfigure w_Pawn2=new Cfigure("w", "Pawn");
	Cfigure w_Pawn3=new Cfigure("w", "Pawn");
	Cfigure w_Pawn4=new Cfigure("w", "Pawn");
	Cfigure w_Pawn5=new Cfigure("w", "Pawn");
	Cfigure w_Pawn6=new Cfigure("w", "Pawn");
	Cfigure w_Pawn7=new Cfigure("w", "Pawn");
	Cfigure w_Pawn8=new Cfigure("w", "Pawn");
	
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
	public void createFigure(int i, Cfigure figure){
		System.out.println("logic.createFigure Setting Figure " + figure+ " on " + i);
		fields[i].setFigure(figure);
	}
	public Cfigure getFigure(int i){
		Cfigure figure = fields[i].getFigure();
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
	public int xyToPos(int x, int y){
		int var1=x-1;
		int var2=y-1*8;
		int pos=x+y;
		System.out.println(pos);
		return pos;
	}
	
	public void setDefaultPositions(){



		System.out.println("Setting Default Positons");
		
		//Black Side
		createFigure(0, b_Rook1);
		createFigure(1, b_Knight1);
		createFigure(2, b_Bishop1);
		createFigure(3, b_Queen);
		createFigure(4, b_King);
		createFigure(5, b_Bishop2);
		createFigure(6, b_Knight2);
		createFigure(7, b_Rook2);
		createFigure(8, b_Pawn1);
		createFigure(9, b_Pawn2);
		createFigure(10, b_Pawn3);
		createFigure(11, b_Pawn4);
		createFigure(12, b_Pawn5);
		createFigure(13, b_Pawn6);
		createFigure(14, b_Pawn7);
		createFigure(15, b_Pawn8);

				//White Side
		createFigure(63, w_Rook1);
		createFigure(62, w_Knight1);
		createFigure(61, w_Bishop1);
		createFigure(60, w_King);
		createFigure(59, w_Queen);
		createFigure(58, w_Bishop2);
		createFigure(57, w_Knight2);
		createFigure(56, w_Rook2);
		createFigure(55, w_Pawn1);
		createFigure(54, w_Pawn2);
		createFigure(53, w_Pawn3);
		createFigure(52, w_Pawn4);
		createFigure(51, w_Pawn5);
		createFigure(50, w_Pawn6);
		createFigure(49, w_Pawn7);
		createFigure(48, w_Pawn8);
		
	}
	
	///TestMoveLegal
	public boolean testMoveLegal(field theField, field figureTo){
		System.out.println("Testmovelegals theField " + theField.getFigure());
		System.out.println("Testmovelegals figureTo " + figureTo.getFigure());
		if(!figureMove(theField, figureTo)){ 
			return false;
		}
		if(figureTo.getFigure()!=null){
			if(!figureSameTeam(theField.getFigure().getTeamColor(), figureTo.getFigure().getTeamColor())){
				return false;
			}
		}
//		if(!correctTurnColor(theField)){ //Temporary disable
//			return false;
//		}
		
		
		
		endOfTurn(theField.getFigure());
		return true;
	}
	private boolean correctTurnColor(field theField){
		if(theField.getFigure().getTeamColor().equals("b")&&turnColor.equals("Black")){
			return true;
		}
		else if(theField.getFigure().getTeamColor().equals("w")&&turnColor.equals("White")){
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
		String NoColorFigure=fieldFrom.getFigure().getFigureKind();
		if(NoColorFigure.equals("Pawn") && fieldFrom.getFigure().getTeamColor().equals("b")){
			if(fieldFrom.getAranmbr()==fieldTo.getAranmbr()-8){
				if(fieldTo.getFigure()==null){
					return true;
				}else{return false;}
			}else if(fieldFrom.getAranmbr()==fieldTo.getAranmbr()-7 || fieldFrom.getAranmbr()==fieldTo.getAranmbr()-9){
				if(fieldTo.getFigure()!=null){
					return true;
				}
			}else if(fieldFrom.getAranmbr()==fieldTo.getAranmbr()-16 && posToY(fieldFrom.getAranmbr())==7){
				if(fields[fieldTo.getAranmbr()-8].getFigure()==null&&fields[fieldTo.getAranmbr()+16].getFigure()==null){
					return true;
				}
			}
		return false;
		}else if(NoColorFigure.equals("Pawn") && fieldFrom.getFigure().getTeamColor().equals("w")){
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
			if(startX==endX){ // |
				if(startY>endY){
					for(int i=1;i<9;i++){
						if((i*8+fieldFrom.aranmbr)==fieldTo.aranmbr){
							break;
						}
						if(fields[fieldFrom.aranmbr+(i*8)].getFigure()!=null){
							return false;
						}		
					}
					return true;
				}	
				if(startY<endY){
					for(int i=1;i<9;i++){
						int minus=i*8;
						if((fieldFrom.aranmbr-minus)==fieldTo.aranmbr){ //All squares between clear?..
							break;
						}
						if(fields[fieldFrom.aranmbr-minus].getFigure()!=null){ //Is square X clean?s
							return false;
						}		
					}
					return true;
				}		
			}
			else if(startY==endY){ // ----------
				if(startX<endX){
					for(int i=1;i<9;i++){
						if(fieldFrom.aranmbr+i==fieldTo.aranmbr){ //All squares between clear?..
							break;
						}
						if(fields[fieldFrom.aranmbr+i].getFigure()!=null){
							System.out.println(i);
							return false;
						}	
					}
				}
				if(startX>endX){
					for(int i=1;i<9;i++){
						if(fieldFrom.aranmbr-i==fieldTo.aranmbr){ //All squares between clear?..
							break;
						}
						if(fields[fieldFrom.aranmbr-i].getFigure()!=null){
							System.out.println(i);
							return false;
						}	
					}
				}
				return true;
			}
		return false;
		
		}else if(NoColorFigure.equals("Knight")){

			if(startX==endX+2 || startX==endX-2){
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
			if(startX-endX==startY-endY){ // weg: /
				if(startY<endY){
					for(int i=1;i<9;i++){
						int number=i*7;
						if(fieldFrom.aranmbr-number==fieldTo.aranmbr){ //All squares between clear?..
							System.out.println("Break!");
							break;
						}
						System.out.println(fieldTo.aranmbr);
						System.out.println(fieldFrom.aranmbr + " with number:" + number);
						if(fields[fieldFrom.aranmbr-number].getFigure()!=null){
							System.out.println("something found" + number);
							return false;
						}	
					}
				}
				if(startY>endY){
					for(int i=1;i<9;i++){
						int number=i*7;
						if(fieldFrom.aranmbr+number==fieldTo.aranmbr){ //All squares between clear?..
							System.out.println("Break!");
							break;
						}
						System.out.println(fieldTo.aranmbr);
						System.out.println(fieldFrom.aranmbr + " with number:" + number);
						if(fields[fieldFrom.aranmbr+number].getFigure()!=null){
							System.out.println("something found" + number);
							return false;
						}	
					}
				}
				return true;
				
			}else if(startX+startY==endX+endY){ // weg: \
				if(startX>endX){
					for(int i=1;i<9;i++){
						int number=i*9;
						if(fieldFrom.aranmbr-number==fieldTo.aranmbr){ //All squares between clear?..
							System.out.println("Break!");
							break;
						}
						System.out.println(fieldTo.aranmbr);
						System.out.println(fieldFrom.aranmbr + " with number:" + number);
						if(fields[fieldFrom.aranmbr-number].getFigure()!=null){
							System.out.println("something found" + number);
							return false;
						}	
					}
				}
				if(startX<endX){
					for(int i=1;i<9;i++){
						int number=i*9;
						if(fieldFrom.aranmbr+number==fieldTo.aranmbr){ //All squares between clear?..
							System.out.println("Break!");
							break;
						}
						System.out.println(fieldTo.aranmbr);
						System.out.println(fieldFrom.aranmbr + " with number:" + number);
						if(fields[fieldFrom.aranmbr+number].getFigure()!=null){
							System.out.println("something found" + number);
							return false;
						}	
					}
				}
				return true;
			}else{return false;}
			
		}else if(NoColorFigure.equals("Queen")){
			//Bishop
			if(startX-endX==startY-endY){ // weg: /
				if(startY<endY){
					for(int i=1;i<9;i++){
						int number=i*7;
						if(fieldFrom.aranmbr-number==fieldTo.aranmbr){ //All squares between clear?..
							System.out.println("Break!");
							break;
						}
						System.out.println(fieldTo.aranmbr);
						System.out.println(fieldFrom.aranmbr + " with number:" + number);
						if(fields[fieldFrom.aranmbr-number].getFigure()!=null){
							System.out.println("something found" + number);
							return false;
						}	
					}
				}
				if(startY>endY){
					for(int i=1;i<9;i++){
						int number=i*7;
						if(fieldFrom.aranmbr+number==fieldTo.aranmbr){ //All squares between clear?..
							System.out.println("Break!");
							break;
						}
						System.out.println(fieldTo.aranmbr);
						System.out.println(fieldFrom.aranmbr + " with number:" + number);
						if(fields[fieldFrom.aranmbr+number].getFigure()!=null){
							System.out.println("something found" + number);
							return false;
						}	
					}
				}
				return true;
				
			}else if(startX+startY==endX+endY){ // weg: \
				if(startX>endX){
					for(int i=1;i<9;i++){
						int number=i*9;
						if(fieldFrom.aranmbr-number==fieldTo.aranmbr){ //All squares between clear?..
							System.out.println("Break!");
							break;
						}
						System.out.println(fieldTo.aranmbr);
						System.out.println(fieldFrom.aranmbr + " with number:" + number);
						if(fields[fieldFrom.aranmbr-number].getFigure()!=null){
							System.out.println("something found" + number);
							return false;
						}	
					}
				}
				if(startX<endX){
					for(int i=1;i<9;i++){
						int number=i*9;
						if(fieldFrom.aranmbr+number==fieldTo.aranmbr){ //All squares between clear?..
							System.out.println("Break!");
							break;
						}
						System.out.println(fieldTo.aranmbr);
						System.out.println(fieldFrom.aranmbr + " with number:" + number);
						if(fields[fieldFrom.aranmbr+number].getFigure()!=null){
							System.out.println("something found" + number);
							return false;
						}	
					}
				}
				return true;
			}
			//Rook
			if(startX==endX){ // |
				if(startY>endY){
					for(int i=1;i<9;i++){
						if((i*8+fieldFrom.aranmbr)==fieldTo.aranmbr){
							break;
						}
						if(fields[fieldFrom.aranmbr+(i*8)].getFigure()!=null){
							return false;
						}		
					}
					return true;
				}	
				if(startY<endY){
					for(int i=1;i<9;i++){
						int minus=i*8;
						if((fieldFrom.aranmbr-minus)==fieldTo.aranmbr){ //All squares between clear?..
							break;
						}
						if(fields[fieldFrom.aranmbr-minus].getFigure()!=null){ //Is square X clean?s
							return false;
						}		
					}
					return true;
				}		
			}
			else if(startY==endY){ // ----------
				if(startX<endX){
					for(int i=1;i<9;i++){
						if(fieldFrom.aranmbr+i==fieldTo.aranmbr){ //All squares between clear?..
							break;
						}
						if(fields[fieldFrom.aranmbr+i].getFigure()!=null){
							System.out.println(i);
							return false;
						}	
					}
				}
				if(startX>endX){
					for(int i=1;i<9;i++){
						if(fieldFrom.aranmbr-i==fieldTo.aranmbr){ //All squares between clear?..
							break;
						}
						if(fields[fieldFrom.aranmbr-i].getFigure()!=null){
							System.out.println(i);
							return false;
						}	
					}
				}
				return true;
			}
		return false;

		}else if(NoColorFigure.equals("King")){
			if(startX==endX+1 || startX==endX || startX==endX-1){
				if(startY==endY+1 || startY==endY || startY==endY-1){
					return true;
				}
			}
			if(fieldTo.aranmbr==62 && fields[61].getFigure()==null && fields[63].getFigure().hasbeenmoved==false){
				fields[61].setFigure(w_Rook1);
				fields[63].setFigure(null);
				return true;
			}
			if(fieldTo.aranmbr==6 && fields[5].getFigure()==null && fields[7].getFigure().hasbeenmoved==false){
				fields[5].setFigure(b_Rook2);
				fields[7].setFigure(null);
				return true;
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
	public void endOfTurn(Cfigure figureFrom){
		if(turnColor=="White"){
			turnColor="Black";
		}else{
			turnColor="White";
		}
		figureFrom.setHasbeenmoved(true);
		
	}
}





//Anone.. Anone... Platelet....