package edu.tcu.cs.hogwartsartifactsonline.client.ai.chat.dto;

import java.util.List;

/**
 * The ChatRequest record encapsulates the input to an AI model.
 * The input includes the AI model to use and a list of Message objects, AKA a prompt.
 * Each message in the prompt plays a different role in the conversation, from user questions and instructions to
 * examples and pertinent contextual information.
 * <p>
 * In a nutshell, the prompt helps the AI model "understand" the structure and intent of the user's query, leading to more precise and relevant responses.
 *
 * @param model    the AI model to use
 * @param messages the prompt information
 */
public record ChatRequest(String model,
                          List<Message> messages) {
}
