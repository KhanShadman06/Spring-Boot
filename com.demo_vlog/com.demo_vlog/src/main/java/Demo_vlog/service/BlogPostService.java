package Demo_vlog.service;

import Demo_vlog.Model.BlogPost;
import Demo_vlog.Model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogPostService {
    BlogPost saveBlogPost(BlogPost blogPost);
    List<BlogPost> getAllBlogPosts();
    BlogPost getBlogPostById(Long id);
    void deleteBlogPost(Long id);
    Page<BlogPost> getPaginatedBlogPosts(Pageable pageable);
    List<BlogPost> getBlogPostsByCategory(Category category);
}
