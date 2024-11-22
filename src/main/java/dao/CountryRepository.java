package dao;
import entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
public interface CountryRepository extends JpaRepository<Country, Long> {
}
