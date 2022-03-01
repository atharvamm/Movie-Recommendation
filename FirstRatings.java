import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;

public class FirstRatings {
        public ArrayList<Movie> loadMovies(String filename){
            FileResource fr=new FileResource(filename);
            CSVParser parse=fr.getCSVParser();
            ArrayList<Movie> movie_arraylist=new ArrayList<Movie>();
            for (CSVRecord record:parse)
            {   
                String id=record.get(0);
                String title= record.get(1);
                String year=record.get(2);
                String country=record.get(3);
                String genre=record.get(4);
                String director=record.get(5);
                int minute=Integer.parseInt(record.get(6));
                String poster=record.get(7);
                Movie temp=new Movie(id,title,year,genre,director,country,poster,minute);
                movie_arraylist.add(temp);
            }
            return movie_arraylist;        
        }
        public void testLoadMovies(){
            //Rated Movies CSV file:ratedmovies_short.csv,ratedmovies.csv
            //Ratings CSV file:ratings_short.csv,ratings.csv
            //ArrayList<Movie> load_movies=loadMovies("data/ratedmovies_short.csv");
            ArrayList<Movie> load_movies=loadMovies("data/ratedmovies.csv");
            int comedy_movies=0;int greater_than_150min=0;int max_directormov=0;
            HashMap<String,Integer> director_moviecount=new HashMap<String,Integer>(); 
            for (Movie movie:load_movies){
                //System.out.println(movie.toString());
                if(movie.getGenres().contains("Comedy")){comedy_movies++;}
                if(movie.getMinutes()>150){greater_than_150min++;}
                String[] directors_thismovie=movie.getDirector().split(",");
                for (String director:directors_thismovie){
                    if(director_moviecount.containsKey(director)){director_moviecount.put(director,director_moviecount.get(director)+1);}
                    else{director_moviecount.put(director,1);}
                }
                int i=0;String director_name=null;
                for (String director:director_moviecount.keySet()){
                    if(i==0){max_directormov=director_moviecount.get(director);}
                    else{
                        if(max_directormov<director_moviecount.get(director)){
                            max_directormov=director_moviecount.get(director);
                            //System.out.println(director_name=director.toString());
                        }
                    }
                    i++;
                }
            }
            System.out.println("The number of movies are : "+load_movies.size());
            System.out.println("The number of movies with comedy genre are : "+comedy_movies);
            System.out.println("The number of movies with length greater than 150 min. are : "+greater_than_150min);
            System.out.println("The max. number of movies by a director are : "+max_directormov+". Number of uniques directors: "+director_moviecount.size());
        }
        /**
         * The load Raters function when the parser is loaded twice to check whether the id has been added.
           */
       /**
        public ArrayList<Rater> loadRaters(String filename){
            long start=System.currentTimeMillis();
            FileResource fr=new FileResource(filename);
            CSVParser parse=fr.getCSVParser();
            ArrayList<Rater> rater_arraylist=new ArrayList<Rater>();
            ArrayList<String> rater_ids=new ArrayList<String>(); 
            for (CSVRecord parser:parse){
                String rater_id=parser.get(0);
                if(!rater_ids.contains(rater_id)){
                    rater_ids.add(rater_id);
                    Rater temp=new Rater(rater_id);
                    //FileResource fr2=new FileResource(filename);
                    CSVParser parse2=fr.getCSVParser();
                    for(CSVRecord sec_parser:parse2){
                      if(temp.getID().compareTo(sec_parser.get(0))==0){
                        String movie_id=sec_parser.get(1);
                        String rating=sec_parser.get(2);
                        String time=sec_parser.get(3);
                        if(!temp.hasRating(movie_id)){
                            temp.addRating(movie_id,Double.parseDouble(rating));
                        }
                      }
                      else{
                          continue;
                      }  
                    }
                    rater_arraylist.add(temp);
                }
                else{
                     continue;
                }
            }
            long end=System.currentTimeMillis();
            System.out.println("The time taken to complete this function with 2 parsers is : "+(end-start));
            return rater_arraylist;
        }
        */
       /**
         * The load Raters function when hashmap is used.This function with Hashmap is quicker.The previous function takes about 7000 ms whereas this one takes 25 ms.
           */
       ///**   
        public ArrayList<Rater> loadRaters(String filename){
            long start=System.currentTimeMillis();
            FileResource fr=new FileResource(filename);
            CSVParser parse=fr.getCSVParser();
            ArrayList<Rater> rater_arraylist=new ArrayList<Rater>();
            HashMap<String,Rater> hash_rater=new HashMap<String,Rater>();             
            for (CSVRecord parser:parse){
                String rater_id=parser.get(0);
                String movie_id=parser.get(1);
                String rating=parser.get(2);
                String time=parser.get(3);
                if(!hash_rater.containsKey(rater_id)){
                    Rater temp=new EfficientRater(rater_id);
                    if(!temp.hasRating(movie_id)){
                            temp.addRating(movie_id,Double.parseDouble(rating));
                        }
                    hash_rater.put(rater_id,temp);
                    rater_arraylist.add(temp);
                }
                else{
                    Rater temp=hash_rater.get(rater_id);
                    if(!temp.hasRating(movie_id)){
                            temp.addRating(movie_id,Double.parseDouble(rating));
                        }
                    //rater_arraylist.add(temp);
                }
            
            }
            //System.out.println("The arraylist is :"+rater_arraylist.toString());
            long end=System.currentTimeMillis();
            //System.out.println("The time taken to complete this function with hashmap is : "+(end-start));
            return rater_arraylist;
        } 
       // */
        public void testLoadRaters(){
            //Rated Movies CSV file:ratedmovies_short.csv,ratedmovies.csv
            //Ratings CSV file:ratings_short.csv,ratings.csv
            //ArrayList<Rater> load_rater=loadRaters("data/ratings_short.csv");
            ArrayList<Rater> load_rater=loadRaters("data/ratings.csv");
            System.out.println("The total number of raters are: "+load_rater.size());
            /**
            for(Rater id:load_rater){
                System.out.println("ID: "+id.getID()+"; No. of ratings: "+id.numRatings()+" and rated are: "+id.getRated().toString());
            }
            */
            String id_given="193";
            
            for(Rater id:load_rater){
                if(id.getID().compareTo(id_given)==0){
                    System.out.println("The no. of ratings by: "+id.getID()+" are: "+id.numRatings());break;
                }
            }
            
            int max_ratings=0;
            ArrayList<String> id_maxratings=new ArrayList<String>();
            for (int k=0;k<load_rater.size();k++){
                int cur_rating=load_rater.get(k).numRatings();
                if(k==0){max_ratings=cur_rating;}
                else{
                    if(max_ratings<cur_rating){max_ratings=cur_rating;}
                    String other_id=load_rater.get(k).getID();
                    if(max_ratings==cur_rating){if(!id_maxratings.contains(other_id)){id_maxratings.add(other_id);}}
                }
            }
            System.out.println("The max ratings is: "+max_ratings+" and the ids are: "+id_maxratings.toString());
            
            String ratings_movie="1798709";int movie_rates=0;ArrayList<String> id_rated=new ArrayList<String>();
            for(Rater id:load_rater){
                if(id.hasRating(ratings_movie)){
                    //System.out.println();
                    id_rated.add(id.getID());
                    movie_rates++;
                }
            }
            //System.out.println("The id_rated: "+id_rated.toString());
            System.out.println("The movie id is: "+ratings_movie+" the number of times it was rated: "+movie_rates);//+" respective id's are: "+id_rated.toString());
            
            int no_movies_rated_tot=0;ArrayList<String> unique_movies=new ArrayList<String>();
            for(Rater id:load_rater){
                ArrayList<Rating> temp=id.getRated();
                for (Rating r:temp){
                    if(!unique_movies.contains(r.getItem())){unique_movies.add(r.getItem());no_movies_rated_tot++;}
                    
                }
            }
            System.out.println("The number of unique movies rated are: "+no_movies_rated_tot+"");
        }
}
/**
 * System.out.println();
 */