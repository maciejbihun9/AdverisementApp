package mySqlrepository;

import model.AdvertiserPage;
import model.User;
import model.UserPageValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserPageValueRepository extends JpaRepository<UserPageValue, Long> {

    @Query("select u from UserPageValue u where u.owningPage = :owningPageId and u.userId = :userId")
    UserPageValue findByPageIdAndUserId(@Param("owningPageId") long owningPageId,
                                        @Param("userId") long userId);

}
