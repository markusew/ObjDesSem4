package se.kth.ict.nextgenpos.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a single sale to one customer.
 */
public class Sale {
    private List<ObservedSale> saleObservers;
    private List<SalesLineItem> lineItems;
    private int currentTotal;
    private int payedAmount;
    private int iterator;
    private SalesLineItem lineItem;

    /**
     * Instantiates a new <code>Sale</code>.
     */
    public Sale() {
        saleObservers = new ArrayList<ObservedSale>();
	lineItems = new ArrayList<SalesLineItem>();
        
        
    }

    /**
     * Adds new items to the current <code>Sale</code>. 
     *
     * @param spec            The specification of the items that is added.
     * @param quantity        The number of items.
     */
    public void addItem(ProductSpecification spec, int quantity) {
	lineItem = new SalesLineItem(spec, quantity);
	lineItems.add(lineItem);
	addToTotal(lineItem);
        notifyObservers();
    }

    private void addToTotal(SalesLineItem lineItem) {
	currentTotal = 
	    currentTotal + lineItem.getCost();
    }

    /**
     * Returns the total cost of all products registered so for.
     *
     * @return The total cost of all products registered so for.
     */
    public int getCurrentTotal() {
	return currentTotal;
    }

    /**
     * Calculates change and returns all information needed for the receipt.
     *
     * @return All information needed for the receipt.
     */
    public Receipt createReceipt(int payedAmount) {
	this.payedAmount = payedAmount;
	return new Receipt(this);
    }

    void resetLineItemIterator() {
	iterator = 0;
    }

    SalesLineItem nextLineItem() {
	return lineItems.get(iterator);
    }

    boolean hasMoreLineItems() {
	return iterator < lineItems.size();
    }

    int getPayedAmount() {
	return payedAmount;
    }
    /**
     * Adds observer to this object. Observers will be triggered when item is
     * added to sale
     * 
     * @param observer the ObservedSale that is being added
     */
    
    public void addObserver(ObservedSale observer){
        this.saleObservers.add(observer);
    }
    /**
     * Deletes observer to this object. And notifies that a observer has
     * been deleted.
     * 
     * @param observer the ObservedSale that is being deleted
     */
    public void deleteObserver(ObservedSale observer){
        
        int observerIndex = saleObservers.indexOf(observer);
        System.out.println("Observer " + (observerIndex + 1) + " deleted");
        saleObservers.remove(observerIndex);
    }
    /**
     * This method is called when an item is added to the sale and creates a
     * copy of lineItems list and passes it out to the observers.
     */
    private void notifyObservers(){
 
        for (ObservedSale obs : this.saleObservers){
            obs.itemAdded(lineItem.toString());
           
        }
    }
}
