
/**
 * Write a description of Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main {
    public static void main(String args[]){
     MovieRunnerSimilarRatings mrsr=new MovieRunnerSimilarRatings();
     mrsr.printSimilarRatings();
     //mrsr.printSimilarRatingsByGenre();
     mrsr.printSimiliarRatingsByDirector();
     mrsr.printSimilarRatingsByGenreAndMinutes();
     mrsr.printSimilarRatingsByYearAfterAndMinutes();
    }
}
