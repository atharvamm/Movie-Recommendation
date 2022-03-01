
/**
 * Write a description of MinutesFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinutesFilter implements Filter {
    private int min_time;
    private int max_time;
    public MinutesFilter(int min,int max){
        min_time=min;
        max_time=max;
    }
    
    @Override
	public boolean satisfies(String id) {
	    int minutes=MovieDatabase.getMinutes(id);
	    if(minutes>=min_time & minutes<=max_time){
	        return true;
	       }
	    return false;
	   }

}
