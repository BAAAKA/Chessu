

public class field {
	String color;
	String figure;
	int aranmbr;
	String PathToBlack="src/images/black.jpg";
	String PathToWhite="src/images/white.jpg";
	
	String b_Pawn="src/images/b_Pawn.png";
	String b_Knight="src/images/b_Knight.png";
	String b_Bishop="src/images/b_Bishop.png";
	String b_Rook="src/images/b_Rook.png";
	String b_Queen="src/images/b_Queen.png";
	String b_King="src/images/b_King.png";
	
	String w_Pawn="src/images/w_Pawn.png";
	String w_Knight="src/images/w_Knight.png";
	String w_Bishop="src/images/w_Bishop.png";
	String w_Rook="src/images/w_Rook.png";
	String w_Queen="src/images/w_Queen.png";
	String w_King="src/images/w_King.png";
	
	
	public field(String color, String figure, int aranmbr){
		this.color=color; 
		this.figure=figure;
		this.aranmbr=aranmbr;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFigure() {
		return figure;
	}
	public void setFigure(String figure) {
		this.figure = figure;
	}
	public String getPathToBlack() {
		return PathToBlack;
	}
	public void setPathToBlack(String pathToBlack) {
		PathToBlack = pathToBlack;
	}
	public String getPathToWhite() {
		return PathToWhite;
	}
	public void setPathToWhite(String pathToWhite) {
		PathToWhite = pathToWhite;
	}
	
	public int getAranmbr() {
		return aranmbr;
	}
	public void setAranmbr(int aranmbr) {
		this.aranmbr = aranmbr;
	}
	public String getFigurePath(){
		return figureToPath(figure);
	}
	public String getFigureColor(){
		String name=getFigure();
		String firstLetter = name.substring(0, 1);
		return firstLetter;
	}
	public String figureToPath(String figure){
		if(figure=="b_Pawn"){
			return b_Pawn;
		}else if(figure=="b_Knight"){
			return b_Knight;
		}else if(figure=="b_Bishop"){
			return b_Bishop;
		}else if(figure=="b_Rook"){
			return b_Rook;
		}else if(figure=="b_Queen"){
			return b_Queen;
		}else if(figure=="b_King"){
			return b_King;
		}else if(figure=="w_Pawn"){
			return w_Pawn;
		}else if(figure=="w_Knight"){
			return w_Knight;
		}else if(figure=="w_Bishop"){
			return w_Bishop;
		}else if(figure=="w_Rook"){
			return w_Rook;
		}else if(figure=="w_Queen"){
			return w_Queen;
		}else if(figure=="w_King"){
			return w_King;
		}
		return "nothing";
	}
	
	
}
