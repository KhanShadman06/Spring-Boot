package Demo_vlog.service;

import Demo_vlog.Model.post;
import java.util.List;

public interface PostService {
    post savePost(post post);
    List<post> getAllPosts();
    post getPostById(Long id);
    void deletePost(Long id);
}
