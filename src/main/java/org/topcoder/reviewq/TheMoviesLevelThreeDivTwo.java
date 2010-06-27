package org.topcoder.reviewq;


public class TheMoviesLevelThreeDivTwo 
{
    public static class Movie {
      public int id;
      public int johnTime;
      public int brusTime;

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
    
    
    public int find(int [] john, int [] brus) {
      return 0;
    }
}
