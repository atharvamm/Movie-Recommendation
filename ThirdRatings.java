import java.util.*;
/**
 * Write a description of ThirdRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThirdRatings {
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("data/ratings.csv");
    }
    
    public ThirdRatings(String ratingsfile){
        FirstRatings FR1=new FirstRatings();
        myRaters=FR1.loadRaters(ratingsfile);
    }
    
    public int getRaterSize(){
        int val_raters=myRaters.size();
        return val_raters;
    }
    public void test(){
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
        ArrayList<Rating> list=new ArrayList<Rating>();
        ArrayList<String> movies=MovieDatabase.filterBy(new TrueFilter());
        ///**
        for(String m:movies){
            if(!list.contains(m)){
                double rating=getAverageByID(m,minimalRaters);
                list.add(new Rating(m,rating));
            }
        }
        //*/
        //System.out.println();
        return list;
    }
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters,Filter filterCriteria){
        ArrayList<Rating> ratings=new ArrayList<Rating>();
        ArrayList<String> movies=MovieDatabase.filterBy(filterCriteria);
        for(String m:movies){
            if(!ratings.contains(m)){
                double rating=getAverageByID(m,minimalRaters);
                ratings.add(new Rating(m,rating));
            }
        }
        return ratings;
    }
    //*/
}

