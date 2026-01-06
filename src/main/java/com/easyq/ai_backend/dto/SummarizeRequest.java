package com.easyq.ai_backend.dto;

import jakarta.validation.constraints.*;

public class SummarizeRequest {

    @NotBlank(message = "Text must not be empty")
    private String text;

    @NotNull(message = "percentage is required")
    @Min(value = 1, message = "percentage must be at least 1")
    @Max(value = 100, message = "percentage must be at most 100")
    private Integer percentage;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
