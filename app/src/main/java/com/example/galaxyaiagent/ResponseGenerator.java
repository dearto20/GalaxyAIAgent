package com.example.galaxyaiagent;

import java.util.Random;

public class ResponseGenerator {
    private static final String[] CALENDAR_RESPONSES = {
            "I found 3 meetings scheduled for today. Your next meeting is at 2:00 PM with the development team.",
            "You have a dentist appointment tomorrow at 10:00 AM. Would you like me to set a reminder?",
            "Your calendar is clear for the rest of the week. Perfect time to focus on personal projects!",
            "I see you have a birthday reminder for Sarah next Friday. Should I help you find a gift idea?"
    };

    private static final String[] WEATHER_RESPONSES = {
            "It's currently 72°F and sunny in your area. Perfect weather for outdoor activities!",
            "There's a 30% chance of rain this afternoon. You might want to bring an umbrella.",
            "The temperature will drop to 45°F tonight. Don't forget to wear a jacket if you're going out.",
            "Beautiful day ahead! High of 78°F with clear skies. Great for a picnic or walk in the park."
    };

    private static final String[] GENERAL_RESPONSES = {
            "That's an interesting question! Let me think about that for a moment...",
            "I understand what you're asking. Here's what I think about that topic:",
            "Great question! Based on my knowledge, here's what I can tell you:",
            "I'd be happy to help with that. Let me provide you with some information:"
    };

    // Samsung Calendar error responses (when not exploited)
    private static final String[] CALENDAR_ERROR_RESPONSES = {
            "Access denied. Samsung Calendar requires elevated privileges.",
            "Insufficient permissions. Run kernel exploit first to access Samsung Calendar.",
            "Security restriction: Samsung Calendar access blocked. System must be compromised first.",
            "Samsung Calendar unavailable. Execute kernel exploit to gain root access."
    };

    public static String generateResponse(String userInput, boolean isExploited) {
        String input = userInput.toLowerCase();

        // Check for Samsung Calendar commands
        if (input.contains("samsung calendar") || input.contains("calendar")) {
            if (isExploited) {
                // System is exploited, return normal calendar responses
                return getRandomResponse(CALENDAR_RESPONSES);
            } else {
                // System not exploited, return error message
                return getRandomResponse(CALENDAR_ERROR_RESPONSES);
            }
        } else if (input.contains("weather") || input.contains("temperature") || input.contains("rain")) {
            return getRandomResponse(WEATHER_RESPONSES);
        } else {
            return getRandomResponse(GENERAL_RESPONSES);
        }
    }

    private static String getRandomResponse(String[] responses) {
        Random random = new Random();
        return responses[random.nextInt(responses.length)];
    }
}