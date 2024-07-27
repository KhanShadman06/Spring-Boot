package Demo_vlog.Repository;

import Demo_vlog.Model.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
}
