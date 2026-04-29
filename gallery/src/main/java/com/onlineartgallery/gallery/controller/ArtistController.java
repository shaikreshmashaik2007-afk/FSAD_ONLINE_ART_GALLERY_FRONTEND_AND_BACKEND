package com.onlineartgallery.gallery.controller;

import com.onlineartgallery.gallery.model.Artwork;
import com.onlineartgallery.gallery.model.User;
import com.onlineartgallery.gallery.service.ArtworkService;
import com.onlineartgallery.gallery.service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {

    private final ArtworkService artworkService;
    private final PurchaseService purchaseService;

    public ArtistController(ArtworkService artworkService, PurchaseService purchaseService) {
        this.artworkService = artworkService;
        this.purchaseService = purchaseService;
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('ROLE_ARTIST')")
    public ResponseEntity<?> dashboard(@AuthenticationPrincipal User user) {
        List<Artwork> artworks = artworkService.getArtworksByArtist(user.getId());
        List<?> purchases = purchaseService.getPurchasesByArtist(user.getId());

        Map<String, Object> payload = Map.of(
                "message", "Artist dashboard data",
                "uploadedArtworksCount", artworks.size(),
                "sales", purchases.size()
        );
        return ResponseEntity.ok(payload);
    }

    @GetMapping("/artworks")
    @PreAuthorize("hasAuthority('ROLE_ARTIST')")
    public ResponseEntity<List<Artwork>> getMyArtworks(@AuthenticationPrincipal User user) {
        List<Artwork> artworks = artworkService.getArtworksByArtist(user.getId());
        return ResponseEntity.ok(artworks);
    }

    @PostMapping("/artworks")
    @PreAuthorize("hasAuthority('ROLE_ARTIST')")
    public ResponseEntity<Artwork> createArtwork(@RequestBody Artwork artwork, @AuthenticationPrincipal User user) {
        artwork.setArtistUser(user);
        artwork.setArtist(user.getName());
        Artwork saved = artworkService.createArtwork(artwork);
        return ResponseEntity.ok(saved);
    }
}
