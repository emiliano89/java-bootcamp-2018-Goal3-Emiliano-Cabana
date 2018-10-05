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
  assertFalse(product.addProduct( -4, "pad", 1 , 1, 2));
  assertFalse(product.addProduct( 1, "", 1 , 1, 4));
  assertFalse(product.addProduct( 3, "keyboard", 1 , 1, 0));
  assertFalse(product.addProduct( 3, "mouse", 30.25 , -2, 1));
  assertFalse(product.addProduct( 3, "pad", 1 , 6, 2));
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
  assertThat(product.modifyProduct(2, 1, "mouse", 49.99, 3, 2), is(""));
  }
  
  @Test
  public void stockTest() {
  assertThat(product.stock("mouse", 80, 20), is (true));
  assertThat(product.stock("mouse", 20, 80), is (false));
  assertThat(product.stock("pad", 50, 30), is (true));
  assertThat(product.stock("pad", 10, 15), is (false));
  assertThat(product.stock("keyboard", 120, 50), is (true));
  assertThat(product.stock("keyboard", 50, 68), is (false));
  }
  
  @Test
  public void priceWithDiscountTest() {
  assertThat(product.priceWithDiscount(25, 100.00), is(75.00));
  assertThat(product.priceWithDiscount(125, 100.00), is(100.00));
  assertThat(product.priceWithDiscount(-25, 100.00), is(100.00));
  }
}