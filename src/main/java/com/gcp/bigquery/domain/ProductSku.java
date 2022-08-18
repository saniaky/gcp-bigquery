package com.gcp.bigquery.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSku {

    private Long id;
    private String title;

}
