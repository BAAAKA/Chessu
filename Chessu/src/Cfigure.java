
public class Cfigure {
	boolean hasbeenmoved=false;
	boolean alive=true;
	String teamColor;
	String figureKind;
	
	public Cfigure(String teamColor, String figureKind){
		this.teamColor=teamColor;
		this.figureKind=figureKind;
	}

	public boolean isHasbeenmoved() {
		return hasbeenmoved;
	}

	public void setHasbeenmoved(boolean hasbeenmoved) {
		this.hasbeenmoved = hasbeenmoved;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public String getTeamColor() {
		return teamColor;
	}

	public void setTeamColor(String teamColor) {
		this.teamColor = teamColor;
	}

	public String getFigureKind() {
		return figureKind;
	}

	public void setFigureKind(String figureKind) {
		this.figureKind = figureKind;
	}
	
	
}
