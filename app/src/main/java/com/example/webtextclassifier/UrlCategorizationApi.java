package com.example.webtextclassifier;

import static spark.Spark.*;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

/**
 * REST API for URL Categorization.
 * Provides an endpoint to categorize URLs based on predefined categories.
 */
public class UrlCategorizationApi {

    private static UrlTextRetriever retriever = new UrlTextRetriever();
    private static List<Category> predefinedCategories = retriever.initializeCategories();
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        // Define the endpoint
        port(4567);
        post("/categorize", (request, response) -> {
            response.type("application/json");

            // Parse the incoming JSON to get the list of URLs
            UrlRequest urlRequest = gson.fromJson(request.body(), UrlRequest.class);

            // Prepare a response map with URL as key and matching categories as value
            Map<String, List<String>> result = new HashMap<>();
            for (String url : urlRequest.urls) {
                Optional<String> textOpt = retriever.retrieveTextFromUrl(url);
                if (textOpt.isPresent()) {
                    String text = textOpt.get();
                    List<String> matchingCategories = getMatchingCategories(text);
                    result.put(url, matchingCategories);
                } else {
                    result.put(url, List.of("Failed to retrieve text"));
                }
            }

            // Return JSON response
            return gson.toJson(result);
        });
    }

    /**
     * Helper method to get matching categories for a given text.
     *
     * @param text The text to categorize.
     * @return List of category names that match the text.
     */
    private static List<String> getMatchingCategories(String text) {
        return predefinedCategories.stream()
                .filter(category -> retriever.isTextMatchingCategory(text, category))
                .map(Category::getName)
                .toList();
    }

    /**
     * Inner class to represent the incoming JSON request with URLs.
     */
    private static class UrlRequest {
        List<String> urls;
    }
}
