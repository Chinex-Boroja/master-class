package aop;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkout(String status) {
        System.out.println("Checkout Method from ShoppingCart called");
    }

    public int quantity() {
        return 2;
    }
}
