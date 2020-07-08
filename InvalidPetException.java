public class InvalidPetException extends RuntimeException {
    public final String s;
    public InvalidPetException(){
        this("Your pet is invalid!");
    }
    public InvalidPetException(String s){
        this.s = s;
    }  
}