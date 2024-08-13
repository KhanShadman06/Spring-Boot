package Demo_vlog.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  // Specify the column name for the primary key
    private Long id;

    @Column(name = "name", nullable = false)  // Specify the column name and make it non-nullable
    private String name;

    @Column(name = "bio", columnDefinition = "TEXT")  // Specify the column name and define the column type
    private String bio;

    // Constructors
    public Author() {
    }

    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
