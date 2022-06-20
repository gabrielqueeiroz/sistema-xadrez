package boardgame;

public class Board {
    private int row, column;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.row = rows;
        this.column = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return row;
    }

    public void setRows(int rows) {
        this.row = rows;
    }

    public int getColumns() {
        return column;
    }

    public void setColumns(int column) {
        this.column = column;
    }

    public Piece piece(int row, int column){
        return pieces[row][column];
    }

    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }
}
