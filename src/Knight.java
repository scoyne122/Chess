
public class Knight extends Piece {
	
	public Knight(int team) {
		super(team, 'N');
	}
	
	@Override
	public boolean[][] getMoves() {
		boolean[][] possible = new boolean[8][8];
		Square[][] squares = ((Board)spot.getParent()).squares;
		for (int dx=-2; dx<= 2; dx+=4) {
			for (int dy=-1; dy<=1; dy+=2) {
				int newX = spot.x + dx;
				int newY = spot.y + dy;
				if (newX>=0 && newX<8 && newY>=0 && newY<8) { //check inBounds
					if (squares[newX][newY].holding == null || squares[newX][newY].holding.team != team) {
						possible[newX][newY] = true;
					}
				}
				//other spots
				newX = spot.x + dy;
				newY = spot.y + dx;
				if (newX>=0 && newX<8 && newY>=0 && newY<8) { //check inBounds
					if (squares[newX][newY].holding == null || squares[newX][newY].holding.team != team) {
						possible[newX][newY] = true;
					}
				}
			}
		}
		return possible;
	}

}
