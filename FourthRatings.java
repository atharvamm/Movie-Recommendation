import java.util.*;
/**
 * Write a description of FourthRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FourthRatings {

    ///***
    private double getAverageByID(String id,int minimalRaters){
        ArrayList<Double> ind_ratings=new ArrayList<Double>();
        double avg_rat=0.0;
        for(Rater curr_id:RaterDatabase.getRaters()){
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
    private Double dotProduct(Rater me,Rater r){
        double product=0.0 ;
        //ArrayList<Rating> rme=me.getRated();ArrayList<Rating> rr=r.getRated();
        ArrayList<String> movies=MovieDatabase.filterBy(new TrueFilter());
        for (String m:movies){
            if(me.hasRating(m) && r.hasRating(m)){
                double me_rate=me.getRating(m)-5.0;
                double r_rate=r.getRating(m)-5.0;
                product+=(me_rate*r_rate);
            }
        }
        return product;
    }
    private ArrayList<Rating> getSimilarities(String id){
        ArrayList<Rating> list=new ArrayList<Rating>();
        Rater me=RaterDatabase.getRater(id);
        for(Rater r:RaterDatabase.getRaters()){
            if (r!=me){
                double temp=dotProduct(me,r);
                if(temp>0){
                    list.add(new Rating(r.getID(),temp));
                }
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        return list;
    }
    public ArrayList<Rating> getSimilarRatings(String id,int numSimilarRaters,int minimalRaters){
        ArrayList<Rating> list=new ArrayList<Rating>();
        ArrayList<String> movies=MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> similar=getSimilarities(id);double avg_rat=0.0;
        HashMap<String,ArrayList<Double>> hash = new HashMap<String,ArrayList<Double>>();
        ///**
        ArrayList<Rating> usesimilar=new ArrayList<Rating>(); 
        for(int i=0;i<numSimilarRaters;i++){usesimilar.add(similar.get(i));}
        for(String m:movies){
            ArrayList<Double> ind_rating=new ArrayList<Double>();
            for(Rating i:usesimilar){
                String use=i.getItem();
                if(RaterDatabase.getRater(use).hasRating(m)){
                    double rating_i=RaterDatabase.getRater(use).getRating(m);
                    ind_rating.add(i.getValue()*rating_i);
                }
            }
            hash.put(m,ind_rating);
        }
         //  */
        /**
          for(String m:movies){
            ArrayList<Double> ind_rating=new ArrayList<Double>();
            for(int i=numSimilarRaters;i>0;i--){
                String use=similar.get(i).getItem();
                if(RaterDatabase.getRater(use).hasRating(m)){
                    double rating_i=RaterDatabase.getRater(use).getRating(m);
                    ind_rating.add(similar.get(i).getValue()*rating_i);
                }
            }
            hash.put(m,ind_rating);
        }
        */
        for(String s:hash.keySet()){
            if(hash.get(s).size()>=minimalRaters){  
                avg_rat=0.0;
                for(double cur_rat:hash.get(s)){
                      avg_rat+=cur_rat;
                    }
                avg_rat=avg_rat/(hash.get(s).size());      
                if(!list.contains(s)){  
                  list.add(new Rating(s,avg_rat));
                }
            }    
        }
        Collections.sort(list,Collections.reverseOrder());
        return list;
    }
    public ArrayList<Rating> getSimilarRatingsByFilter(String id,int numSimilarRaters,int minimalRaters,Filter filterCriteria){
        ArrayList<Rating> list=new ArrayList<Rating>();
        ArrayList<String> movies=MovieDatabase.filterBy(filterCriteria);
        ArrayList<Rating> similar=getSimilarities(id);double avg_rat=0.0;
        HashMap<String,ArrayList<Double>> hash = new HashMap<String,ArrayList<Double>>();
        for(String m:movies){
            ArrayList<Double> ind_rating=new ArrayList<Double>();
            for(int i=0;i<numSimilarRaters;i++){
                String use=similar.get(i).getItem();
                if(RaterDatabase.getRater(use).hasRating(m)){
                    double rating_i=RaterDatabase.getRater(use).getRating(m);
                    ind_rating.add(similar.get(i).getValue()*rating_i);
                }
            }
            hash.put(m,ind_rating);
        }
        for(String s:hash.keySet()){           
            if(hash.get(s).size()>=minimalRaters){
                  avg_rat=0.0;
                  for(double cur_rat:hash.get(s)){
                      avg_rat+=cur_rat;
                    }
                  avg_rat=avg_rat/(hash.get(s).size());  
                }
            if(!list.contains(s)){  
                  list.add(new Rating(s,avg_rat));
                }  
        }
        Collections.sort(list,Collections.reverseOrder());
        
        return list;
    }
}

//System.out.println();