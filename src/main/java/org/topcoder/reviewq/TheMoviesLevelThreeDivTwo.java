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
    

    
    public static class Distributor {
      
      private Movie[] canonicalMovies;
            
      public Distributor(Movie [] canonicalMovies) {
        this.canonicalMovies = canonicalMovies;  
      }
      
      private long current = 0;
      
      private List johnList;
      
      private List brusList;
      
      public List getJohnList() {
        return johnList;
      }

      public List getBrusList() {
        return brusList;
      }

      public boolean next() {
        
        if (current == Math.pow(2, canonicalMovies.length)) return false;
        
        johnList = new ArrayList();
        brusList = new ArrayList();
        
        for (int i = 0; i < canonicalMovies.length; i++) {
          if ((current & (1 << i)) == 0)
            johnList.add(canonicalMovies[i]);
          else
            brusList.add(canonicalMovies[i]);
          
        }
        
        current++;
        return true;
        
      }
      
    }



    
    
    public Movie[] worksHelper(Movie [] movies, int i, int depth) {
      if (depth == movies.length) return movies;
      movies[depth] = movies[i % movies.length];
      return worksHelper(movies, i + 1, depth + 1);

    }
    
    
    public int find(int [] john, int [] brus) {
      

      Movie [] movies = new Movie[john.length]; 
      for (int i = 0; i < john.length; i++)
        movies[i] = new Movie(i, john[i], brus[i]);

      Distributor distributor = new Distributor(movies);
      return 3;
    }
}
