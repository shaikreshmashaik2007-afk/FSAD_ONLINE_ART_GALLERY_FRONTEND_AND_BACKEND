package com.onlineartgallery.gallery.repository;

import com.onlineartgallery.gallery.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByCustomerId(Long customerId);
    List<Purchase> findByArtworkArtistUserId(Long artistId);
}