package pl.mati.meetingapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

//    @Query("SELECT  M MEETING m WHERE TYPE_MEETING = 'ONLINE'")
//    List<Meeting> onlineMeetings
//    public List<Meeting> findByNameType(@Param("type") String type) {
//        String jpql = "select u from User u where u.name like :search";
//        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
//        query.setParameter("search", fragment+"%");
//        List<User> resultList = query.getResultList();
//        return resultList;
//    }

}
