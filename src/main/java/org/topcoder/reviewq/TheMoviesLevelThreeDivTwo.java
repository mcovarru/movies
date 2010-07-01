package org.topcoder.reviewq;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * SRM 469 Div 2
 * 
 * @author mcovarru
 *
 */
public class TheMoviesLevelThreeDivTwo 
{
    public static class Movie {
      public int id;
      public int johnTime;
      public int brusTime;

      public int getId() {
        return id;
      }

      public int getJohnTime() {
        return johnTime;
      }

      public int getBrusTime() {
        return brusTime;
      }

      public Movie (int id, int john, int brus) {
        this.id = id;
        this.johnTime = john;
        this.brusTime = brus;
      }
      
      public boolean equals(Object o) {
        Movie other = (Movie) o;
        return id == other.id;
      }
      
      public int hashCode() {
        return id;
      }
      
    }
    

    public static class Distribution {
      private List<Movie> johnList = new ArrayList<Movie>();
      private List<Movie> brusList = new ArrayList<Movie>();
      
      public List<Movie> getJohnList() {
        return johnList;
      }

      public List<Movie> getBrusList() {
        return brusList;
      }
      
      public boolean works() {
        return false;
      }      
      
    }
    
    
    public static class Distributor implements Iterable<Distribution> {
      
      private Movie[] canonicalMovies;
      

      private long numDistributions;
            
            
      public Distributor(Movie [] canonicalMovies) {
        this.canonicalMovies = canonicalMovies;
        
        // calculate this once, doing Math.pow all the time can't 
        // be efficient and it's not like the answer changes
        this.numDistributions = Math.round(Math.pow(2, this.canonicalMovies.length));
      }
      
      private long current = 0;
      

      public Iterator<Distribution> iterator() {
       
        return new Iterator<Distribution>() {

          public boolean hasNext() {
            return current < numDistributions;
          }

          public Distribution next() {
            if (current >= numDistributions) 
              throw new RuntimeException("no more distributions!");
            

            Distribution distribution = new Distribution();
            
            for (int i = 0; i < canonicalMovies.length; i++) {
              if ((current & (1 << i)) == 0)
                distribution.getJohnList().add(canonicalMovies[i]);
              else
                distribution.getBrusList().add(canonicalMovies[i]);
              
            }
            
            current++;
            return distribution;          }

          public void remove() {
            throw new UnsupportedOperationException("remove not implemented");
          }
          
        };
      }
      
    }




   
    public int find(int [] john, int [] brus) {
      

      Movie [] movies = new Movie[john.length]; 
      for (int i = 0; i < john.length; i++)
        movies[i] = new Movie(i, john[i], brus[i]);
      
      int working = 0;
      
      for (Distribution dist : new Distributor(movies)) {
        if (dist.works())
          working++;
      }
      
      return working;
    }
}
