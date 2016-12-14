
public class Bishop extends Piece {
	
	public Bishop(int team) {
		super(team, 'B');
	}
	
	@Override
	public boolean[][] getMoves() {
		boolean[][] possible = new boolean[8][8];
		//check all squares south
		for (int y = spot.y+1; y<possible.length; y++) {
			int spotValue = checkSpot(((Board)spot.getParent()).squares[spot.x][y]);
			//Square spotToCheck = ((Board)spot.getParent()).squares[spot.x][y];
			if (spotValue == 1) {
				possible[spot.x][y] = true;
			}
			else if (spotValue == 3) {
				break;
			}
			else {
				possible[spot.x][y] = true;
				break;
			}
		}
		//check all squares north
		for (int y = spot.y-1; y>=0; y--) {
			int spotValue = checkSpot(((Board)spot.getParent()).squares[spot.x][y]);
			if (spotValue == 1) {
				possible[spot.x][y] = true;
			}
			else if (spotValue == 3) {
				break;
			}
			else {
				possible[spot.x][y] = true;
				break;
			}
		}
		//check all squares east
		for (int x=spot.x+1; x<possible.length; x++) {
			int spotValue = checkSpot(((Board)spot.getParent()).squares[x][spot.y]);
			if (spotValue == 1) {
				possible[x][spot.y] = true;
			}
			else if (spotValue == 3) {
				break;
			}
			else {
				possible[x][spot.y] = true;
				break;
			}
		}
		//check all squares west
		for (int x=spot.x-1; x>=0; x--) {
			int spotValue = checkSpot(((Board)spot.getParent()).squares[x][spot.y]);
			if (spotValue == 1) {
				possible[x][spot.y] = true;
			}
			else if (spotValue == 3) {
				break;
			}
			else {
				possible[x][spot.y] = true;
				break;
			}
		}
		return possible;
	}
	
	/**
	 * 1 = empty and keep going
	 * 2 = can capture other piece and stop
	 * 3 = my own piece; stop
	 * @param spotToCheck
	 * @return value
	 */
	private int checkSpot(Square spotToCheck) {
		if (spotToCheck.holding == null) {
			return 1;
		}
		else if (spotToCheck.holding.team == team) {
			return 3;
		}
		else {
			return 2;
		}
	}

}
