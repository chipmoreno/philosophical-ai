package entities;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
@Entity
public class Vacation {
    Long id;
    String vacation_title;
    String description;
    BigDecimal travel_price;
    String image_URL;
    Date create_date;
    Date last_update;
    Set<Excursion> excursions;
}
