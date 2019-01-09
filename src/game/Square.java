package game;

import javax.swing.*;
import java.awt.*;

public class Square {

    public static final Dimension SQUARE_SIZE = new Dimension(25, 25);

    private static final String BASE_PATH = "C:\\Users\\(!...!)\\workspace\\Minesweeper\\";
    public static final ImageIcon DEFAULT_SQUARE = new ImageIcon(BASE_PATH + "Square.png");
    public static final ImageIcon FLAGGED_SQUARE = new ImageIcon(BASE_PATH + "Flag.png");
    public static final ImageIcon DEFAULT_MINE = new ImageIcon(BASE_PATH + "Mine.png");
    public static final ImageIcon REVEALED_MINE = new ImageIcon(BASE_PATH + "RevealedMine.png");
    public static final ImageIcon INCORRECT_MINE = new ImageIcon(BASE_PATH + "IncorrectMine.png");
    public static final ImageIcon ZERO = new ImageIcon(BASE_PATH + "0.png");
    public static final ImageIcon ONE = new ImageIcon(BASE_PATH + "1.png");
    public static final ImageIcon TWO = new ImageIcon(BASE_PATH + "2.png");
    public static final ImageIcon THREE = new ImageIcon(BASE_PATH + "3.png");
    public static final ImageIcon FOUR = new ImageIcon(BASE_PATH + "4.png");
    public static final ImageIcon FIVE = new ImageIcon(BASE_PATH + "5.png");
    public static final ImageIcon SIX = new ImageIcon(BASE_PATH + "6.png");
    public static final ImageIcon SEVEN = new ImageIcon(BASE_PATH + "7.png");
    public static final ImageIcon EIGHT = new ImageIcon(BASE_PATH + "8.png");
    private static final ImageIcon[] VALUE_ARRAY = {ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT};

//    public static final Color REVEALED_COLOR = new Color(0xB9B9B9);
//    public static final Color BORDER_COLOR = new Color(0x757575);
//    public static final Color COLOR_1 = new Color(0x0000FF);
//    public static final Color COLOR_2 = new Color(0x007B00);
//    public static final Color COLOR_3 = new Color(0xFF0000);
//    public static final Color COLOR_4 = new Color(0x00007B);
//    public static final Color COLOR_5 = new Color(0x7B0000);
//    public static final Color COLOR_6 = new Color(0x007B7B);
//    public static final Color COLOR_7 = new Color(0x000000);
//    public static final Color COLOR_8 = new Color(0x757575);

    private ImageIcon defaultSquare;
    private ImageIcon flaggedSquare;
    private ImageIcon defaultMine;
    private ImageIcon revealedMine;
    private ImageIcon zero;
    private ImageIcon one;
    private ImageIcon two;
    private ImageIcon three;
    private ImageIcon four;
    private ImageIcon five;
    private ImageIcon six;
    private ImageIcon seven;
    private ImageIcon eight;

	private Point location;    // CONTAINS COORDINATES WITHIN GRID, NOT X AND Y!!!
	private boolean mine;
	private boolean revealed;    // true if player has clicked on this square to reveal its state
	private boolean marked;    // true if player has marked this square as a mine
	private int value;    // number of mines surrounding this square, -1 if this square contains a mine
	
	public Square(int r, int c, boolean m) {
		
		location = new Point(r, c);
		mine = m;
		revealed = false;
		marked = false;
	}

	public ImageIcon getIcon() {
	    ImageIcon icon;
	    if (!revealed) {
	        if (!marked) {
                icon = DEFAULT_SQUARE;
            } else {
                icon = FLAGGED_SQUARE;
            }
        } else {    // revealed
	        if (value < 0) {    // mine
                if (marked) {
                    icon = INCORRECT_MINE;
                } else {
                    icon = REVEALED_MINE;
                }
            } else {
	            icon = VALUE_ARRAY[value];
            }
        }
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(SQUARE_SIZE.width, SQUARE_SIZE.height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }
	
	public boolean revealSquare() {
		
		revealed = true;
		if (mine) {
			return false;
		}
		return true;
	}
	
	public void markSquare() {
		
		marked = true;
	}

	public void setValue(int v) { value = v; }
	
	public Point getLocation() { return location; }
	public boolean containsMine() { return mine; }
	public boolean isRevealed() { return revealed; }
	public boolean isMarked() { return marked; }
	public int getValue() { return value; }

	public static Icon rescaleImageIcon(ImageIcon icon, int width, int height) {
	    Image image = icon.getImage();
	    Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    return new ImageIcon(newImage);
    }
}
