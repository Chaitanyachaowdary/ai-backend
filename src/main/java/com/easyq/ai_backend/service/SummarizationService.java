package com.easyq.ai_backend.service;

import com.easyq.ai_backend.dto.SummarizeRequest;
import com.easyq.ai_backend.dto.SummarizeResponse;

public interface SummarizationService {

    SummarizeResponse summarizeText(SummarizeRequest request);
}
