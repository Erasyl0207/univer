package kz.kaz.univer.jwt;

import io.jsonwebtoken.Claims;
import kz.kaz.univer.entity.abstracts.User;

import java.security.Key;

public interface JwtService {

    Claims extractClaims(String token);

    Key getKey();

    String generateToken(User user);

    boolean isValidToken(String token);
}
