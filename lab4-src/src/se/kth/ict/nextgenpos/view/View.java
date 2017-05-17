package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.model.InvalidItemException;
import se.kth.ict.nextgenpos.model.ObservedSale;
import se.kth.ict.nextgenpos.model.SalesLineItem;


/**
 * A placeholder for the view.
 */
public class View implements ObservedSale{
    private Controller cont;
    //private LogHandler logger;----

    /**
     * Creates a new <code>View</code>.
     * @param cont           The controller of the application.
     */
    public View(Controller cont) {
	this.cont = cont;
    }

    /**
     * Simulates a view. Makes some calls to the controller.
     */
    public void test() {
	cont.makeNewSale();
        cont.addObserver(this);
        
        try{
	enterItem(1);
        enterItem(2);
        enterItem(3);
	/*System.out.println(">>>>> NOTE!!\n" +
			   "A null pointer exception will follow since there is no handling" + 
			   " of non-existing item ids. When you have implemented exception" +
			   " handling, there should be some informative printout instead of the" +
			   " exception stack trace.");
        */
        enterItem(10);
        }
        catch(InvalidItemException e){
            System.out.println(e.getMessage());
            //logger.logException(e);----
        }
    }

    private void enterItem(int itemId) throws InvalidItemException {
	int quantity = 1;
      
        System.out.println("");
        System.out.println("Result for item " + itemId + ": " + cont.enterItem(itemId, quantity));
        System.out.println("");
        System.out.println("Total cost is: " + cont.getTotalCost());

        
    }

    @Override
    public void itemAdded(SalesLineItem[] listOfItems) {
        this.currentList(listOfItems);
    }
    public void currentList(SalesLineItem[] lineItems){
        System.out.println("List has been updated.");
        for (SalesLineItem lineItem : lineItems){
            System.out.println(lineItem);
        }
            
    }
    
}
