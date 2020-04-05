package model;

public interface Pieces {
	
	public int getX();
	
	public int getY();
	
	public Couleur getCouleur();
	
	public boolean capture();
	
	public boolean isMoveOk(int xFinal, int yFinal);
	
	public boolean	move(int xFinal, int yFinal);
}

