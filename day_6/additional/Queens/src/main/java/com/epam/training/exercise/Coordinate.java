package com.epam.training.exercise;

public class Coordinate {

    private int row;
    private int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean sameRow(Coordinate other) {
        return row == other.row;
    }

    public boolean sameColumn(Coordinate other) {
        return column == other.column;
    }

    public boolean sameDiagonal(Coordinate other) {
        return Math.abs(row - other.row) == Math.abs(column - other.column);
    }

    @Override
    public String toString() {
        return "Coordinate [row=" + row + ", column=" + column + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (column != other.column)
            return false;
        if (row != other.row)
            return false;
        return true;
    }

}
