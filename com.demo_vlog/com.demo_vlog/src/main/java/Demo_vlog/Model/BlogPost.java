package Demo_vlog.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "blog_post")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "blog_post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "blog_post_categories",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @OneToMany(mappedBy = "blogPost")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "blogPost")
    private Set<post_like> likes;

    // Getters and Setters
}
