package se.kth.ict.nextgenpos.model;
/**
 *Thrown when the Item ID does not exist in the database.
 */
public class InvalidItemException extends Exception {
    
    public InvalidItemException (int itemId){
        super("--------The entered item ID '" + itemId + "' is invalid.-----------"
           +"\n--------Try entering a different, valid item ID--------");
    } 
}