package h2repository;

import model.AdvertiserPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Maciek on 2016-11-16.
 */
@Transactional
public interface AdvertiserPageRepository extends JpaRepository<AdvertiserPage, Long>{
}
