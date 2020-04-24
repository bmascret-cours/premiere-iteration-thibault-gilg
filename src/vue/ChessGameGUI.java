package vue;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.Observable;

import controler.ChessGameControlers;

public class ChessGameGUI extends javax.swing.JFrame
implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, java.util.Observer {
	
	String name;
	ChessGameControlers controller;
	Dimension boardSize;
	

	public ChessGameGUI(String name, ChessGameControlers controller, Dimension boardSize) {
		this.name = name;
		this.boardSize = boardSize;
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
