package Demo_vlog.service;

import Demo_vlog.Model.BlogPost;

import java.util.List;

public interface BlogPostService {
    BlogPost saveBlogPost(BlogPost blogPost);
    List<BlogPost> getAllBlogPosts();
    BlogPost getBlogPostById(Long id);
    void deleteBlogPost(Long id);
}
