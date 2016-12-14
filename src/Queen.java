
public class Queen extends Piece {
	
	public Queen(int team) {
		super(team, 'Q');
	}
	
	@Override
	public boolean[][] getMoves() {
		boolean[][] possible = new boolean[8][8];
		Bishop testBishop = new Bishop(team);
		Rook testRook = new Rook(team);
		testBishop.spot = spot;
		testRook.spot = spot;
		boolean[][] rookSpots = testRook.getMoves();
		boolean[][] bishopSpots = testBishop.getMoves();
		for (int x=0; x<possible.length; x++) {
			for (int y=0; y<possible.length; y++) {
				possible[x][y] = bishopSpots[x][y] || rookSpots[x][y];
			}
		}
		return possible;
	}

}
