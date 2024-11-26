package edu.lawrence.getoutdoors.services;

// Java-level includes [Util]
import java.util.Date;

// Javax-level includes [Key]
import javax.crypto.SecretKey;

// Spring-level includes [Class Annotations]
import org.springframework.stereotype.Service;

// JWT-level includes [Core]
import io.jsonwebtoken.Jwts;

@Service
public class JwtService {
	
	SecretKey key = Jwts.SIG.HS256.key().build();

	public boolean isValid(String token) {
		try {
			return Jwts.parser()
					.verifyWith(key)
					.build()
					.parseSignedClaims(token)
					.getPayload()
					.getExpiration()
					.after(new Date(System.currentTimeMillis()));
		} catch (Exception ex) {
		}

		return false;
	}

	public String getSubject(String token) {
		return Jwts.parser()
				.verifyWith(key)
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}

	public String makeJwt(String userIDString) {
		return Jwts.builder()
				.subject(userIDString)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)).signWith(key).compact();
	}
}