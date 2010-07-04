package test.org.topcoder.reviewq;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.topcoder.reviewq.TheMoviesLevelThreeDivOne;
import org.topcoder.reviewq.TheMoviesLevelThreeDivOne.Distribution;
import org.topcoder.reviewq.TheMoviesLevelThreeDivOne.Movie;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TheMoviesLevelThreeDivOneTest 
    extends TestCase
{
    private TheMoviesLevelThreeDivOne movieQueuer;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TheMoviesLevelThreeDivOneTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TheMoviesLevelThreeDivOneTest.class );
    }
    
    
    public void setUp() {
      this.movieQueuer = new TheMoviesLevelThreeDivOne();
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
    
    
    private int [] getJohnIds(TheMoviesLevelThreeDivOne.Distribution dist) {
      return getIds(dist.getJohnList());
    }
    
    private int [] getBrusIds(TheMoviesLevelThreeDivOne.Distribution dist) {
      return getIds(dist.getBrusList());
    }
    

    
    public void testDistributor() {
      
      final int NUM_MOVIES = 3;
      Movie [] movies = new Movie[NUM_MOVIES];
      
      for (int i = 0; i < NUM_MOVIES; i++)
        movies[i] = new Movie(i, 0, 0);
      
      TheMoviesLevelThreeDivOne.Distributor distrib =
        new TheMoviesLevelThreeDivOne.Distributor(movies);
      
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
        TheMoviesLevelThreeDivOne.Distribution dist = iter.next();
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
      assertEquals(2, movieQueuer.find(new int [] {4, 4}, new int [] {4, 4}));
    }
    
    /**
     * {1, 4}
     * {4, 2}
     * 
     * returns 1
     */
    public void test1() {
      assertEquals(1, movieQueuer.find(new int [] {1, 4}, new int [] {4, 2}));
      
    }
    
    
    /**
     * {10, 10, 10, 10}
     * {1, 1, 1, 10}
     * 
     * returns 3
     */
    public void test2() {
      assertEquals(3, movieQueuer.find(new int [] {10, 10, 10, 10}, new int [] {1, 1, 1, 10}));
    }
    
    
    /**
     * {1, 2, 3, 4, 5, 6, 7}
     * {7, 6, 5, 4, 3, 2, 1}
     * 
     * returns 98
     */
    public void test3() {
      assertEquals(98, movieQueuer.find(new int [] {1, 2, 3, 4, 5, 6, 7}, new int [] {7, 6, 5, 4, 3, 2, 1}));
    }
}
