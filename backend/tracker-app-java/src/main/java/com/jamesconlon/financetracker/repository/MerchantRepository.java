package com.jamesconlon.financetracker.repository;

import com.jamesconlon.financetracker.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    Merchant findByName(String name);
}
