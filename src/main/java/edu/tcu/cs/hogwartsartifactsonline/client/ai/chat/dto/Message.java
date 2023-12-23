package edu.tcu.cs.hogwartsartifactsonline.client.ai.chat.dto;

/**
 * The Message record has a conversational role (either "system", "user", or "assistant") and a textual content.
 */
public record Message(String role,
                      String content) {
}
