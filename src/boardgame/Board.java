package boardgame;

public class Board {
    private int row, column;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Erro criando tabuleiro: É necessário haver pelo menos uma linha e uma coluna");
        }
        this.row = rows;
        this.column = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return row;
    }

    public int getColumns() {
        return column;
    }

    public Piece piece(int row, int column){
        if(!positionExists(row,column)){
            throw new BoardException("Posição não existente");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição não existente");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece , Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("Posição já preenchida por outra peça");
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public boolean positionExists(int row, int column){
        return row >= 0 && row < this.row && column >=0 && column < this.column;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição não existe");
        }
        return piece(position) != null;
    }
}
