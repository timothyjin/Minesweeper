package game;

import java.awt.*;

public class Grid {

	private Square[][] grid;
	private Dimension dimension;

	public Grid(int rows, int cols, int bombs) {

	    grid = new Square[rows][cols];
	    dimension = new Dimension(rows, cols);
    }

    public void fillGrid(Square revealed) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((i == revealed.getLocation().x) && (j == revealed.getLocation().y)) {
                    grid[i][j].setValue(0);
                }
            }
        }
    }

    public Square[] getSurroundingSquares(Square center) {
	    Square[] squares = new Square[8];
	    Point p = center.getLocation();

	    for (int i = 0; i < squares.length; i++) {

        }
	    return squares;
    }

	public Square getSquareFromPoint(Point p) {

	    return grid[p.x][p.y];
    }
	
}
