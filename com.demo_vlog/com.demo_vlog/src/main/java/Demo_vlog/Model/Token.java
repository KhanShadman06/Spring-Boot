package Demo_vlog.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id") // Specified column name for id
    private Long id;

    @Column(name = "token_value", nullable = false, unique = true) // Specified column name for token
    private String token;

    @Column(name = "expiry_date", nullable = false) // Specified column name for expiryDate
    private Date expiryDate;

    // Other fields, getters, and setters

    // Constructors
    public Token() {
    }

    public Token(String token, Date expiryDate) {
        this.token = token;
        this.expiryDate = expiryDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
