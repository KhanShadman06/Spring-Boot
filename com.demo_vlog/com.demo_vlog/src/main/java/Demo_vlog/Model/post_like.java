package Demo_vlog.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "post_like")
public class post_like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private BlogPost blogPost;

    // Getters and Setters
}
