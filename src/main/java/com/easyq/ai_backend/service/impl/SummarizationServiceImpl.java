package com.easyq.ai_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyq.ai_backend.ai.AiClient;
import com.easyq.ai_backend.dto.SummarizeRequest;
import com.easyq.ai_backend.dto.SummarizeResponse;
import com.easyq.ai_backend.service.SummarizationService;

@Service
public class SummarizationServiceImpl implements SummarizationService {

    @Autowired
    private AiClient aiClient;

    @Override
    public SummarizeResponse summarizeText(SummarizeRequest request) {

        String summary = aiClient.summarize(
                request.getText(),
                request.getPercentage()
        );

        return new SummarizeResponse(
                summary,
                request.getText().length(),
                summary.split("\\s+").length
        );
    }
}
