package se.kth.ict.nextgenpos.model;

import java.util.Map;
import java.util.HashMap;

/**
 * This class is responsible for all access to the product database.
 */ 
public class ProductCatalog { 
    private Map<Integer, ProductSpecification> products = 
	new HashMap<Integer, ProductSpecification>();

    /**
     * Fills the catalog with some dummy items.
     * 
     * @throws se.kth.ict.nextgenpos.model.InvalidItemException
     */
    public ProductCatalog(){
        
	products.put(1, new ProductSpecification(1, "low fat milk", 
	   "a very long description, a very long description, a very long description", 10));
	products.put(2, new ProductSpecification(2, "butter", 
	   "a very long description, a very long description, a very long description", 10));
	products.put(3, new ProductSpecification(3, "bread", 
	   "a very long description, a very long description, a very long description", 10));
    }

    /**
     * Search for an item in the product catalog.
     *
     * @param    itemId The item to look for
     * @return          The specification for the found item or null if no item was found.
     * @throws InvalidItemException if no item with desired item ID was found.
     */
    public ProductSpecification findSpecification(int itemId) throws InvalidItemException {
            ProductSpecification requestedId = products.get(itemId);
            if (requestedId == null){
                throw new InvalidItemException(itemId);
                }
            else{
                return products.get(itemId);
            }
    }
}
