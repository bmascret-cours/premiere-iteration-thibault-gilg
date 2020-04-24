package model;

public abstract class AbstractPiece implements Pieces {
	
	protected Coord coord;
	private Couleur couleur;
	private String name;
	
	public AbstractPiece(Couleur couleur, Coord coord) {
		this.couleur = couleur;
		this.coord = coord;
		this.name = this.getClass().getSimpleName();
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
		return this.name + " (" + getX() + "," + getY() + ")";
	}
	
	
	public static void main(String[] args) {		
		Pieces Pion = new Pion(Couleur.BLANC, new Coord(3, 6));
		System.out.println(Pion);
		System.out.println(Pion.isMoveOk(3,4));
		Pion.move(0,2);
		System.out.println(Pion);
		System.out.println(Pion.isMoveOk(0,1));


	}
	
}

