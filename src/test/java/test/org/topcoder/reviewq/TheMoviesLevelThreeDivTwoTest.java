package test.org.topcoder.reviewq;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.topcoder.reviewq.TheMoviesLevelThreeDivTwo;
import org.topcoder.reviewq.TheMoviesLevelThreeDivTwo.Distribution;
import org.topcoder.reviewq.TheMoviesLevelThreeDivTwo.Movie;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TheMoviesLevelThreeDivTwoTest 
    extends TestCase
{
    private TheMoviesLevelThreeDivTwo movieQueuer;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TheMoviesLevelThreeDivTwoTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TheMoviesLevelThreeDivTwoTest.class );
    }
    
    
    public void setUp() {
      this.movieQueuer = new TheMoviesLevelThreeDivTwo();
    }
    
    public void tearDown() {
      this.movieQueuer = null;
    }
    
    
    private int [] getIds(List<Movie> movieList) {
      int [] ret = new int[movieList.size()];
      
      for (int i = 0; i < ret.length; i++)
        ret[i] = movieList.get(i).getId();
      
      return ret;
    }
    
    
    private int [] getJohnIds(TheMoviesLevelThreeDivTwo.Distribution dist) {
      return getIds(dist.getJohnList());
    }
    
    private int [] getBrusIds(TheMoviesLevelThreeDivTwo.Distribution dist) {
      return getIds(dist.getBrusList());
    }
    

    
    public void testDistributor() {
      
      final int NUM_MOVIES = 3;
      Movie [] movies = new Movie[NUM_MOVIES];
      
      for (int i = 0; i < NUM_MOVIES; i++)
        movies[i] = new Movie(i, 0, 0);
      
      TheMoviesLevelThreeDivTwo.Distributor distrib =
        new TheMoviesLevelThreeDivTwo.Distributor(movies);
      
      int [] [] johnIds = new int [] [] {
          {0, 1, 2},  // 0 0 0
          {1, 2},     // 0 0 1
          {0, 2},     // 0 1 0
          {2},        // 0 1 1
          {0, 1},     // 1 0 0
          {1},        // 1 0 1
          {0},        // 1 1 0
          {}          // 1 1 1
      };
      
      int [] [] brusIds = new int [] [] {
          {},         // 0 0 0
          {0},        // 0 0 1
          {1},        // 0 1 0
          {0, 1},     // 0 1 1
          {2},        // 1 0 0
          {0, 2},     // 1 0 1
          {1, 2},     // 1 1 0
          {0, 1, 2}   // 1 1 1
      };      
      

      Iterator<Distribution> iter = distrib.iterator();
      for (int i = 0; i < Math.pow(2, NUM_MOVIES); i++) {
        assertTrue(iter.hasNext());
        TheMoviesLevelThreeDivTwo.Distribution dist = iter.next();
        assertNotNull(dist);
        assertTrue(Arrays.equals(johnIds[i], getJohnIds(dist)));
        assertTrue(Arrays.equals(brusIds[i], getBrusIds(dist)));        
      }
      
      
      assertFalse(iter.hasNext());
      
      
    }

    /**
     * {4, 4}
     * {4, 4}
     * 
     * returns 2
     */
    public void test0() {
      
    }
    
    /**
     * {1, 4}
     * {4, 2}
     * 
     * returns 1
     */
    public void test1() {
      
    }
    
    
    /**
     * {10, 10, 10, 10}
     * {1, 1, 1, 10}
     * 
     * returns 3
     */
    public void test2() {
      
    }
    
    
    /**
     * {1, 2, 3, 4, 5, 6, 7}
     * {7, 6, 5, 4, 3, 2, 1}
     * 
     * returns 98
     */
    public void test3() {
      
    }
}
