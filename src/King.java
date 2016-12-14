
public class King extends Piece {
	
	public King(int team) {
		super(team, 'K');
	}
	
	@Override
	public boolean[][] getMoves() {
		boolean[][] possible = new boolean[8][8];
		Square[][] squares = ((Board)spot.getParent()).squares;
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				if (spot.x+dx >= 0 && spot.x+dx < 8 && spot.y+dy > 0 && spot.y+dy <8) {
					if (squares[spot.x+dx][spot.y+dy].holding == null || squares[spot.x+dx][spot.y+dy].holding.team != team) {
						possible[spot.x+dx][spot.y+dy] = true;
					}
				}
			}
		}
		return possible;
	}

}
