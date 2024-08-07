package Demo_vlog.Repository;

import Demo_vlog.Model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
