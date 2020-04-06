package model;

public class Pion extends AbstractPiece {

	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}

	public boolean isMoveOk(int xFinal, int yFinal) {
		// TODO déplacement de 2 cases au début
		if (xFinal == this.getX() && yFinal == this.getY() + 1) {
			return true;
		}
		
		return false;
	}
	
	public boolean move(int x, int y) {
		return false;
	}
	
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		return false;
	}
}
