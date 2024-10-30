package com.example.webtextclassifier;

import java.util.List;

/**
 * Represents a category with a name and a list of keywords.
 * Each category is used to classify text based on keyword matching.
 */
public class Category {

    private String name; // Name of the category (e.g., "Basketball")
    private List<String> keywords; // List of keywords associated with this category

    /**
     * Constructs a Category with a specified name and keywords.
     *
     * @param name     The name of the category.
     * @param keywords The list of keywords associated with this category.
     */
    public Category(String name, List<String> keywords) {
        this.name = name;
        this.keywords = keywords;
    }

    /**
     * Retrieves the name of the category.
     *
     * @return The category name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the list of keywords for this category.
     *
     * @return A list of keywords associated with the category.
     */
    public List<String> getKeywords() {
        return keywords;
    }
}
