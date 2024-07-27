package Demo_vlog.Model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bio")
    private String bio;

    @OneToMany(mappedBy = "author")
    private Set<BlogPost> blogPosts;

    // Getters and Setters
}
