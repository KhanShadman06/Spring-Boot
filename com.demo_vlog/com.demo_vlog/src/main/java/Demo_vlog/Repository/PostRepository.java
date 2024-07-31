package Demo_vlog.Repository;

import Demo_vlog.Model.post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<post, Long> {
    Page<post> findAll(Pageable pageable);
}
