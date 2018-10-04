package bootcamp;

import java.util.ArrayList;
import java.util.List;
import lombok.*;
/**
 * @author Emiliano
 */
@Data
public class Product {
        private int id;
        private String productName;
        private double price;
        private int category;
        private int quantity;
        private List<Product> productList = new ArrayList();
        
        /**
         * I Added constructor without the arraylist
         */
        public Product(int id, String productName, double price, int category, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
        }

        /**
         * I Added an empty constructor becouse my compiler didn't recognize it
         */
        public Product() {
        }
        
        /**
         * method to add a product 
         */
        public boolean addProduct(int id, String productName, double price, int category,  int quantity) {
        boolean added = false;
        Product prod = new Product(id, productName, price, category, quantity);
        if (id > -1 && productName != "" && quantity > 0 ) {
        productList.add(prod);
        added = true;
        }
        else {
        added = false;
        }
        return added;
        }
        
        /**
         * method to delete a product 
         */
        public boolean deleteProduct(int item) {
        boolean deleted = false; 
        if(productList.size()> item) {
           if(productList.get(item) != null) {
            productList.remove(item);
            deleted = true;
           }
           else {
            deleted = false;
           }
        }
        else {
        deleted = false;
        }
        return deleted;
        }
        
        /**
         * method to modify a product 
         */
        public String modifyProduct(int item, int id, String productName, double price, int category,  int quantity) {
        String modified = "";
        Product prod = new Product(id, productName, price, category, quantity);
        if(productList.size()> item) {
           if(productList.get(item) != null) {
            productList.set(item, prod);
            modified = productList.get(item).toString();
           }
        }
        else {
        modified = "";
        }
        return modified;
        }
        
        /**
         * method to get an especific item from the list
         */
        public String itemList(int item) {
        String itemList;
        if(item < productList.size()) {
         itemList = productList.get(item).toString();
        }
        else {
        itemList = "";
        }
         return itemList;
        }
        
}