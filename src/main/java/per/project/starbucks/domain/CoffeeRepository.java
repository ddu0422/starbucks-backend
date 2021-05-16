package per.project.starbucks.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    @Query("select coffee " +
            "from Coffee coffee")
    List<Coffee> findCoffees();
}
