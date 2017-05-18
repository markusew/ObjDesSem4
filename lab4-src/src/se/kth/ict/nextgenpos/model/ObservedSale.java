package se.kth.ict.nextgenpos.model;

/**
 * Observes when a items are added to sale
 */
public interface ObservedSale {
    /**
     * Called when an item is added to the sale
     * 
     * @param addedItem The item that was recently added.
     */
    public void itemAdded(String addedItem);
}
