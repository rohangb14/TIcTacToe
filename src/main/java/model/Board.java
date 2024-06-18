package model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int dimension;
    private List<List<Cell>> matrix;

    /*
           dimension = 3
OutsideArrayList<--[
                       [_, _, _] -insideList
                       [_, _, _]
                       [_, _, _]
                   ]
        */

    // Constructor that initializes the board with a given dimension
    public Board(int dimension){
        this.dimension = dimension; // Sets the board's dimension to the provided value.
        matrix = new ArrayList<>(); // Initializes the outer ArrayList to hold the rows of cells.
        for(int i = 0; i < dimension; i++){ // Loops through each row index from 0 to dimension-1.
            matrix.add(new ArrayList<>()); // Adds a new ArrayList to the outer list to represent a row.
            for(int j = 0; j < dimension; j++){ // Loops through each column index from 0 to dimension-1.
                matrix.get(i).add(new Cell(i, j)); // Adds a new Cell to the current row with coordinates (i, j).
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;


    }
}
