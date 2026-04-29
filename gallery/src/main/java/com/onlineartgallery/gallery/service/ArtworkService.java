package com.onlineartgallery.gallery.service;

import com.onlineartgallery.gallery.model.Artwork;
import com.onlineartgallery.gallery.model.User;
import com.onlineartgallery.gallery.repository.ArtworkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtworkService {

    private final ArtworkRepository artworkRepository;

    public ArtworkService(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    public List<Artwork> getAllAvailableArtworks() {
        return artworkRepository.findByAvailableTrue();
    }

    public Optional<Artwork> getArtworkById(Long id) {
        return artworkRepository.findById(id);
    }

    public List<Artwork> getArtworksByArtist(Long artistId) {
        return artworkRepository.findByArtistUserId(artistId);
    }

    public List<Artwork> getArtworksByCategory(String category) {
        return artworkRepository.findByCategory(category);
    }

    public Artwork createArtwork(Artwork artwork) {
        return artworkRepository.save(artwork);
    }

    public Artwork updateArtwork(Artwork artwork) {
        return artworkRepository.save(artwork);
    }

    public void deleteArtwork(Long id) {
        artworkRepository.deleteById(id);
    }
}