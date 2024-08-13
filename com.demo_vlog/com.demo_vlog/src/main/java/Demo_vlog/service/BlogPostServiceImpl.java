package Demo_vlog.service;

import Demo_vlog.Model.BlogPost;
import Demo_vlog.Model.User;
import Demo_vlog.Repository.BlogPostRepository;
import Demo_vlog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostServiceImpl {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private UserRepository userRepository;

    // Method to retrieve paginated blog posts
    public Page<BlogPost> getAllPosts(Pageable pageable) {
        return blogPostRepository.findAll(pageable);
    }

    // Existing methods for handling other operations
    public BlogPost getPostById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    public BlogPost createPost(BlogPost post) {
        // Set the user for the post
        User user = getCurrentUser();
        post.setUser(user);
        return blogPostRepository.save(post);
    }

    public BlogPost updatePost(Long id, BlogPost post) {
        return blogPostRepository.findById(id)
                .map(existingPost -> {
                    existingPost.setTitle(post.getTitle());
                    existingPost.setContent(post.getContent());
                    // Update other fields as needed
                    return blogPostRepository.save(existingPost);
                })
                .orElse(null);
    }

    public void deletePost(Long id) {
        blogPostRepository.deleteById(id);
    }

    // Method to get the current authenticated user
    private User getCurrentUser() {
        // Get the username of the authenticated user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        // Fetch the user from the database
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }
}
