
public class Pawn extends Piece {
	boolean hasMoved = false;
	
	public Pawn(int team) {
		super(team, 'P');
	}

	
	@Override
	public boolean[][] getMoves() {
		boolean[][] possible = new boolean[8][8];
		//nothing if they are at the end
		if (spot.y+(-2*team+3) == 0 || spot.y+(-2*team+3) == 8)
			return possible;
		Square[][] squares = ((Board)spot.getParent()).squares;
		if (!hasMoved && squares[spot.x][spot.y+2*(-2*team+3)].holding == null) {
			possible[spot.x][spot.y+2*(-2*team+3)] = true;
		}
		try {
			if (squares[spot.x][spot.y+(-2*team+3)].holding == null)
				possible[spot.x][spot.y+(-2*team+3)] = true;
			if (squares[spot.x+1][spot.y+(-2*team+3)].holding != null && squares[spot.x+1][spot.y+(-2*team+3)].holding.team != team)
				possible[spot.x+1][spot.y+(-2*team+3)] = true;
			if (squares[spot.x-1][spot.y+(-2*team+3)].holding != null && squares[spot.x-1][spot.y+(-2*team+3)].holding.team != team)
				possible[spot.x-1][spot.y+(-2*team+3)] = true;
		}
		catch (ArrayIndexOutOfBoundsException e) {};
		return possible;
	}
	
	
	@Override
	public void move(Square newSpot) {
		super.move(newSpot);
		if (!hasMoved) {
			hasMoved = true;
		}
	}

}
