package Demo_vlog.service;

import Demo_vlog.Model.post;
import Demo_vlog.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public post savePost(post post) {
        return postRepository.save(post);
    }

    @Override
    public List<post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
