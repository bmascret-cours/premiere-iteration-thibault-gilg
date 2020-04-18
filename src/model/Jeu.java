package model;

import java.util.LinkedList;
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
			if (isPieceHere(x,y)) {
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
		if (this.isMoveOk(xInit, yInit, xFinal, yFinal)) {
			Pieces piece = this.findPiece(xInit, yInit);	
			piece.setX(xFinal);
			piece.setY(yFinal);
			return true;
		}
		return false;
	}
	
	public void setPossibleCapture() {
		
	}
	
	public boolean capture(int xCatch, int yCatch) {
		return false;
	}
	
	public Couleur getPieceColor(int x, int y) {
		Pieces piece = this.findPiece(x, y);
		return piece.getCouleur();
	}
	
	public String getPieceType(int x, int y) {
		Pieces piece = this.findPiece(x, y);
		return piece.getClass().getSimpleName();
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
		/**
		* @return une vue de la liste des pièces en cours
		* ne donnant que des accès en lecture sur des PieceIHM
		* (type piece + couleur + liste de coordonnées)
		*/
		public List<PieceIHM> getPiecesIHM(){
			PieceIHM newPieceIHM = null;
			List<PieceIHM> list = new LinkedList<PieceIHM>();
			
			for (Pieces piece : pieces){
				
				boolean existe = false;
				// si le type de piece existe déjà dans la liste de PieceIHM
				// ajout des coordonnées de la pièce dans la liste de Coord de ce type
				// si elle est toujours en jeu (x et y != -1)
				for ( PieceIHM pieceIHM : list){
					if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
						existe = true;
						if (piece.getX() != -1){
							pieceIHM.add(new Coord(piece.getX(), piece.getY()));
							}
					}
				}
				// sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
				if (! existe) {
					if (piece.getX() != -1){
						newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
						piece.getCouleur());
						newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
						list.add(newPieceIHM);
					}
				}
			}
			return list;
		}
	
	public void setCastling() {
		
	}
	
	public void undoMove() {
		
	}

	public void undoCapture() {
		
	}
	
	public boolean isPawnPromotion(int xFinal, int yFinal) {
		if (this.getPieceType(xFinal, yFinal).getClass().getSimpleName() == "Pion"){
			return true;
		}
		
		return false;
	}
	
	public boolean pawnPromotion(int xFinal, int yFinal, String type) {
		if (this.isPawnPromotion(xFinal, yFinal)) {
			Pieces piece = this.findPiece(xFinal, yFinal);
			piece = null;
			// TODO créer une pièce avec le type demandé
			return true;
		}
		return false;
	}
		
	
	public Coord getKingCoord() {
		Coord coord = new Coord(0,0);
		for (int i = 0; i < this.pieces.size(); i++) {
			if (this.pieces.get(i).getClass().getSimpleName() == "Roi" ){
				coord.x = this.pieces.get(i).getX();
				coord.y = this.pieces.get(i).getY();
			}
		}
		return coord;
	}
	
	
	@Override
	public String toString() {
		return "Jeu " + getCouleur() + " : " + this.pieces.toString();
	}

}
