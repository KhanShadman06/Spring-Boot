package Demo_vlog.Model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<BlogPost> blogPosts;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public void setBlogPosts(Set<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }
}
