package com.example.webtextclassifier;

import java.util.List;
import java.util.Optional;
import java.util.Arrays; // Add this import to resolve the Arrays class

/**
 * The main entry point for the URL text retrieval and categorization program.
 * This class initializes categories, processes a list of URLs, retrieves their
 * content, and checks for matching categories based on keywords.
 */
public class Runner {

    public static void main(String[] args) {
        UrlTextRetriever retriever = new UrlTextRetriever();

        // Initialize categories with predefined keyword lists
        List<Category> predefinedCategories = retriever.initializeCategories();

        // Use all predefined categories for this run
        List<Category> categoriesToUse = predefinedCategories;

        // List of URLs to test for categorization
        List<String> urls = Arrays.asList(
            "https://www.bbc.com",
            "https://www.nba.com/news/heat-unveil-statue-of-dwyane-wade-at-kaseya-center-in-miami"
        );

        // Process each URL and match against categories
        for (String url : urls) {
            System.out.println("Processing URL: " + url);

            // Retrieve and clean text from the URL
            Optional<String> textOpt = retriever.retrieveTextFromUrl(url);

            // Check if text was retrieved successfully
            if (textOpt.isPresent()) {
                String text = textOpt.get();

                // Display the retrieved text for verification
                System.out.println("Retrieved Text: \n" + text);

                // Check for matching categories based on retrieved text
                System.out.println("Matching Categories:");
                for (Category category : categoriesToUse) {
                    if (retriever.isTextMatchingCategory(text, category)) {
                        System.out.println("Matched Category: " + category.getName());
                    }
                }
            } else {
                System.out.println("Failed to retrieve text from URL.");
            }

            System.out.println("--------------------------------------");
        }
    }
}
