package org.topcoder.reviewq;

import java.util.ArrayList;
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
      private List johnList = new ArrayList();
      private List brusList = new ArrayList();
      
      public List getJohnList() {
        return johnList;
      }

      public List getBrusList() {
        return brusList;
      }
      
    }
    
    
    public static class Distributor {
      
      private Movie[] canonicalMovies;
            
      public Distributor(Movie [] canonicalMovies) {
        this.canonicalMovies = canonicalMovies;  
      }
      
      private long current = 0;
      
      
      public boolean hasNext() {
        return current < Math.pow(2, canonicalMovies.length);
      }
      
      
      public Distribution next() {
        
        if (current >= Math.pow(2, canonicalMovies.length)) 
          throw new RuntimeException("no more distributions!");
        

        Distribution distribution = new Distribution();
        
        for (int i = 0; i < canonicalMovies.length; i++) {
          if ((current & (1 << i)) == 0)
            distribution.getJohnList().add(canonicalMovies[i]);
          else
            distribution.getBrusList().add(canonicalMovies[i]);
          
        }
        
        current++;
        return distribution;
        
      }
      
    }
    

   
    public int find(int [] john, int [] brus) {
      

      Movie [] movies = new Movie[john.length]; 
      for (int i = 0; i < john.length; i++)
        movies[i] = new Movie(i, john[i], brus[i]);

      Distributor distributor = new Distributor(movies);
      return 3;
    }
}
