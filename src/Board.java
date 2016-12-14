/**
 * @author ScottC
 * @version October 2016
 * made for chess program
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Board extends JPanel {
	public final int WIDTH = 8;
	public final int HEIGHT = 8;
	private Piece[] team1 = {
			new Bishop(1),
			new Knight(1),
			new Rook(1),
			new King(1),
			new Queen(1),
			new Rook(1),
			new Knight(1),
			new Bishop(1)
	};
	private Piece[] team2 = {
			new Bishop(2),
			new Knight(2),
			new Rook(2),
			new King(2),
			new Queen(2),
			new Rook(2),
			new Knight(2),
			new Bishop(2)
	};
	int turn = 1;
	Square selected;
	Square[][] squares = new Square[WIDTH][HEIGHT];
	public final Color[] TEAMCOLORS = {Color.BLUE, Color.RED};
	public final String[] TEAMCOLORNAMES = {"Blue", "Red"};
	
	
	
	/**
	 * Constructor
	 */
	public Board() {
		setLayout(new GridLayout(WIDTH, HEIGHT));
		setSquares();
		setPieces();
		clearSelection(); // creates blank and colored board
	}
	
	
	
	/**
	 * puts all squares on the board
	 */
	private void setSquares() {
		for (int r=0; r<WIDTH; r++) {
			for (int c=0; c<HEIGHT; c++) {
				squares[c][r] = new Square(c, r);
				add(squares[c][r]);
			}
		}
	}
	
	
	/**
	 * puts all pieces on board for both teams
	 */
	private void setPieces() {
		for (int i=0; i<HEIGHT; i++) {
			squares[i][1].setHolding(new Pawn(1));
			squares[i][HEIGHT-2].setHolding(new Pawn(2));
			squares[i][0].setHolding(team1[i]);
			squares[WIDTH-1-i][HEIGHT-1].setHolding(team2[i]);
		}
	}
	
	
	
	/**
	 * changes whose turn it is
	 * also clears all selected pieces
	 */
	public void changeTurn() {
		turn = -turn + 3;
		clearSelection();
	}
	
	public void clearSelection() {
		selected = null;
		Color[] tileColors = {new Color(204, 221, 255), new Color(255, 255, 204)};
		for (Square[] line: squares) {
			for (Square square : line) {
				square.setBackground(tileColors[(square.x + square.y) % 2]);
			}
		}
	}
	
	
	/**
	 * ends the game
	 * called when king is captured in the Piece class
	 */
	public void endGame(int winner) {
		JFrame winFrame = new JFrame("Winner");
		winFrame.add(new JLabel(TEAMCOLORNAMES[winner-1] + " Team Wins!"));
		winFrame.setSize(150, 150);
		winFrame.setVisible(true);
		winFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JPanel parent = (JPanel)Board.this.getParent();
				parent.remove(Board.this);
				parent.revalidate();
				parent.add(new Board());
			}
		});
		//remove action listeners to stop moving
		for (Square[] line : squares) {
			for (Square square : line) {
				try {
					square.removeActionListener(square);
				} catch (ArrayIndexOutOfBoundsException e) {};
			}
		}
	}
	


	/**
	 * MAIN METHOD
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Chess");
		frame.setSize(400, 400);
		Board board = new Board();
		frame.add(board);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
