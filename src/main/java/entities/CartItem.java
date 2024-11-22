package entities;
import jakarta.persistence.Entity;
import java.util.Date;
import java.util.Set;
@Entity
public class CartItem {
    Long id;
    Vacation vacation;
    Set<Excursion> excursions;
    Cart cart;
    Date create_date;
    Date last_update;
}
