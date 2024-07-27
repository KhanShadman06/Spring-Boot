package Demo_vlog.Repository;

import Demo_vlog.Model.post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<post, Long> {
    List<post> findByAuthorId(Long authorId);
    List<post> findByCategoryId(Long categoryId);
}
