package entities;
import jakarta.persistence.Entity;
import java.util.Date;
import java.util.Set;
@Entity
public class Customer {
    Long id;
    String firstName;
    String lastName;
    String address;
    String postal_code;
    String phone;
    Date create_date;
    Date last_update;
    Division divison;
    Set<Cart> carts;
}
