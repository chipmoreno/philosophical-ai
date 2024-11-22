package entities;
import jakarta.persistence.Entity;

import java.util.Date;
import java.util.Set;

@Entity
public class Country {
    Long id;
    String country_name;
    Date create_date;
    Date last_update;
    Set<Division> divisions;
}
