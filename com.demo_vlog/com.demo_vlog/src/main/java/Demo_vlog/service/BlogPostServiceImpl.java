package Demo_vlog.service;

import Demo_vlog.Model.BlogPost;
import Demo_vlog.Repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Override
    public BlogPost saveBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public BlogPost getBlogPostById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }
}
