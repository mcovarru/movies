package test.org.topcoder.seats;

import org.topcoder.seats.TheMoviesLevelOneDivOne;

import junit.framework.TestCase;

public class TheMoviesLevelOneDivOneTest extends TestCase {

  private TheMoviesLevelOneDivOne seater;
  
  protected void setUp() throws Exception {
    super.setUp();
    this.seater = new TheMoviesLevelOneDivOne();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
    this.seater = null;
  }
  
  
  /**
   * 2
   * 3
   * {1, 2}
   * {2, 3}
   * Returns: 1
   * The first and the second seat in the second row are the only two free seats next to each other in the same row.
   */
  public void test0() {
    assertEquals(1, seater.find(2, 3, new int [] {1, 2}, new int [] {2, 3}));
  }
  
  
  
  /**
   * 2
   * 3
   * {1, 1, 1, 2, 2, 2}
   * {1, 2, 3, 1, 2, 3}
   * Returns: 0
   * There are no free seats in the theater.
   */
  public void test1() {
    assertEquals(0, seater.find(2, 3, new int [] {1, 1, 1, 2, 2, 2}, new int [] {1, 2, 3, 1, 2, 3}));
  }
  
  
  /**
   * 4
   * 7
   * {1}
   * {1}
   * Returns: 23
   */
  public void test2() {
    assertEquals(23, seater.find(4, 7, new int [] {1}, new int [] {1}));
  }
  
  
  /**
   * 10
   * 8
   * {1, 9, 6, 10, 6, 7, 9, 3, 9, 2}
   * {7, 7, 3, 3, 7, 1, 5, 1, 6, 2}
   * Returns: 54
   */
  public void test3() {
    assertEquals(54, seater.find(10, 8, new int [] {1, 9, 6, 10, 6, 7, 9, 3, 9, 2}, new int [] {7, 7, 3, 3, 7, 1, 5, 1, 6, 2}));
  }

}
