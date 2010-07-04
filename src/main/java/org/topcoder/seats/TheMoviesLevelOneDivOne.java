package org.topcoder.seats;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class TheMoviesLevelOneDivOne {
  
  public class Seat implements Comparable<Seat> {
    public int row;
    public int seatNumber;

    public Seat(int row, int seat) {
      this.row = row;
      this.seatNumber = seat;
    }
    
    public boolean equals(Object other) {
      Seat oseat = (Seat) other;
      return row == oseat.row && seatNumber == oseat.seatNumber;
    }
    
    public int hashCode() {
      return 442 * row + 26 * seatNumber;
    }

    public int compareTo(Seat o) {
      if (row != o.row) return row - o.row;
      return seatNumber - o.seatNumber;
    }
  }
  
  
  public class Row {

    private int rowNumber;
    private Seat[] seats;
    private int numSeatsPerRow;
    

    public Row(int rowNumber, Seat[] seats, int numSeatsPerRow) {
      this.rowNumber = rowNumber;
      this.seats = seats;
      this.numSeatsPerRow = numSeatsPerRow;
    }


    public int count() {

      int count = 0;      
      int minimumVacantSeatNumber = 3;

      Iterator<Seat> seatIterator = new SeatInRowIterator(seats, rowNumber);

      while (seatIterator.hasNext()) {
        
        Seat seat = seatIterator.next();
        
        if (seat.seatNumber >= minimumVacantSeatNumber)
          count += (seat.seatNumber - minimumVacantSeatNumber + 1);
     
        // add 3 since we want a pair of seats, plus the next full seat needs
        // to be at least one past that (assuming there are more full seats
        // on this row)
        minimumVacantSeatNumber = seat.seatNumber + 3;        
        
      }
      
      // to handle the case of the end of the row, think of there being a 
      // final phantom seat after the real final seat, and this phantom
      // final seat is filled.
      int phantomFinalSeatPosition = numSeatsPerRow + 1;
      if (minimumVacantSeatNumber <= phantomFinalSeatPosition)
        count += (phantomFinalSeatPosition - minimumVacantSeatNumber + 1);
      
      
      return count;
    }

  }
  
  
  public class SeatInRowIterator implements Iterator<Seat> {

    private int current;
    private Seat[] seats;
    private int rowNumber;
    
    public SeatInRowIterator(Seat [] seats, int rowNumber) {
      this.seats = seats;
      this.rowNumber = rowNumber;
      current = 0;
      while (current < seats.length && seats[current].row < rowNumber)
        current++;
      // one too far
      current--;
    }

    public boolean hasNext() {
      return current + 1 < seats.length && seats[current + 1].row == rowNumber;
    }


    public Seat next() {
      if (!hasNext())
        throw new NoSuchElementException();
      current++;
      return seats[current];
    }


    public void remove() {
      throw new UnsupportedOperationException();
    }
    
  }
  
  public class RowIterator implements Iterator<Row> {
    
    private int current = -1;
    
    private Seat[] seats;

    private int numSeatsPerRow;

    private int numRows;

    public RowIterator(Seat [] seats, int numRows, int numSeatsPerRow) {
      this.seats = seats;
      this.numRows = numRows;
      this.numSeatsPerRow = numSeatsPerRow;
    }

    public boolean hasNext() {
      return current + 1 < numRows;
    }

    public Row next() {
      if (!hasNext())
        throw new NoSuchElementException();
      
      current++;
      return new Row(current + 1, seats, numSeatsPerRow);
    }


    public void remove() {
      throw new UnsupportedOperationException();
    }
    
  }
  
  
  public int find(int numRows, int numSeatsPerRow, int [] rows, int [] seatz) {
    
    Seat [] seats = new Seat[rows.length];
    
    
    for (int i = 0; i < seats.length; i++)
      seats[i] = new Seat(rows[i], seatz[i]);
    
    Arrays.sort(seats);
    
    
    int count = 0;
    
    Iterator<Row> rowIterator = new RowIterator(seats, numRows, numSeatsPerRow);
    
    while (rowIterator.hasNext()) { 
      Row row = rowIterator.next();
      count += row.count();
      
    }
    
    return count;
    
  }

}
