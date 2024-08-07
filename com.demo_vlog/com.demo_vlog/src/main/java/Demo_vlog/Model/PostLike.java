package Demo_vlog.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "post_like")
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "blog_post_id")
    private BlogPost blogPost;

    @Column(name = "user_id")
    private Long userId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
