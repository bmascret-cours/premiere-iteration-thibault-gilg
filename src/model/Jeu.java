package model;

import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	private Couleur couleur;
	private List<Pieces> pieces = null;
	
	public Jeu(Couleur couleur) {
		this.couleur = couleur;
		this.pieces = ChessPiecesFactory.newPieces(couleur);
		
	}
	
	private Pieces findPiece(int x, int y) {
		for (int i = 0; i < this.pieces.size(); i++) {
			if (pieces.get(i).getX() == x && pieces.get(i).getY() == y) {
				return pieces.get(i);
			}
		}
		return null;
	}
	
	public boolean isPieceHere(int x, int y) {
		for (int i = 0; i < this.pieces.size(); i++) {
			if (pieces.get(i).getX() == x && pieces.get(i).getY() == y) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		Pieces piece = this.findPiece(xInit, yInit);
		if (piece != null && piece.isMoveOk(xFinal, yFinal)) {
			return true;
		}
		return false;
	}
	
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		Pieces piece = this.findPiece(xInit, yInit);
		if ()

		return false;
	}
	
	public void setPossibleCapture() {
		
	}
	
	public boolean capture(int xCatch, int yCatch) {
		return false;
	}
	
	public Couleur getPieceColor(int x, int y) {

	}
	
	
	
	@Override
	public String toString() {
		return this.pieces.toString();
	}

	protected List<Pieces> getPieces() {
		return this.pieces;
	}

	protected void setPieces(List<Pieces> pieces) {
		this.pieces = pieces;
	}

	public static void main(String[] args) {
		System.out.println(new Jeu(Couleur.BLANC));

	}

}
