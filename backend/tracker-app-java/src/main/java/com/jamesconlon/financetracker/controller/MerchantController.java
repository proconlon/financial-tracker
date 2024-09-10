package com.jamesconlon.financetracker.controller;

import com.jamesconlon.financetracker.model.Category;
import com.jamesconlon.financetracker.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jamesconlon.financetracker.service.MerchantService;
import org.springframework.stereotype.Service;

import java.util.List;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    // Add a new merchant with categories
    @PostMapping
    public Merchant addMerchant(@RequestParam String name, @RequestBody List<String> categories) {
        return merchantService.addMerchant(name, categories);
    }

    // Get categories for a specific merchant
    @GetMapping("/{merchantName}/categories")
    public List<Category> getCategoriesForMerchant(@PathVariable String merchantName) {
        return merchantService.getCategoriesForMerchant(merchantName);
    }

    // Add a category to an existing merchant
    @PostMapping("/{merchantName}/categories")
    public void addCategoryToMerchant(@PathVariable String merchantName, @RequestBody String categoryName) {
        merchantService.addCategoryToMerchant(merchantName, categoryName);
    }

    // remove a category from a merchant
    @DeleteMapping("/{merchantName}/categories")
    public void removeCategoryFromMerchant(@PathVariable String merchantName, @RequestBody String categoryName) {
        merchantService.removeCategoryFromMerchant(merchantName, categoryName);
    }
}
