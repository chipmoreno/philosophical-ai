package entities;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
@Entity
public class Excursion {
    Long id;
    String excursion_title;
    BigDecimal excusion_price;
    String image_URL;
    Date create_date;
    Date last_update;
    Vacation vacation;
    Set<CartItem> cartitems;
}
