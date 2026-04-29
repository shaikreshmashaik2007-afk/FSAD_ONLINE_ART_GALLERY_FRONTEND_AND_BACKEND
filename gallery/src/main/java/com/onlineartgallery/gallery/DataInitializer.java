package com.onlineartgallery.gallery;

import com.onlineartgallery.gallery.model.Artwork;
import com.onlineartgallery.gallery.model.User;
import com.onlineartgallery.gallery.repository.ArtworkRepository;
import com.onlineartgallery.gallery.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, ArtworkRepository artworkRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Create sample users if not exist
            if (userRepository.count() == 0) {
                User admin = new User();
                admin.setName("Admin User");
                admin.setEmail("admin@example.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ADMIN");
                userRepository.save(admin);

                User artist = new User();
                artist.setName("John Artist");
                artist.setEmail("artist@example.com");
                artist.setPassword(passwordEncoder.encode("artist123"));
                artist.setRole("ARTIST");
                userRepository.save(artist);

                User customer = new User();
                customer.setName("Jane Customer");
                customer.setEmail("customer@example.com");
                customer.setPassword(passwordEncoder.encode("customer123"));
                customer.setRole("CUSTOMER");
                userRepository.save(customer);
            }

            // Create sample artworks if not exist
            if (artworkRepository.count() == 0) {
                User artist = userRepository.findByEmail("artist@example.com").orElseThrow();

                Artwork artwork1 = new Artwork();
                artwork1.setTitle("Sunset Dreams");
                artwork1.setDescription("A beautiful sunset painting");
                artwork1.setArtist("John Artist");
                artwork1.setPrice(new BigDecimal("150.00"));
                artwork1.setCategory("Landscape");
                artwork1.setMedium("Oil on Canvas");
                artwork1.setDimensions("24x30 inches");
                artwork1.setImageUrl("https://example.com/sunset.jpg");
                artwork1.setArtistUser(artist);
                artworkRepository.save(artwork1);

                Artwork artwork2 = new Artwork();
                artwork2.setTitle("Abstract Blue");
                artwork2.setDescription("Modern abstract art");
                artwork2.setArtist("John Artist");
                artwork2.setPrice(new BigDecimal("200.00"));
                artwork2.setCategory("Abstract");
                artwork2.setMedium("Acrylic");
                artwork2.setDimensions("20x24 inches");
                artwork2.setImageUrl("https://example.com/abstract.jpg");
                artwork2.setArtistUser(artist);
                artworkRepository.save(artwork2);
            }
        };
    }
}