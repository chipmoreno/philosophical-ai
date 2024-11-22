package entities;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
public class Cart {
    Long id;
    String orderTrackingNumber;
    BigDecimal package_price;
    int party_size;
    StatusType status;
    Date create_date;
    Date last_update;
    Customer customer;
    Set<CartItem> cartItem;
}
