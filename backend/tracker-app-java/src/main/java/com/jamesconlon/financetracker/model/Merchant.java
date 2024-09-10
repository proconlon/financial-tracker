package com.jamesconlon.financetracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Merchant {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // merchant id

    private String name; // merchant name

    // Many-to-Many relationship with Category
    @Getter
    @ManyToMany
    // the join table associates merchants with categories
    // ie a merchant can have many categories and a category can have many merchants
    @JoinTable(
            name = "merchant_categories",
            joinColumns = @JoinColumn(name = "merchant_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories; // categories associated with this merchant (in the join table)

    public Merchant() {}

    // constructor with name and a list of categories
    public Merchant(String name, List<Category> categories) {
        this.name = name;
        this.categories = categories;
    }

    // Add category to merchant
    public void addCategory(Category category) {
        this.categories.add(category);
    }

    // Remove category from merchant
    public void removeCategory(Category category) {
        this.categories.remove(category);
    }
}
