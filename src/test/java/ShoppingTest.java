import org.example.Cart;
import org.example.Order;
import org.example.Product;
import org.example.ShoppingService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingTest {
    @Test
    public void testCalculateTotal() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product1", 100));
        products.add(new Product(2, "Product2", 50));

        Order order = new Order(products);
        Assert.assertEquals(150, order.calculateTotal(), 0);
    }
    @Test
    public void testAddRemoveProductFromCart() {
        Cart cart = new Cart();
        Product product = new Product(1, "Test", 10.5);

        cart.addProduct(product);

        Assert.assertTrue(cart.getProducts().contains(product));

        cart.removeProduct(product);

        Assert.assertFalse(cart.getProducts().contains(product));
    }
    @Test
    public void testOrderCreationAndStatus() {
        Cart cart = new Cart();
        // додати продукти

        ShoppingService service = new ShoppingService();
        Order order = service.createOrder(cart);

        Assert.assertEquals("CREATED", order.getStatus());

        // перевірити, що замовлення з цим id є в мапі orders
        Assert.assertNotNull(service.getOrderStatus(order.getId()));
    }
}
