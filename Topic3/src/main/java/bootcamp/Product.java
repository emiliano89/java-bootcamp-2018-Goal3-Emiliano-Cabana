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
        this.quantity = quantity;
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
        if (id > -1 && productName.isEmpty() == false && quantity > 0 && category >= 0  && category < 5 ) {
        this.setId(id);
        this.setProductName(productName);
        this.setPrice(price);
        this.setCategory(category);
        this.setQuantity(quantity);
        productList.add(new Product(this.getId(),this.getProductName(),this.getPrice(),this.getCategory(),this.getQuantity()));
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
        if(productList.size()> item) {
           Product prod = productList.get(item);
           prod.getId();
           prod.getProductName();
           prod.getPrice();
           prod.getCategory();
           prod.getQuantity();    
           if(productList.get(item) != null) {
              prod.setId(id);
              prod.setProductName(productName);
              prod.setPrice(price);
              prod.setCategory(category);
              prod.setQuantity(quantity);
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
        
        /**
         * method for stock 
         */
        public boolean stock (String productName, int prodStock, int buyed) {
        boolean haveStock = false;
        if (prodStock >= buyed) {
        haveStock = true;
        switch (productName) {
            case "mouse": prodStock -= buyed;
                          break;
            case "pad": prodStock -= buyed;
                        break;
            case "keyboard": prodStock -= buyed;
                             break;
        }
        }
        else {
        haveStock = false;
        }
        return haveStock;
        }

        /**
         * method for discount 
         */
        public double priceWithDiscount(int percentage, double price) {
        double finalPrice = 0;
        if (percentage < 100 && percentage > -1) {
            finalPrice = price - percentage*price/100;
        }
        else {
            finalPrice = price;
        }
        return finalPrice;
        }
        
}