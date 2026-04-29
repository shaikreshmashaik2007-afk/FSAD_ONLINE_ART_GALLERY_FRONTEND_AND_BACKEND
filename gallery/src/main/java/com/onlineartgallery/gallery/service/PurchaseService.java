package com.onlineartgallery.gallery.service;

import com.onlineartgallery.gallery.model.Artwork;
import com.onlineartgallery.gallery.model.Purchase;
import com.onlineartgallery.gallery.model.User;
import com.onlineartgallery.gallery.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> getPurchasesByCustomer(Long customerId) {
        return purchaseRepository.findByCustomerId(customerId);
    }

    public List<Purchase> getPurchasesByArtist(Long artistId) {
        return purchaseRepository.findByArtworkArtistUserId(artistId);
    }

    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Optional<Purchase> getPurchaseById(Long id) {
        return purchaseRepository.findById(id);
    }
}