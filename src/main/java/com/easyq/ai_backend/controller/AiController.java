package com.easyq.ai_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.easyq.ai_backend.dto.SummarizeRequest;
import com.easyq.ai_backend.dto.SummarizeResponse;
import com.easyq.ai_backend.service.SummarizationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/ai")
public class AiController {

    @Autowired
    private SummarizationService summarizationService;

    @PostMapping("/summarize")
    public SummarizeResponse summarizeText(
            @Valid @RequestBody SummarizeRequest request) {

        return summarizationService.summarizeText(request);
    }
}
