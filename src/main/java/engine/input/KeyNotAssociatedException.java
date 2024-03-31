package engine.input;

public class KeyNotAssociatedException extends Exception {

    public KeyNotAssociatedException(String msg){
        super(msg);
    }
    
    public KeyNotAssociatedException(){
        super();
    }

}
