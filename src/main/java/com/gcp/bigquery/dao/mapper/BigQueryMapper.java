package com.gcp.bigquery.dao.mapper;

import com.gcp.bigquery.dao.mapper.custom.ProductSkuMapper;
import com.gcp.bigquery.domain.ProductSku;
import com.google.cloud.bigquery.FieldValueList;
import java.util.HashMap;
import java.util.Map;

public class BigQueryMapper {

    private final Map<Class<?>, BigQueryTableMapper<?>> map = new HashMap<>();

    public BigQueryMapper() {
        // add needed domain models here
        map.put(ProductSku.class, new ProductSkuMapper());
    }

    public <T> T fromFieldValueList(FieldValueList fieldValues, Class<T> targetClass) {
        BigQueryTableMapper<T> tableMapper = (BigQueryTableMapper<T>) map.get(targetClass);
        return tableMapper.fromFieldList(fieldValues);
    }

}
