package com.onlineartgallery.gallery.repository;

import com.onlineartgallery.gallery.model.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
    List<Artwork> findByAvailableTrue();
    List<Artwork> findByArtistUserId(Long artistId);
    List<Artwork> findByCategory(String category);
}