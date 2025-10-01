package ra.edu.session_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.edu.session_01.model.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select count(m) from Movie m where m.title = :title")
    long countByTitle(@Param("title") String title);
}
