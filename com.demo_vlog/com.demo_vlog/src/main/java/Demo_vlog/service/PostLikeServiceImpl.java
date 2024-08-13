package Demo_vlog.service;

import Demo_vlog.Model.PostLike;
import Demo_vlog.Repository.PostLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostLikeServiceImpl {

    @Autowired
    private PostLikeRepository postLikeRepository;

    public List<PostLike> getAllPostLikes() {
        return postLikeRepository.findAll();
    }

    public PostLike getPostLikeById(Long id) {
        return postLikeRepository.findById(id).orElse(null);
    }

    public PostLike createPostLike(PostLike postLike) {
        return postLikeRepository.save(postLike);
    }

    public PostLike updatePostLike(Long id, PostLike postLike) {
        PostLike existingPostLike = postLikeRepository.findById(id).orElse(null);
        if (existingPostLike != null) {
            existingPostLike.setId(postLike.getId());
            existingPostLike.setUser(postLike.getUser());
            return postLikeRepository.save(existingPostLike);
        }
        return null;
    }

    public void deletePostLike(Long id) {
        postLikeRepository.deleteById(id);
    }
}
