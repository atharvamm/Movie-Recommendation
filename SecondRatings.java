
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("data/ratedmovies.csv", "data/ratings.csv");
    }
    public SecondRatings(String moviefile,String ratingsfile){
        FirstRatings FR1=new FirstRatings();
        myMovies=FR1.loadMovies(moviefile);
        myRaters=FR1.loadRaters(ratingsfile);
    }
    public int getMovieSize(){
        int val_movies=myMovies.size();
        return val_movies;
    }
    public int getRaterSize(){
        int val_raters=myRaters.size();
        return val_raters;
    }
    public void test(){
        System.out.println("myMovies"+myMovies.toString());
        System.out.println("myRaters"+myRaters.toString());
    }
    ///***
    private double getAverageByID(String id,int minimalRaters){
        ArrayList<Double> ind_ratings=new ArrayList<Double>();
        double avg_rat=0.0;
        for(Rater curr_id:myRaters){
            if(curr_id.hasRating(id)){
                ind_ratings.add(curr_id.getRating(id));
            }
        }
        if(ind_ratings.size()>=minimalRaters){
            for(double cur_rat:ind_ratings){
                avg_rat+=cur_rat;
            }
            return avg_rat/(ind_ratings.size());
        }
        return avg_rat;
    }
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> stored=new ArrayList<Rating>();
        for(Movie m:myMovies){
            if(!stored.contains(m.getID())){
                double rating=getAverageByID(m.getID(),minimalRaters);
                stored.add(new Rating(m.getID(),rating));
            }
        }
        return stored;
    }
    public String getTitle(String id){
        for(Movie check:myMovies){
            if(check.getID().compareTo(id)==0){
            return check.getTitle();    
            }
        }
        return "ID was not found";
    }
    public String getId(String title){
        for(Movie check:myMovies){
            if(check.getTitle().compareTo(title)==0){
            return check.getID();    
            }
        }
        return "NO SUCH TITLE";
    }
    //*/
}
