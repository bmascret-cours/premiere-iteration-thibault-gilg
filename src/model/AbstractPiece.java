package model;

public abstract class AbstractPiece implements Pieces {
	
	protected Coord coord;
	private Couleur couleur;
	
	public AbstractPiece(Couleur couleur, Coord coord) {
		this.couleur = couleur;
		this.coord = coord;
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Couleur getCouleur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean capture() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean move(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}
	public String toString() {
		return getClass().getSimpleName() + " (" + getX() + getY() + ")";
	}
}
