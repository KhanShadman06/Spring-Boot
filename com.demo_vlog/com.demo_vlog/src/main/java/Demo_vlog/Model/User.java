package Demo_vlog.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users") // Specify the table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Specify the column name
    private Long id;

    @Column(name = "name", nullable = false) // Specify the column name and make it non-nullable
    private String name;

    @Column(name = "username", nullable = false, unique = true) // Username should be unique
    private String username;

    @Column(name = "password", nullable = false) // Password should be non-nullable
    private String password;

    @Column(name = "email", nullable = false, unique = true) // Email should be unique and non-nullable
    private String email;

    @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0") // Set default value to false
    private boolean enabled = false;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<BlogPost> blogPosts; // Use Set instead of List to avoid duplicates

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles; // Use Set instead of List

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public void setBlogPosts(Set<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
