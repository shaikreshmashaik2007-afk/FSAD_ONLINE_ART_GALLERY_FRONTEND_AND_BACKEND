package com.onlineartgallery.gallery.controller;

import com.onlineartgallery.gallery.model.Artwork;
import com.onlineartgallery.gallery.model.Purchase;
import com.onlineartgallery.gallery.model.User;
import com.onlineartgallery.gallery.service.ArtworkService;
import com.onlineartgallery.gallery.service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final ArtworkService artworkService;
    private final PurchaseService purchaseService;

    public CustomerController(ArtworkService artworkService, PurchaseService purchaseService) {
        this.artworkService = artworkService;
        this.purchaseService = purchaseService;
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<?> dashboard(@AuthenticationPrincipal User user) {
        List<Artwork> artworks = artworkService.getAllAvailableArtworks();
        List<Purchase> purchases = purchaseService.getPurchasesByCustomer(user.getId());

        Map<String, Object> payload = Map.of(
                "message", "Customer dashboard data",
                "featuredArtworksCount", artworks.size(),
                "purchaseHistoryCount", purchases.size()
        );
        return ResponseEntity.ok(payload);
    }

    @GetMapping("/artworks")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<List<Artwork>> getAvailableArtworks() {
        List<Artwork> artworks = artworkService.getAllAvailableArtworks();
        return ResponseEntity.ok(artworks);
    }

    @GetMapping("/purchases")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<List<Purchase>> getMyPurchases(@AuthenticationPrincipal User user) {
        List<Purchase> purchases = purchaseService.getPurchasesByCustomer(user.getId());
        return ResponseEntity.ok(purchases);
    }
}
