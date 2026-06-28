package com.payroll.auth;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;


public class PasswordUtil {
    private static final SecureRandom RANDOM = new SecureRandom();

    
    public static String hash(String password) {
        try {
            byte[] salt = new byte[12]; // small random salt
            RANDOM.nextBytes(salt);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt); // include salt in the hash
            byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));

            String saltB64 = Base64.getEncoder().encodeToString(salt);
            String hashB64 = Base64.getEncoder().encodeToString(digest);
            return saltB64 + ":" + hashB64;
        } catch (Exception e) {
            throw new RuntimeException("Hashing failed", e);
        }
    }

    
    public static boolean verify(String password, String stored) {
        try {
            String[] parts = stored.split(":");
            if (parts.length != 2) return false;
            byte[] salt = Base64.getDecoder().decode(parts[0]);
            byte[] expected = Base64.getDecoder().decode(parts[1]);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));

            // constant-time compare
            if (digest.length != expected.length) return false;
            int diff = 0;
            for (int i = 0; i < digest.length; i++) diff |= digest[i] ^ expected[i];
            return diff == 0;
        } catch (Exception e) {
            return false;
        }
    }
}
