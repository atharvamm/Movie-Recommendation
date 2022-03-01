import java.util.*;
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerAverage {
    ///**
    public void printAverageRatings(){
        //Rated Movies CSV file:data/ratedmovies_short.csv,data/ratedmovies.csv
        //Ratings CSV file:data/ratings_short.csv,data/ratings.csv
        String data_mov="data/ratedmovies.csv";
        String data_rat="data/ratings.csv";
        SecondRatings SR1= new SecondRatings(data_mov,data_rat);
        System.out.println("The number of movies are :"+SR1.getMovieSize());
        System.out.println("The number of raters are :"+SR1.getRaterSize());
        //int minimalRaters=2;
        //int minimalRaters=50;
        //int minimalRaters=20;
        int minimalRaters=12;
        ArrayList<Rating> ratings=SR1.getAverageRatings(minimalRaters);
        ArrayList<Rating> answer=new ArrayList<Rating>();
        for(int i=0;i<ratings.size()-1;i++){
            for(int j=0;j<ratings.size()-i-1;j++){
                if(ratings.get(j).compareTo(ratings.get(j+1))==1){
                    Rating temp1=ratings.get(j);
                    Rating temp2=ratings.get(j+1);
                    ratings.set(j,temp2);ratings.set(j+1,temp1);
                }
            }
        }
        for(Rating r:ratings){
            if(r.getValue()>0){
                answer.add(r);
            }
        }
        for(Rating r:answer){
            System.out.println(r.getValue()+" "+SR1.getTitle(r.getItem())+" "+r.getItem());
        }
        System.out.println("Movies with raters greater than"+minimalRaters+" are:"+answer.size());
    }
    public void getAverageRatingOneMovie(){
        //Rated Movies CSV file:data/ratedmovies_short.csv,data/ratedmovies.csv
        //Ratings CSV file:data/ratings_short.csv,data/ratings.csv
        String data_mov="data/ratedmovies.csv";
        String data_rat="data/ratings.csv";
        SecondRatings SR2= new SecondRatings(data_mov,data_rat);
        int minimalraters=1;
        //String find="The Maze Runner";
        //String find="Moneyball";
        String find="Vacation";
        ArrayList<Rating> ratings=SR2.getAverageRatings(minimalraters);
        for (Rating r:ratings){
            String temp=SR2.getTitle(r.getItem());
            if(temp.compareToIgnoreCase(find)==0){
                System.out.println(temp+" "+r.getValue());
            }
        }
        //print average ratings for godfather which is 9
    }
    //*/
    //Added to check that data associated with SecondRatings object
    public void testSecondRatingData(){
        //Rated Movies CSV file:data/ratedmovies_short.csv,data/ratedmovies.csv
        //Ratings CSV file:data/ratings_short.csv,data/ratings.csv
        String data_mov="data/ratedmovies_short.csv";
        String data_rat="data/ratings_short.csv";
        SecondRatings testsr= new SecondRatings(data_mov,data_rat);
        testsr.test();
    }
}
