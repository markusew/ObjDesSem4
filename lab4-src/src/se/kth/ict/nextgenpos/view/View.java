package se.kth.ict.nextgenpos.view;

import java.io.IOException;
import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.model.InvalidItemException;
import se.kth.ict.nextgenpos.model.LogHandler;
import se.kth.ict.nextgenpos.model.ObservedSale;
import se.kth.ict.nextgenpos.model.SalesLineItem;

/**
 * A placeholder for the view.
 */
public class View implements ObservedSale {

    private Controller cont;
    private LogHandler logger;

    /**
     * Creates a new <code>View</code>.
     *
     * @param cont The controller of the application.
     *
     * @throws java.io.IOException
     */
    public View(Controller cont) throws IOException {
        this.cont = cont;
        this.logger = new LogHandler();
    }

    /**
     * Simulates a view. Makes some calls to the controller.
     */
    public void test(){
        cont.makeNewSale();
        cont.addObserver(this);

        enterItem(1);
        enterItem(2);
        enterItem(3);
        /*
        System.out.println(">>>>> NOTE!!\n" +
			   "A null pointer exception will follow since there is no handling" + 
			   " of non-existing item ids. When you have implemented exception" +
			   " handling, there should be some informative printout instead of the" +
			   " exception stack trace.");
         */
        enterItem(10);
        enterItem(3);

    }

    private void enterItem(int itemId){
        int quantity = 1;
        try {
            System.out.println("");
            System.out.println("Result for item " + itemId + ": " + cont.enterItem(itemId, quantity));
            System.out.println("");
            System.out.println("Total cost is: " + cont.getTotalCost());
        } catch (InvalidItemException e) {
            System.out.println(e.getMessage());
            logger.logException(e);
        }

    }

    @Override
    public void itemAdded(SalesLineItem[] listOfItems) {
        this.currentList(listOfItems);
    }

    /**
     * Prints out the current list as Strings.
     *
     * @param lineItems is the List of items that have been scanned.
     */
    public void currentList(SalesLineItem[] lineItems) {
        System.out.println("List has been updated.");
        for (SalesLineItem lineItem : lineItems) {
            System.out.println(lineItem + "\n");

        }

    }

}
