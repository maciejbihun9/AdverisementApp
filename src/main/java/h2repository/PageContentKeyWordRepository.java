package h2repository;

import model.AdvertiserPage;
import model.PageContentKeyWord;
import model.PageKeyWord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maciek on 2016-11-30.
 */
public interface PageContentKeyWordRepository extends JpaRepository<PageContentKeyWord, Long> {
}
