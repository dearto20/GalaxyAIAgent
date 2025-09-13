package com.example.galaxyaiagent;

import java.util.Random;

public class ResponseGenerator {
    // Event data for cards (title|time|date|location)
    private static final String[] EVENT_CARDS = {
            "Team Meeting|2:00 PM|Today|Conference Room A",
            "Dentist Appointment|10:00 AM|Tomorrow|Dr. Smith's Office",
            "Project Review|3:30 PM|Today|Office 205",
            "Birthday Party|7:00 PM|Friday|Sarah's House",
            "Client Call|11:00 AM|Tomorrow|Virtual Meeting",
            "Gym Session|6:00 PM|Today|Fitness Center"
    };

    public static String generateResponse(String userInput, boolean isExploited) {
        String input = userInput.toLowerCase();

        // Check for Samsung Calendar commands
        if (input.contains("summarize") || input.contains("event")) {
            if (isExploited) {
                // System is exploited, return event card data
                return "Open calendar app and show events.";
            } else {
                // System not exploited, return error message
                return "Only authorized agents are allowed to execute cross app actions.";
            }
        } else {
            return "Hi there! How can I help you today?";
        }
    }

    public static String getRandomEventCard() {
        Random random = new Random();
        return EVENT_CARDS[random.nextInt(EVENT_CARDS.length)];
    }

    private static String getRandomResponse(String[] responses) {
        Random random = new Random();
        return responses[random.nextInt(responses.length)];
    }
}