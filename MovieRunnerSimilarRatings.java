import java.util.*;
/**
 * Write a description of MovieRunnerSimilarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerSimilarRatings {
    public void printAverageRatings(){
        //Rated Movies CSV file:data/ratedmovies_short.csv,data/ratedmovies.csv
        //Ratings CSV file:data/ratings_short.csv,data/ratings.csv
        String data_rat="data/ratings.csv";
        FourthRatings FR1= new FourthRatings();
        RaterDatabase.initialize(data_rat);
        String data_mov="data/ratedmovies.csv";
        MovieDatabase.initialize(data_mov);                                  
        System.out.println("The number of movies are: "+MovieDatabase.size());
        System.out.println("The number of raters are: "+RaterDatabase.size());
        int minimalRaters=35;
        //int minimalRaters=50;
        //int minimalRaters=20;
        //int minimalRaters=12;
        ArrayList<Rating> ratings=FR1.getAverageRatings(minimalRaters);
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
    public void printAverageRatingByYearAfterAndGenre(){
        //Rated Movies CSV file:data/ratedmovies_short.csv,data/ratedmovies.csv
        //Ratings CSV file:data/ratings_short.csv,data/ratings.csv
        String data_rat="data/ratings.csv";
        FourthRatings FR1= new FourthRatings();
        RaterDatabase.initialize(data_rat);
        System.out.println("The number of raters are :"+RaterDatabase.size());
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
        ArrayList<Rating> ratings=FR1.getAverageRatingsByFilter(minimalRaters,af);
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
        System.out.println("The number of raters are :"+RaterDatabase.size());
        
        for(Rating r:answer){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
            System.out.println("Genre: "+MovieDatabase.getGenres(r.getItem()));
            System.out.println("Year: "+MovieDatabase.getYear(r.getItem()));
        }
        System.out.println("Movies with raters greater than "+minimalRaters+" are: "+answer.size());
    }
    public void printSimilarRatings(){
        String data_rat="data/ratings.csv";
        String data_mov="data/ratedmovies.csv";
        RaterDatabase.initialize(data_rat);
        MovieDatabase.initialize(data_mov);
        //System.out.println("The number of raters are :"+RaterDatabase.size());
        //System.out.println("The number of movies are: "+MovieDatabase.size());
        FourthRatings frsr=new FourthRatings();
        String raterId="71";int numSimilarRaters=20;int minimalRaters=5;
        ArrayList<Rating> ratings=frsr.getSimilarRatings(raterId,numSimilarRaters,minimalRaters);
        ArrayList<Rating> answer=new ArrayList<Rating>();
        for(Rating r:ratings){
            if(r.getValue()>0){
                answer.add(r);
            }
        }
        /**
        int count=0;
        for(Rating r:answer){count++;
            //System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
            String title=MovieDatabase.getTitle(r.getItem());
            System.out.println(count+"). "+r.getValue()+" "+title+" "+r.getItem());
            if(title.compareToIgnoreCase("The Fault in Our Stars")==0){break;}
        }
        */
        System.out.println(MovieDatabase.getTitle(answer.get(0).getItem()));
        System.out.println("Movies with raters greater than "+minimalRaters+" and "+
        "top similar: "+numSimilarRaters+" are: "+answer.size());
    }   
    public void printSimilarRatingsByGenre(){
        String data_rat="data/ratings.csv";
        String data_mov="data/ratedmovies.csv";
        RaterDatabase.initialize(data_rat);
        MovieDatabase.initialize(data_mov);
        //System.out.println("The number of raters are :"+RaterDatabase.size());
        //System.out.println("The number of movies are: "+MovieDatabase.size());
        FourthRatings frsr=new FourthRatings();String genre="Mystery";
        String raterId="964";int numSimilarRaters=20;int minimalRaters=5;
        GenreFilter gf=new GenreFilter(genre);
        ArrayList<Rating> ratings=frsr.getSimilarRatingsByFilter(raterId,numSimilarRaters,minimalRaters,gf);
        ArrayList<Rating> answer=new ArrayList<Rating>();
        for(Rating r:ratings){
            if(r.getValue()>0){
                answer.add(r);
            }
        }
        /**
        int count=0;
        for(Rating r:answer){count++;
            //System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
            String title=MovieDatabase.getTitle(r.getItem());
            System.out.println(count+"). "+r.getValue()+" "+title+" "+r.getItem());
            if(title.compareToIgnoreCase("The Fault in Our Stars")==0){break;}
        }
        */
        System.out.println(MovieDatabase.getTitle(answer.get(0).getItem()));
        System.out.println("Movies with raters greater than "+minimalRaters+" and "+
        "top similar: "+numSimilarRaters+" are: "+answer.size());
    }
    public void printSimiliarRatingsByDirector(){
        String data_rat="data/ratings.csv";
        String data_mov="data/ratedmovies.csv";
        RaterDatabase.initialize(data_rat);
        MovieDatabase.initialize(data_mov);
        //System.out.println("The number of raters are :"+RaterDatabase.size());
        //System.out.println("The number of movies are: "+MovieDatabase.size());
        FourthRatings frsr=new FourthRatings();
        String director="Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh";
        String raterId="120";int numSimilarRaters=10;int minimalRaters=2;
        DirectorsFilter df=new DirectorsFilter(director);
        ArrayList<Rating> ratings=frsr.getSimilarRatingsByFilter(raterId,numSimilarRaters,minimalRaters,df);
        ArrayList<Rating> answer=new ArrayList<Rating>();
        for(Rating r:ratings){
            if(r.getValue()>0){
                answer.add(r);
            }
        }
        /**
        int count=0;
        for(Rating r:answer){count++;
            //System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
            String title=MovieDatabase.getTitle(r.getItem());
            System.out.println(count+"). "+r.getValue()+" "+title+" "+r.getItem());
            if(title.compareToIgnoreCase("The Fault in Our Stars")==0){break;}
        }
        */
        System.out.println(MovieDatabase.getTitle(answer.get(0).getItem()));
        System.out.println("Movies with raters greater than "+minimalRaters+" and "+
        "top similar: "+numSimilarRaters+" are: "+answer.size());
    }
    public void printSimilarRatingsByGenreAndMinutes(){
        String data_rat="data/ratings.csv";
        String data_mov="data/ratedmovies.csv";
        RaterDatabase.initialize(data_rat);
        MovieDatabase.initialize(data_mov);
        //System.out.println("The number of raters are :"+RaterDatabase.size());
        //System.out.println("The number of movies are: "+MovieDatabase.size());
        FourthRatings frsr=new FourthRatings();AllFilters af=new AllFilters();
        String raterId="168";int numSimilarRaters=10;int minimalRaters=3;
        String genre="Drama";int min=80;int max=160;
        GenreFilter gf=new GenreFilter(genre);
        MinutesFilter mf = new MinutesFilter(min,max);
        af.addFilter(gf);af.addFilter(mf);
        ArrayList<Rating> ratings=frsr.getSimilarRatingsByFilter(raterId,numSimilarRaters,minimalRaters,af);
        ArrayList<Rating> answer=new ArrayList<Rating>();
        for(Rating r:ratings){
            if(r.getValue()>0){
                answer.add(r);
            }
        }
        /**
        int count=0;
        for(Rating r:answer){count++;
            //System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
            String title=MovieDatabase.getTitle(r.getItem());
            System.out.println(count+"). "+r.getValue()+" "+title+" "+r.getItem());
            if(title.compareToIgnoreCase("The Fault in Our Stars")==0){break;}
        }
        */
        System.out.println(MovieDatabase.getTitle(answer.get(0).getItem()));
        System.out.println("Movies with raters greater than "+minimalRaters+" and "+
        "top similar: "+numSimilarRaters+" are: "+answer.size());
    }
    public void printSimilarRatingsByYearAfterAndMinutes(){
        String data_rat="data/ratings.csv";
        String data_mov="data/ratedmovies.csv";
        RaterDatabase.initialize(data_rat);
        MovieDatabase.initialize(data_mov);
        //System.out.println("The number of raters are :"+RaterDatabase.size());
        //System.out.println("The number of movies are: "+MovieDatabase.size());
        FourthRatings frsr=new FourthRatings();int year=1975;
        String raterId="314";int numSimilarRaters=10;int minimalRaters=5;
        AllFilters af=new AllFilters();
        YearAfterFilter yf=new YearAfterFilter(year);
        int min=70;int max=200;
        MinutesFilter mf=new MinutesFilter(min,max);
        af.addFilter(yf);af.addFilter(mf);
        ArrayList<Rating> ratings=frsr.getSimilarRatingsByFilter(raterId,numSimilarRaters,minimalRaters,af);
        ArrayList<Rating> answer=new ArrayList<Rating>();
        for(Rating r:ratings){
            if(r.getValue()>0){
                answer.add(r);
            }
        }
        /**
        int count=0;
        for(Rating r:answer){count++;
            //System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+" "+r.getItem());
            String title=MovieDatabase.getTitle(r.getItem());
            System.out.println(count+"). "+r.getValue()+" "+title+" "+r.getItem());
            if(title.compareToIgnoreCase("The Fault in Our Stars")==0){break;}
        }
        */
        System.out.println(MovieDatabase.getTitle(answer.get(0).getItem()));
        System.out.println("Movies with raters greater than "+minimalRaters+" and "+
        "top similar: "+numSimilarRaters+" are: "+answer.size());
    }
}
