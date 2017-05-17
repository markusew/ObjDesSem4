package se.kth.ict.nextgenpos.model;

/**
 * Observes when a items are added to sale
 */
public interface ObservedSale {
    /**
     * Called when an item is added to the sale
     * 
     * @param listOfItems The list of all items of the sale
     */
    public void itemAdded(SalesLineItem[] listOfItems);
}
