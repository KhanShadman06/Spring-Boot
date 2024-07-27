package Demo_vlog.Repository;

import Demo_vlog.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlogPostId(Long blogPostId);
}
