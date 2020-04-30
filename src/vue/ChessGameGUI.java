package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controler.ChessGameControlers;
import model.Coord;
import model.PieceIHM;
import tools.ChessImageProvider;

public class ChessGameGUI extends javax.swing.JFrame
	implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, java.util.Observer {
	
	
	private JLayeredPane layeredPane;
	private JPanel chessBoard;
	private JLabel chessPiece;
	private int xAdjustment;
	private int yAdjustment;
	  
	private ChessGameControlers chessGameController;

	  

	public ChessGameGUI(String name, ChessGameControlers chessGameController, Dimension boardSize) {
		this.chessGameController = chessGameController;

		//  Use a Layered Pane for this application
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);
		
		//Add a chess board to the Layered Pane 
		 
		chessBoard = new JPanel();
		layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout( new GridLayout(8, 8) );
		chessBoard.setPreferredSize( boardSize );
		chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
		 
		for (int i = 0; i < 64; i++) {
			JPanel square = new JPanel( new BorderLayout() );
			chessBoard.add( square );
		 
			int row = (i / 8) % 2;
			if (row == 0)
				square.setBackground( i % 2 == 0 ? Color.black : Color.white );
			else
				square.setBackground( i % 2 == 0 ? Color.white : Color.black );
		}

		
	}
	

	@Override
	public void update(Observable o, Object arg) {
		
		List<PieceIHM> listPiecesIHM = (List<PieceIHM>) arg;
		for (PieceIHM pieceIHM : listPiecesIHM) {
			for (Coord coord : pieceIHM.getList()) {
				System.out.println(ChessImageProvider
						.getImageFile(pieceIHM.getTypePiece(), pieceIHM.getCouleur()));
				JLabel piece = new JLabel( new ImageIcon(ChessImageProvider
						.getImageFile(pieceIHM.getTypePiece(), pieceIHM.getCouleur())));
				JPanel panel = (JPanel)chessBoard.getComponent(coord.x + 8*coord.y);
				panel.add(piece);
			}
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
    private Coord getPieceCoord(int x, int y) {
        return new Coord(x/(700/8), y/(700/8));
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
		

	@Override
	public void mousePressed(MouseEvent e) {
		chessPiece = null;
		Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		 
		if (c instanceof JPanel) 
			return;
		 
		Point parentLocation = c.getParent().getLocation();
		xAdjustment = parentLocation.x - e.getX();
		yAdjustment = parentLocation.y - e.getY();
		chessPiece = (JLabel)c;
		chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
		
	}

	public void mouseDragged(MouseEvent me) {
		if (chessPiece == null) return;
		chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	}
		 
		//Drop the chess piece back onto the chess board
		 
	public void mouseReleased(MouseEvent e) {
		if(chessPiece == null) return;
		 
		chessPiece.setVisible(false);
		Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
		 
		if (c instanceof JLabel){
			Container parent = c.getParent();
			parent.remove(0);
			parent.add( chessPiece );
		}
		  
		else {
			Container parent = (Container)c;
			parent.add( chessPiece );
		}
		 
		chessPiece.setVisible(true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
