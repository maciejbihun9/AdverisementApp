package hsqlRepository;

import model.Recomendation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maciek on 2016-11-26.
 */
public interface RecoRepository extends JpaRepository<Recomendation, Long> {
}
