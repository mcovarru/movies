package test.org.topcoder.horror;

import java.util.Arrays;

import org.topcoder.horror.TheMoviesLevelTwoDivOne;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TheMoviesLevelTwoDivOneTest 
    extends TestCase
{
    private TheMoviesLevelTwoDivOne movieTester;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TheMoviesLevelTwoDivOneTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TheMoviesLevelTwoDivOneTest.class );
    }
    
    
    public void setUp() {
      this.movieTester = new TheMoviesLevelTwoDivOne();
    }
    
    public void tearDown() {
      this.movieTester = null;
    }

    /**
     * 
     */
    public void testWorks()
    {
      TheMoviesLevelTwoDivOne.Movie movie;
      
      movie = new TheMoviesLevelTwoDivOne.Movie(0, 100, 1);
      
      assertTrue(movie.works(74));
      
      movie = new TheMoviesLevelTwoDivOne.Movie(1, 100, 99);
      assertFalse(movie.works(74));
    }


    public void test0() {
      int [] ret =  movieTester.find(new int [] {100, 50}, new int [] {1, 1});

      assertTrue(Arrays.equals(new int [] {0, 1}, ret));
    }

    public void test1() {
      int [] ret =  movieTester.find(new int [] {100, 50}, new int [] {1, 49});

      assertTrue(Arrays.equals(new int [] {1, 0}, ret));
    }

    public void test2() {
      int [] ret =  movieTester.find(new int [] {100, 100, 100, 100}, new int [] {77, 76, 75, 74});

      assertTrue(Arrays.equals(new int [] {3, 0, 1, 2}, ret));
    }

    public void test3() {
      int [] ret =  movieTester.find(new int [] {100}, new int [] {99});

      assertTrue(Arrays.equals(new int [] {0}, ret));
    }    
}
