package model;

import java.util.ArrayList;
import java.util.List;

public class Echiquier implements BoardGames {
	
	private Jeu JeuBlanc;
	private Jeu JeuNoir;
	private Jeu JeuCourant;
	private Jeu JeuNonCourant;
	private String message;
	
	
	public Echiquier() {
		this.JeuBlanc = new Jeu(Couleur.BLANC);
		this.JeuNoir = new Jeu(Couleur.NOIR);
		this.JeuCourant = JeuNoir;
		this.JeuNonCourant = JeuBlanc;

	}

	public void switchJoueur() {
		if (this.JeuCourant == JeuBlanc) {
			this.JeuCourant = JeuNoir;
			this.JeuNonCourant = JeuBlanc;		
		}
		
		else {
			this.JeuCourant = JeuBlanc;		
			this.JeuNonCourant = JeuNoir;		
		}
	}

	public List<PieceIHM> getPiecesIHM(){
		List <PieceIHM> pieces = new ArrayList();
		List <PieceIHM> piecesNoir = this.JeuNoir.getPiecesIHM();
		List <PieceIHM> piecesBlanc = this.JeuBlanc.getPiecesIHM();
		
		for (PieceIHM piece : piecesNoir) {
			pieces.add(piece);
		}
		
		for (PieceIHM piece : piecesBlanc) {
			pieces.add(piece);
		}
		
		return pieces;
		
	}
	
	public boolean isMoveOk(int	xInit, int yInit, int xFinal, int yFinal) {
		// pas de pièce aux coords init
		if (!this.JeuCourant.isPieceHere(xInit, yInit)){
			return false;
		}
		/*
		if ((xFinal != xInit && yFinal != yInit) || (xFinal >= 0 && xFinal <= 8 && yFinal >= 0 && yFinal <= 8) 		
			|| JeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal) == false
			|| (JeuNonCourant.findPiece ))	// mouvement possible
			return false;
		}*/
	}
	
	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		return this.JeuCourant.move(xInit, yInit, xFinal, yFinal);
	}
	
	@Override
	public String toString() {
		return this.JeuBlanc.toString() + "\n" + this.JeuNoir.toString();
	}
	
	@Override
	public Couleur getColorCurrentPlayer() {
		return JeuCourant.getCouleur();
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		return this.JeuCourant.getPieceColor(x, y);
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	private void setMessage(String message) {
		this.message = message;
		
	}
	
	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {		
		Echiquier Echec = new Echiquier();
		System.out.println(Echec);
		
		System.out.println(Echec.getPieceIHM());

	}
}
