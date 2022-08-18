package com.gcp.bigquery.controller;

import com.saniaky.gcp.bigquery.config.AppConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gcp.bigquery.core.BigQueryTemplate;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final AppConfig.BigQueryFileGateway bigQueryFileGateway;
    private final BigQueryTemplate bigQueryTemplate;





}
