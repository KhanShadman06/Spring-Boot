package Demo_vlog.service;

import Demo_vlog.Model.Token;
import Demo_vlog.Model.User;

import java.util.Date;
import java.util.Optional;

public interface TokenService {
    Token createToken(User user, String token, Date expiryDate);
    Optional<Token> findByToken(String token);
    void deleteToken(String token);
}
