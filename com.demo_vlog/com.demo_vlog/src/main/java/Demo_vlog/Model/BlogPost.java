package Demo_vlog.Model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "blog_post")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "blogpost_tags",
            joinColumns = @JoinColumn(name = "blogpost_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "blogpost_categories",
            joinColumns = @JoinColumn(name = "blogpost_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PostLike> postLikes;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<PostLike> getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(Set<PostLike> postLikes) {
        this.postLikes = postLikes;
    }
}
