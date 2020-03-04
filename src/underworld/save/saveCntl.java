package underworld.save;

/**
 *
 * @author Jeffrey Oh
 */
public class saveCntl {
    //variables and instances
    String tempName;
    int tempCharType;

    public String getTempName() {
        return tempName;
    }

    public int getTempCharType() {
        return tempCharType;
    }
    
    //constructor   
    public saveCntl(){
        
    }
    
    public void setNameAndType(String name, int cType){
        tempName = name;
        tempCharType = cType;
    }
    
    
}
