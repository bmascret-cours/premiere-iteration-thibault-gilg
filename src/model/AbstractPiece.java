package model;

public abstract class AbstractPiece implements Pieces {
	
	protected Coord coord;
	private Couleur couleur;
	
	public AbstractPiece(Couleur couleur, Coord coord) {
		this.couleur = couleur;
		this.coord = coord;
	}
	
	public void setX(int x) {
		this.coord.x = x;
	}
	
	public void setY(int y) {
		this.coord.x = y;
	}
	
	@Override
	public int getX() {
		return this.coord.x;
	}

	@Override
	public int getY() {
		return this.coord.y;
	}

	@Override
	public Couleur getCouleur() {
		return this.couleur;
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
	public boolean move(int x, int y) {
		if (this.isMoveOk(x, y)) {
			return true;
		}
		return false;
	}
	public String toString() {
		return getClass().getSimpleName() + " (" + getX() + "," + getY() + ")";
	}
	
	
	public static void main(String[] args) {		
		Pieces Tour = new Pion(Couleur.NOIR, new Coord(0, 0));
		System.out.println(Tour);
		System.out.println(Tour.isMoveOk(0,1));

	}
	
}

