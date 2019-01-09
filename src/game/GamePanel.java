package game;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel implements Runnable, MouseListener {

	private static final long serialVersionUID = 1L;

	private static Dimension DEFAULT_RESOLUTION = new Dimension(1200, 900);

	private JLabel[][] board;
    private Square firstSquare = null;

	private boolean gameStarted = false;
	private boolean minesSet = false;

	private boolean leftButtonDown = false;
	private boolean rightButtonDown = false;

	private boolean reveal = false;
	private boolean mark = false;
    private boolean chord = false;

    private Square test;

	public GamePanel() {
        setPreferredSize(DEFAULT_RESOLUTION);
        setDoubleBuffered(true);
        setLayout(null);
        setFocusable(true);

        addMouseListener(this);

//        grid = new Grid(10, 10, 25);
    }

    @Override
    public void run() {
	    while (true) {
	        if (gameStarted && !minesSet) {
//	            grid.fillGrid(firstSquare);
	            minesSet = true;
            }
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Icon one = Square.rescaleImageIcon(Square.DEFAULT_SQUARE, Square.SQUARE_SIZE.width, Square.SQUARE_SIZE.height);
	    one.paintIcon(this, g, 400, 400);
//	    g.drawImage(Square.ONE.getImage(), 200, 200, this);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // draw squares
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            leftButtonDown = true;
        }
        if (SwingUtilities.isRightMouseButton(e)) {
            rightButtonDown = true;
        }

        if (leftButtonDown && rightButtonDown) {
            chord = true;
            reveal = false;
            mark = false;
        } else if (leftButtonDown) {
            chord = false;
            reveal = true;
            mark = false;
        } else if (rightButtonDown) {
            chord = false;
            reveal = false;
            mark = true;
        }

	    Point press = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            leftButtonDown = false;
        }
        if (SwingUtilities.isRightMouseButton(e)) {
            rightButtonDown = false;
        }

        if (chord) {    // TODO: fix this double chord call
            System.out.println("chord");
        } else if (reveal) {
            if (!gameStarted) {
//                firstSquare = grid.getSquareFromPoint(e.getPoint());
                gameStarted = true;
                test.getIcon()
                test = new JLabel(Square.ONE.getIcon);
                add(test);
                test.setBounds(0, 0, 1200, 900);
                test.setLocation(400, 400);
                test.setSize(Square.ONE.getIcon, Square.ONE.getIconWidth());
            }
            System.out.println("reveal");
        } else if (mark) {
            System.out.println("mark");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
