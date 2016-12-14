/**
 * @author ScottC
 * @version October 2016
 * made for chess program
 */


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;



public class Square extends JButton implements ActionListener {
	Piece holding;
	int x;
	int y;
	boolean[][] moves;

	public Square(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		addActionListener(this);
		setOpaque(true);
		setBorder(BorderFactory.createEmptyBorder());
		//setContentAreaFilled(false);
		//setBorderPainted(false);
	}
	
	
	//sets which piece is placed on "this"
	void setHolding(Piece piece) {
		holding = piece;
		if (piece != null) {
			setForeground(((Board)getParent()).TEAMCOLORS[holding.team-1]);
			setText(piece.getSymbol());
			//setText("<HTML><BODY><IMG src=\"pics/B1.icns\"/></BODY</HTML>");
			//setIcon(piece.icon);
			piece.spot = this;
		}
		else {
			setText("");
		}
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean isSomethingSelected = !(((Board)getParent()).selected == null);
		//if nothing selected and empty space, do absolutely nothing
		if (holding == null && !isSomethingSelected) {
			return;
		}
		//if click on the selected piece, remove selection
		else if (isSomethingSelected && ((Board)getParent()).selected == this) {
			((Board)getParent()).clearSelection();
		}
		//select the piece if nothing already selected or same team
		else if (holding != null && ((Board)getParent()).turn == holding.team) {
			((Board)getParent()).clearSelection();
			System.out.println("Selecting Piece");
			((Board)getParent()).selected = this;
			moves = holding.getMoves();
			setBackground(Color.YELLOW);
			for (int x=0; x<moves.length; x++) {
				for (int y=0; y<moves.length; y++) {
					if (moves[x][y]) {
						((Board)getParent()).squares[x][y].setBackground(Color.GREEN);
					}
				}
			}
		}
		//move if possible
		else if (isSomethingSelected && ((Board)getParent()).selected.moves[x][y]) {
			System.out.println("moving");
			((Board)getParent()).selected.holding.move(this);
			((Board)getParent()).changeTurn();
		}
	}

}
