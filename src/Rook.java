
public class Rook extends Piece {
	
	public Rook(int team) {
		super(team, 'R');
	}
	
	@Override
	public boolean[][] getMoves() {
		boolean[][] possible = new boolean[8][8];
		int x = spot.x;
		int y = spot.y;
		for (x=spot.x+1, y=spot.y+1; x<8 && y<8 &&((Board)spot.getParent()).squares[x][y].holding == null; x++, y++) {
			possible[x][y] = true;
		}
		if (x<8 && y<8 &&((Board)spot.getParent()).squares[x][y].holding.team != team) {
			possible[x][y] = true;
		}
		for (x=spot.x-1, y=spot.y-1; x>=0 && y>=0 &&((Board)spot.getParent()).squares[x][y].holding == null; x--, y--) {
			possible[x][y] = true;
		}
		if (x>=0 && y>=0 &&((Board)spot.getParent()).squares[x][y].holding.team != team) {
			possible[x][y] = true;
		}
		for (x=spot.x+1, y=spot.y-1; x<8 && y>=0 &&((Board)spot.getParent()).squares[x][y].holding == null; x++, y--) {
			possible[x][y] = true;
		}
		if (x<8 && y>=0 &&((Board)spot.getParent()).squares[x][y].holding.team != team) {
			possible[x][y] = true;
		}
		for (x=spot.x-1, y=spot.y+1; x>=0 && y<8 &&((Board)spot.getParent()).squares[x][y].holding == null; x--, y++) {
			possible[x][y] = true;
		}
		if (x>=0 && y<8 &&((Board)spot.getParent()).squares[x][y].holding.team != team) {
			possible[x][y] = true;
		}
		return possible;
	}
	

}
