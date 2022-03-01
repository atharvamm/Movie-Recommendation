import java.util.*;
/**
 * Write a description of MovierunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerWithFilters {
    public void printAverageRatings(){
        //Rated Movies CSV file:data/ratedmovies_short.csv,data/ratedmovies.csv
        //Ratings CSV file:data/ratings_short.csv,data/ratings.csv
        String data_rat="data/ratings.csv";
        ThirdRatings TR1= new ThirdRatings(data_rat);
        System.out.println("The number of raters are :"+TR1.getRaterSize());
        String data_mov="data/ratedmovies.csv";
        MovieDatabase.initialize(data_mov);
        System.out.println("The number of movies are: "+MovieDatabase.size());                                  
        int minimalRaters=35;
        //int minimalRaters=50;
        //int minimalRaters=20;
        //int minimalRaters=12;
        ArrayList<Rating> ratings=TR1.getAverageRatings(minimalRaters);
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
        //System.out.println("The no. of movies found are: "+answer.size());
        System.out.println("Movies with raters greater than "+minimalRaters+" are:"+answer.size());
        for(Rating r:answer){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
        }
    }
    public void printAverageRatingByYear(){
        //Rated Movies CSV file:data/ratedmovies_short.csv,data/ratedmovies.csv
        //Ratings CSV file:data/ratings_short.csv,data/ratings.csv
        String data_rat="data/ratings.csv";
        ThirdRatings TR1= new ThirdRatings(data_rat);
        System.out.println("The number of raters are :"+TR1.getRaterSize());
        String data_mov="data/ratedmovies.csv";
        MovieDatabase.initialize(data_mov);
        System.out.println("The number of movies are: "+MovieDatabase.size());                                  
        //int minimalRaters=1;
        //int minimalRaters=50;
        int minimalRaters=20;
        //int minimalRaters=12;
        int year=2000;
        YearAfterFilter yf=new YearAfterFilter(year);
        ArrayList<Rating> ratings=TR1.getAverageRatingsByFilter(minimalRaters,yf);
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
        //System.out.println("The no. of movies found are: "+answer.size());
        System.out.println("Movies with raters greater than "+minimalRaters+" are: "+answer.size());
        for(Rating r:answer){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
        }
    }
    public void printAverageRatingByGenre(){
        //Rated Movies CSV file:data/ratedmovies_short.csv,data/ratedmovies.csv
        //Ratings CSV file:data/ratings_short.csv,data/ratings.csv
        String data_rat="data/ratings.csv";
        ThirdRatings TR1= new ThirdRatings(data_rat);
        System.out.println("The number of raters are :"+TR1.getRaterSize());
        String data_mov="data/ratedmovies.csv";
        MovieDatabase.initialize(data_mov);
        System.out.println("The number of movies are: "+MovieDatabase.size());                                  
        //int minimalRaters=1;
        //int minimalRaters=50;
        int minimalRaters=20;
        //int minimalRaters=12;
        String genre="Comedy";
        GenreFilter gf=new GenreFilter(genre);
        ArrayList<Rating> ratings=TR1.getAverageRatingsByFilter(minimalRaters,gf);
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
        //System.out.println("The no. of movies found are: "+answer.size());
        System.out.println("Movies with raters greater than "+minimalRaters+" are: "+answer.size());
        for(Rating r:answer){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
        }
    }
    public void printAverageRatingByMinutes(){
        //Rated Movies CSV file:data/ratedmovies_short.csv,data/ratedmovies.csv
        //Ratings CSV file:data/ratings_short.csv,data/ratings.csv
        String data_rat="data/ratings.csv";
        ThirdRatings TR1= new ThirdRatings(data_rat);
        System.out.println("The number of raters are :"+TR1.getRaterSize());
        String data_mov="data/ratedmovies.csv";
        MovieDatabase.initialize(data_mov);
        System.out.println("The number of movies are: "+MovieDatabase.size());                                  
        int minimalRaters=5;
        //int minimalRaters=50;
        //int minimalRaters=20;
        //int minimalRaters=12;
        int min=105;int max=135;
        MinutesFilter mf=new MinutesFilter(min,max);
        ArrayList<Rating> ratings=TR1.getAverageRatingsByFilter(minimalRaters,mf);
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
        //System.out.println("The no. of movies found are: "+answer.size());
        for(Rating r:answer){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
            System.out.println("Time: "+MovieDatabase.getMinutes(r.getItem()));
        }
        System.out.println("Movies with raters greater than "+minimalRaters+" are: "+answer.size());
    }
    public void printAverageRatingByDirectors(){
        //Rated Movies CSV file:data/ratedmovies_short.csv,data/ratedmovies.csv
        //Ratings CSV file:data/ratings_short.csv,data/ratings.csv
        String data_rat="data/ratings.csv";
        ThirdRatings TR1= new ThirdRatings(data_rat);
        System.out.println("The number of raters are :"+TR1.getRaterSize());
        String data_mov="data/ratedmovies.csv";
        MovieDatabase.initialize(data_mov);
        System.out.println("The number of movies are: "+MovieDatabase.size());                                  
        int minimalRaters=4;
        //int minimalRaters=50;
        //int minimalRaters=20;
        //int minimalRaters=12;
        String directors="Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack";
        DirectorsFilter df=new DirectorsFilter(directors);
        ArrayList<Rating> ratings=TR1.getAverageRatingsByFilter(minimalRaters,df);
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
        //System.out.println("The no. of movies found are: "+answer.size());
        for(Rating r:answer){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
            System.out.println("Directors: "+MovieDatabase.getDirector(r.getItem()));
        }
        System.out.println("Movies with raters greater than "+minimalRaters+" are: "+answer.size());
    }
    public void printAverageRatingByYearAfterAndGenre(){
        //Rated Movies CSV file:data/ratedmovies_short.csv,data/ratedmovies.csv
        //Ratings CSV file:data/ratings_short.csv,data/ratings.csv
        String data_rat="data/ratings.csv";
        ThirdRatings TR1= new ThirdRatings(data_rat);
        System.out.println("The number of raters are :"+TR1.getRaterSize());
        String data_mov="data/ratedmovies.csv";
        MovieDatabase.initialize(data_mov);
        System.out.println("The number of movies are: "+MovieDatabase.size());                                  
        int minimalRaters=8;
        //int minimalRaters=50;
        //int minimalRaters=20;
        //int minimalRaters=12;
        AllFilters af=new AllFilters();
        String genre="Drama";
        GenreFilter gf=new GenreFilter(genre);
        int year=1990;
        YearAfterFilter yf=new YearAfterFilter(year);
        af.addFilter(gf);af.addFilter(yf);
        ArrayList<Rating> ratings=TR1.getAverageRatingsByFilter(minimalRaters,af);
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
        //System.out.println("The no. of movies found are: "+answer.size());
        for(Rating r:answer){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
            System.out.println("Genre: "+MovieDatabase.getGenres(r.getItem()));
            System.out.println("Year: "+MovieDatabase.getYear(r.getItem()));
        }
        System.out.println("Movies with raters greater than "+minimalRaters+" are: "+answer.size());
    }
    public void printAverageRatingByDirectorsAndMinutes(){
        //Rated Movies CSV file:data/ratedmovies_short.csv,data/ratedmovies.csv
        //Ratings CSV file:data/ratings_short.csv,data/ratings.csv
        String data_rat="data/ratings.csv";
        ThirdRatings TR1= new ThirdRatings(data_rat);
        System.out.println("The number of raters are :"+TR1.getRaterSize());
        String data_mov="data/ratedmovies.csv";
        MovieDatabase.initialize(data_mov);
        System.out.println("The number of movies are: "+MovieDatabase.size());                                  
        int minimalRaters=3;
        //int minimalRaters=50;
        //int minimalRaters=20;
        //int minimalRaters=12;
        AllFilters af=new AllFilters();
        int min=90;int max=180;
        MinutesFilter mf=new MinutesFilter(min,max);
        String directors="Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack";
        DirectorsFilter df=new DirectorsFilter(directors);
        af.addFilter(mf);af.addFilter(df);
        ArrayList<Rating> ratings=TR1.getAverageRatingsByFilter(minimalRaters,af);
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
        //System.out.println("The no. of movies found are: "+answer.size());   
        for(Rating r:answer){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
            System.out.println("Directors: "+MovieDatabase.getDirector(r.getItem()));
            System.out.println("Minute: "+MovieDatabase.getMinutes(r.getItem()));
        }
        System.out.println("Movies with raters greater than "+minimalRaters+" are: "+answer.size());
    }
}
