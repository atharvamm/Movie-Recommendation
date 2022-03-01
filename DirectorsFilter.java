/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectorsFilter implements Filter {
    private String director;
    public DirectorsFilter(String dir){
        director=dir;            
    }   
    @Override
    public boolean satisfies(String id) {
        String[] every_dir=director.split(",");
        String all_directors=MovieDatabase.getDirector(id);
        for(String temp:every_dir){
        if(all_directors.contains(temp)){
            return true;
           }
        }
        return false;
       }

}