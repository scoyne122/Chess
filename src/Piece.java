import java.io.File;

import javax.swing.ImageIcon;

/**
 * @author ScottC
 *
 */


public abstract class Piece {
	char symbol;
	Square spot;
	int team;
	ImageIcon icon;
	
	public Piece(int team, char symbol) {
		this.team = team;
		this.symbol = symbol;
		icon = new ImageIcon("pics/" + symbol + team + ".icns");
	}
	
	
	
	public void move(Square newSpot) {
		this.spot.setHolding(null);
		this.spot = newSpot;
		if (this.spot.holding != null && this.spot.holding.getClass() == King.class) {
			((Board)this.spot.getParent()).endGame(team);
		}
		this.spot.setHolding(this);
	}
	
	public String getSymbol() {
		return "" + symbol;
	}
	
	
	public abstract boolean[][] getMoves();
	

	
}
