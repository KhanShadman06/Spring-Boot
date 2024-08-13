package Demo_vlog.Security;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TokenBlacklist {

    private Set<String> blacklist = new HashSet<>();

    public void addTokenToBlacklist(String token) {
        blacklist.add(token);
    }

    public boolean isTokenBlacklisted(String token) {
        return blacklist.contains(token);
    }
}
