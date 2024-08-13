package Demo_vlog.service;

import Demo_vlog.Model.Token;
import Demo_vlog.Repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenServiceImpl {

    @Autowired
    private TokenRepository tokenRepository;

    public List<Token> findAllTokens() {
        return tokenRepository.findAll();
    }

    public Token saveToken(Token token) {
        return tokenRepository.save(token);
    }

    public Token findTokenById(Long id) {
        return tokenRepository.findById(id).orElse(null);
    }

    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public void deleteTokenById(Long id) {
        tokenRepository.deleteById(id);
    }
}
