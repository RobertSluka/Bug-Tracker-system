package Bug.Repository;

import Bug.Entity.Bug;
import Bug.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends JpaRepository<Bug, Long> {
    Bug findByBugName(String UserName);
    @Query("SELECT COUNT(b) > 0 FROM Bug b WHERE b.bugName = :bugName AND b.projectName = :projectName")
    boolean validateBug(@Param("bugName") String bugName, @Param("projectName") String projectName);
}
