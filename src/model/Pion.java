package model;

public class Pion extends AbstractPiece implements Pions {
	
	private boolean hasMoved =  false; 
	
	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}

	public boolean isMoveOk(int xFinal, int yFinal) {
		if (this.getCouleur().equals(Couleur.NOIR)) {
			if (xFinal == this.getX() && yFinal == this.getY() + 1) {
				return true;
			}
			else if (!hasMoved && xFinal == this.getX() && yFinal == this.getY() + 2) {
				return true;
			}

		}
		else {
			if (xFinal == this.getX() && yFinal == this.getY() - 1) {
				return true;
			}
			else if (!hasMoved && xFinal == this.getX() && yFinal == this.getY() - 2) {
				return true;
			}
		}
		return false;
	}
	
	public boolean move(int xFinal, int yFinal) {
		if (this.isMoveOk(xFinal, yFinal)) {
			this.hasMoved = true;
			return true;
		}
		return false;
	}
	
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		return false;
	}
}
