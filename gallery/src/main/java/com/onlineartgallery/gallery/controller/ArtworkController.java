package com.onlineartgallery.gallery.controller;

import com.onlineartgallery.gallery.model.Artwork;
import com.onlineartgallery.gallery.service.ArtworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artworks")
public class ArtworkController {

    private final ArtworkService artworkService;

    public ArtworkController(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }

    @GetMapping
    public ResponseEntity<List<Artwork>> getAllArtworks() {
        List<Artwork> artworks = artworkService.getAllAvailableArtworks();
        return ResponseEntity.ok(artworks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artwork> getArtwork(@PathVariable Long id) {
        return artworkService.getArtworkById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Artwork>> getArtworksByCategory(@PathVariable String category) {
        List<Artwork> artworks = artworkService.getArtworksByCategory(category);
        return ResponseEntity.ok(artworks);
    }
}