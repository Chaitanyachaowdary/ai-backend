package com.easyq.ai_backend.ai;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class MockAiClient implements AiClient {

    @Override
    public String summarize(String text, int percentage) {

        // Split text into sentences
        String[] sentences = text.split("(?<=[.!?])\\s+");

        if (sentences.length == 1) {
            return sentences[0];
        }

        // Stop words
        Set<String> stopWords = Set.of(
                "the", "is", "a", "an", "and", "or", "of", "to", "in",
                "on", "for", "with", "as", "by", "at", "from"
        );

        // Word frequency
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String sentence : sentences) {
            for (String word : sentence.toLowerCase().split("\\W+")) {
                if (!stopWords.contains(word) && word.length() > 2) {
                    wordFrequency.put(word,
                            wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        // Sentence scoring
        Map<String, Integer> sentenceScore = new LinkedHashMap<>();
        for (String sentence : sentences) {
            int score = 0;
            for (String word : sentence.toLowerCase().split("\\W+")) {
                score += wordFrequency.getOrDefault(word, 0);
            }
            sentenceScore.put(sentence, score);
        }

        // Number of sentences to return
        int summaryCount = Math.max(1, (sentences.length * percentage) / 100);

        // Pick top sentences
        return sentenceScore.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(summaryCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(" "));
    }
}
