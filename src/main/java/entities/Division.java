package entities;
import jakarta.persistence.Entity;
import java.util.Date;
@Entity
public class Division {
    Long id;
    String division_name;
    Date create_date;
    Date last_update;
    Country country;
}
