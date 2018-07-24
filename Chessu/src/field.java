

public class field {
	String color;
	Cfigure figure=null;
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
	
	
	public field(String color, Cfigure figure, int aranmbr){
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
	public Cfigure getFigure() {
		return figure;
	}
	public void setFigure(Cfigure figure) {
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
		if(figure!=null){
			return figureToPath(figure.getFigureKind(), figure.getTeamColor());
		}else{
			return "nothing";
		}
	}
	public String figureToPath(String figure, String figureTeam){
		if(figure=="Pawn" && figureTeam.equals("b")){
			return b_Pawn;
		}else if(figure=="Knight" && figureTeam.equals("b")){
			return b_Knight;
		}else if(figure=="Bishop" && figureTeam.equals("b")){
			return b_Bishop;
		}else if(figure=="Rook" && figureTeam.equals("b")){
			return b_Rook;
		}else if(figure=="Queen" && figureTeam.equals("b")){
			return b_Queen;
		}else if(figure=="King" && figureTeam.equals("b")){
			return b_King;
		}else if(figure=="Pawn" && figureTeam.equals("w")){
			return w_Pawn;
		}else if(figure=="Knight" && figureTeam.equals("w")){
			return w_Knight;
		}else if(figure=="Bishop" && figureTeam.equals("w")){
			return w_Bishop;
		}else if(figure=="Rook" && figureTeam.equals("w")){
			return w_Rook;
		}else if(figure=="Queen" && figureTeam.equals("w")){
			return w_Queen;
		}else if(figure=="King" && figureTeam.equals("w")){
			return w_King;
		}
		System.out.println("Error, figureToPath, FIGURE NOT FOUND!");
		return "nothing";
	}
	
	
}
