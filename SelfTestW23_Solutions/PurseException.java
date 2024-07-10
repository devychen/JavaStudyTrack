public class PurseException extends Exception {
    
    public PurseException() {
        super("Purse Error");
    }
    
    public PurseException(String reason) {
        super(reason);
    }
}