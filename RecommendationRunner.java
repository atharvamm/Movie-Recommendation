import java.util.*;
/**
 * Write a description of RecommendationRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecommendationRunner implements Recommender {
    public ArrayList<String> getItemsToRate(){
        ArrayList<String> list=new ArrayList<String>();
        int year=2010;
        YearAfterFilter yf=new YearAfterFilter(year);
        String data_mov="data/ratedmovies.csv";
        MovieDatabase.initialize(data_mov);
        ArrayList<String> movies=MovieDatabase.filterBy(yf);
        for(int i=0;i<10;i++){
            list.add(movies.get(i));
        }
        return list;
    }
    public void printRecommendationsFor(String webRatedID){
        FourthRatings fr= new FourthRatings();
        String data_rat="data/ratings.csv";
        RaterDatabase.initialize(data_rat);
        String data_mov="data/ratedmovies.csv";
        MovieDatabase.initialize(data_mov);
        ArrayList<Rating> ratings=fr.getSimilarRatings(webRatedID,10,2);
       System.out.println("<!DOCTYPE html><html><head><body> ");
       System.out.println("<h3>Recommendation System</h3>");
       if(ratings.size()==0){
           System.out.println("<h1>No ratings were submitted - No movie recommendation of your choice!</h1>"); 
        }
       else{   int i=0;  
       System.out.print("<table>");
       for(Rating rating: ratings){
           String obj=rating.getItem();
           String genres=MovieDatabase.getGenres(obj);
           int year=MovieDatabase.getYear(obj);
           if(i < 10){ System.out.print("<tr><td><h3>"+(i+1)+")</td><td>"+" "+MovieDatabase.getTitle(obj)+
               "</td><td>"+" "+MovieDatabase.getMinutes(obj)+
               "</td><td>"+" "+genres+
               "</td><td>"+" "+year+"</td>");
               System.out.println("</h3></td></tr>");

               i++; 
            }

            else break;
       }  
       System.out.println("</table></body></html>");
       
    }
     
    }
}
