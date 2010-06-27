package test.org.topcoder.reviewq;

import org.topcoder.reviewq.TheMoviesLevelThreeDivTwo;

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
