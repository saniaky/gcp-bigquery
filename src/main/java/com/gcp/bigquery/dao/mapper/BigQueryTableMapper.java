package com.gcp.bigquery.dao.mapper;

import com.google.cloud.bigquery.FieldValueList;

public interface BigQueryTableMapper<T> {

    T fromFieldList(FieldValueList values);

}
