package model;

public final class Tour extends AbstractPiece implements Pieces {
	
	protected Coord coord;
	private Couleur couleur_de_piece;
	
	public Tour(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece,coord);
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

}
