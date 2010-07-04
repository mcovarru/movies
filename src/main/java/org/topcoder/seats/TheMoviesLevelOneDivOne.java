package org.topcoder.seats;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class TheMoviesLevelOneDivOne {
  
  public class Seat implements Comparable<Seat> {
    public int row;
    public int seat;

    public Seat(int row, int seat) {
      this.row = row;
      this.seat = seat;
    }
    
    public boolean equals(Object other) {
      Seat oseat = (Seat) other;
      return row == oseat.row && seat == oseat.seat;
    }
    
    public int hashCode() {
      return 442 * row + 26 * seat;
    }

    @Override
    public int compareTo(Seat o) {
      if (row != o.row) return row - o.row;
      return seat - o.seat;
    }
  }
  
  
  public class Row implements Iterable<Seat> {

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
      Iterator<Seat> seatIterator = iterator();
      
      Seat seat = null;
      
      // 3: 1 for 1-based, 2 for 2 seats. 1 + 2 = 3
      int currentThreshold = 2;
      
      while (seatIterator.hasNext()) {
        seat = seatIterator.next();
        
        if (seat.seat > currentThreshold)
          count += seat.seat - currentThreshold;

     
        // add 2 since we want a pair of seats
        currentThreshold = seat.seat + 2;        
        
        if (!seatIterator.hasNext()) {
          if (seat.seat > currentThreshold)
            count += seat.seat - currentThreshold;
          else if (seat.seat + 2 <= numSeatsPerRow)
            count += (numSeatsPerRow - seat.seat - 1);
            
        }

      }
      
      if (seat == null) count = numSeatsPerRow - 1;
      
      return count;
    }


    @Override
    public Iterator<Seat> iterator() {
      return new SeatInRowIterator(seats, rowNumber);
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

    @Override
    public boolean hasNext() {
      return current + 1 < seats.length && seats[current + 1].row == rowNumber;
    }

    @Override
    public Seat next() {
      if (!hasNext())
        throw new NoSuchElementException();
      current++;
      return seats[current];
    }

    @Override
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

    @Override
    public boolean hasNext() {
      return current + 1 < numRows;
    }

    @Override
    public Row next() {
      if (!hasNext())
        throw new NoSuchElementException();
      
      current++;
      return new Row(current + 1, seats, numSeatsPerRow);
    }

    @Override
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
