package com.example.webtextclassifier;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Utility class for retrieving and categorizing text from URLs.
 * Provides methods to fetch plain text from a URL, initialize categories,
 * and match text against category keywords.
 */
public class UrlTextRetriever {

    /**
     * Retrieves and cleans the visible text from a specified URL.
     * Removes HTML tags, scripts, and styles.
     *
     * @param url The URL to fetch text from.
     * @return An Optional containing the cleaned text content of the URL, or empty if an error occurs.
     */
    public Optional<String> retrieveTextFromUrl(String url) {
        try {
            // Fetch the HTML content from the specified URL
            Document doc = Jsoup.connect(url).get();

            // Extract and return visible text, removing unnecessary tags
            return Optional.of(doc.text());
        } catch (IOException e) {
            System.out.println("Error fetching text from URL: " + url);
            e.printStackTrace();
            return Optional.empty(); // Return an empty Optional in case of an error
        }
    }

    /**
     * Initializes a list of predefined categories with associated keywords.
     * This method creates categories like "Star Wars" and "Basketball" with
     * relevant keywords for text matching.
     *
     * @return A list of predefined categories with keywords.
     */
    public List<Category> initializeCategories() {
        List<Category> categories = new ArrayList<>();

        // Define keywords for the "Star Wars" category
        List<String> starWarsKeywords = Arrays.asList("star wars", "starwars", "star war", "r2d2", "may the force be with you");
        categories.add(new Category("Star Wars", starWarsKeywords));

        // Define keywords for the "Basketball" category
        List<String> basketballKeywords = Arrays.asList("basketball", "nba", "ncaa", "lebron james", "john stockton", "anthony davis");
        categories.add(new Category("Basketball", basketballKeywords));

        return categories;
    }

    /**
     * Checks if the provided text contains any keywords from a specified category.
     * Performs case-insensitive matching for better accuracy.
     *
     * @param text     The text content to check.
     * @param category The category whose keywords are to be matched.
     * @return True if any keyword matches, false otherwise.
     */
    public boolean isTextMatchingCategory(String text, Category category) {
        // Perform case-insensitive match for each keyword using a Stream
        return category.getKeywords().stream().anyMatch(keyword -> text.toLowerCase().contains(keyword.toLowerCase()));
    }
}
