package com.jamesconlon.financetracker.service;

import com.jamesconlon.financetracker.model.Category;
import com.jamesconlon.financetracker.model.Merchant;
import com.jamesconlon.financetracker.repository.CategoryRepository;
import com.jamesconlon.financetracker.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Merchant addMerchant(String name, List<String> categoryNames) {
        List<Category> categories = categoryRepository.findByNameIn(categoryNames);
        Merchant merchant = new Merchant(name, categories);
        return merchantRepository.save(merchant);
    }

    public List<Category> getCategoriesForMerchant(String merchantName) {
        Merchant merchant = merchantRepository.findByName(merchantName);
        return merchant != null ? merchant.getCategories() : List.of();
    }

    public void addCategoryToMerchant(String merchantName, String categoryName) {
        Merchant merchant = merchantRepository.findByName(merchantName);
        Category category = categoryRepository.findByName(categoryName);

        if (merchant != null && category != null) {
            merchant.addCategory(category);
            merchantRepository.save(merchant);
        }
    }

    public void removeCategoryFromMerchant(String merchantName, String categoryName) {
        Merchant merchant = merchantRepository.findByName(merchantName);
        Category category = categoryRepository.findByName(categoryName);

        if (merchant != null && category != null) {
            merchant.removeCategory(category);
            merchantRepository.save(merchant);
        }
    }
}
