package test.org.topcoder.reviewq;

import java.util.Arrays;

import org.topcoder.reviewq.TheMoviesLevelThreeDivTwo;
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
    
    private class IdHolder {
      public int [] johnIds;
      public int [] brusIds;
      
      
    }
    
    public IdHolder getIds(TheMoviesLevelThreeDivTwo.Distributor distrib) {
      IdHolder holder = new IdHolder();
      
      holder.johnIds = new int [distrib.getJohnList().size()];
      holder.brusIds = new int [distrib.getBrusList().size()];
      
      
      for (int i = 0; i < holder.johnIds.length; i++)
        holder.johnIds[i] = ((Movie) distrib.getJohnList().get(i)).getId();
      
      for (int i = 0; i < holder.brusIds.length; i++)
        holder.brusIds[i] = ((Movie) distrib.getBrusList().get(i)).getId();
      
      return holder;
    }
    
    
    public void testDistributor() {
      
      final int NUM_MOVIES = 3;
      Movie [] movies = new Movie[NUM_MOVIES];
      
      for (int i = 0; i < NUM_MOVIES; i++)
        movies[i] = new Movie(i, 0, 0);
      
      TheMoviesLevelThreeDivTwo.Distributor distrib =
        new TheMoviesLevelThreeDivTwo.Distributor(movies);
      

      IdHolder holder;

      assertTrue(distrib.next());
      holder = getIds(distrib);

      assertTrue(Arrays.equals(new int [] {0, 1, 2}, holder.johnIds));
      assertTrue(Arrays.equals(new int [] {}, holder.brusIds));
      
      assertTrue(distrib.next());
      holder = getIds(distrib);

      assertTrue(Arrays.equals(new int [] {1, 2}, holder.johnIds));
      assertTrue(Arrays.equals(new int [] {0}, holder.brusIds));
      
      assertTrue(distrib.next());
      holder = getIds(distrib);

      assertTrue(Arrays.equals(new int [] {0, 2}, holder.johnIds));
      assertTrue(Arrays.equals(new int [] {1}, holder.brusIds));
      
      assertTrue(distrib.next());
      holder = getIds(distrib);

      assertTrue(Arrays.equals(new int [] {2}, holder.johnIds));
      assertTrue(Arrays.equals(new int [] {0, 1}, holder.brusIds));
      
      assertTrue(distrib.next());
      holder = getIds(distrib);

      assertTrue(Arrays.equals(new int [] {0, 1}, holder.johnIds));
      assertTrue(Arrays.equals(new int [] {2}, holder.brusIds));

      
      assertTrue(distrib.next());
      holder = getIds(distrib);

      assertTrue(Arrays.equals(new int [] {1}, holder.johnIds));
      assertTrue(Arrays.equals(new int [] {0, 2}, holder.brusIds));

      assertTrue(distrib.next());
      holder = getIds(distrib);

      assertTrue(Arrays.equals(new int [] {0}, holder.johnIds));
      assertTrue(Arrays.equals(new int [] {1, 2}, holder.brusIds));

      assertTrue(distrib.next());
      holder = getIds(distrib);

      assertTrue(Arrays.equals(new int [] {}, holder.johnIds));
      assertTrue(Arrays.equals(new int [] {0, 1, 2}, holder.brusIds));
      
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
