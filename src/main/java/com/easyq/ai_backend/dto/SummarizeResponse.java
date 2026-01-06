package com.easyq.ai_backend.dto;

public class SummarizeResponse {

    private String summary;
    private int originalLength;
    private int summaryLength;

    public SummarizeResponse(String summary, int originalLength, int summaryLength) {
        this.summary = summary;
        this.originalLength = originalLength;
        this.summaryLength = summaryLength;
    }

    public String getSummary() {
        return summary;
    }

    public int getOriginalLength() {
        return originalLength;
    }

    public int getSummaryLength() {
        return summaryLength;
    }
}
