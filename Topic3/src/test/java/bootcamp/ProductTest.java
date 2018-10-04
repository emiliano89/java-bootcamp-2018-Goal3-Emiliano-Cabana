package bootcamp;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emiliano
 */
public class ProductTest {
  Product product = new Product();
    
  @Test
  public void addProductTest() {
  assertTrue(product.addProduct(0, "pad", 59.99 , 3, 1));
  assertFalse(product.addProduct( -4, "pad", 1 , 1, 0));
  }
  
  @Test
  public void deleteProductTest() {
  product.addProduct(0, "pad", 59.99 , 3, 1);
  assertTrue(product.deleteProduct(0));
  assertFalse(product.deleteProduct(0));
  }
  
  @Test
  public void modifyProductTest() {
  product.addProduct(2, "pad", 59.99 , 3, 1);
  product.modifyProduct(0, 1, "mouse", 49.99, 3, 2);
  assertThat(product.modifyProduct(0, 1, "mouse", 49.99, 3, 2), is(product.itemList(0)));
  }
}
