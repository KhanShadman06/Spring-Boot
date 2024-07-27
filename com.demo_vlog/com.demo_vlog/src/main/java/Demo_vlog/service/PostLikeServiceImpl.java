package Demo_vlog.service;

import Demo_vlog.Model.PostLike;
import Demo_vlog.Repository.PostLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostLikeServiceImpl implements PostLikeService {

    @Autowired
    private PostLikeRepository postLikeRepository;

    @Override
    public PostLike savePostLike(PostLike postLike) {
        return postLikeRepository.save(postLike);
    }

    @Override
    public List<PostLike> getAllPostLikes() {
        return postLikeRepository.findAll();
    }

    @Override
    public PostLike getPostLikeById(Long id) {
        return postLikeRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePostLike(Long id) {
        postLikeRepository.deleteById(id);
    }
}
