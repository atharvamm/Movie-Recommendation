import java.util.*;
/**
 * Write a description of EfficientRater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EfficientRater implements Rater {
    private String myID;
    //private ArrayList<Rating> myRatings;
    //Change its name to my ratings after done;
    //Key:ID;Value:Rating
    private HashMap<String,Rating> my;
    public EfficientRater(String id) {
        myID = id;
        my = new HashMap<String,Rating>();
    }
    public void addRating(String item, double rating) {
        //myRatings.add(new Rating(item,rating));
        my.put(item,new Rating(item,rating));
    }
    public boolean hasRating(String item) {
        /**
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return true;
            }            
        }
        */
        if(my.containsKey(item)){
                return true;
            }
        return false;
    }
    public String getID() {
        return myID;
    }
    /**Adding an extra method to get myRatings arraylist*/
    public ArrayList<Rating> getRated(){
        ArrayList<Rating> list=new ArrayList<Rating>();
        for(String item:my.keySet()){
           list.add(my.get(item));
        }
        return list;
        //Earlier it returned the ArrayList
        }
    public double getRating(String item) {
        /**
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return myRatings.get(k).getValue();
            }
        }
        */
        if(my.containsKey(item)){
                return my.get(item).getValue();
            }
        return -1;
    }
    public int numRatings() {
        return my.size();
        //Earlier it was Arraylist size
    }
    /**
    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(int k=0; k < myRatings.size(); k++){
            list.add(myRatings.get(k).getItem());
        }
        return list;
    }
    */
   //Send rated items as list so now send HashMap
   public ArrayList<String> getItemsRated(){
       ArrayList<String> list = new ArrayList<String>();
       for(String item:my.keySet()){
           list.add(item);
        }
       return list;
    }
}

