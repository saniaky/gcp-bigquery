package com.gcp.bigquery.dao.mapper.custom;

import com.gcp.bigquery.dao.mapper.BigQueryTableMapper;
import com.gcp.bigquery.domain.ProductSku;
import com.google.cloud.bigquery.FieldValueList;

public class ProductSkuMapper implements BigQueryTableMapper<ProductSku> {

    @Override
    public ProductSku fromFieldList(FieldValueList values) {
        return ProductSku.builder()
                .id(values.get("id").getLongValue())
                .title(values.get("title").getStringValue())
                .build();
    }

}
