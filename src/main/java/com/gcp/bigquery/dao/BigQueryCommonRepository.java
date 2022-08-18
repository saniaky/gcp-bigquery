package com.gcp.bigquery.dao;

import com.gcp.bigquery.dao.exceptions.DataAccessException;
import com.gcp.bigquery.dao.mapper.BigQueryMapper;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.TableResult;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BigQueryCommonRepository<T, ID> implements DataRepository<T, ID> {

    // BigQuery client object provided by our autoconfiguration.
    private final BigQuery bigQuery;
    private final String tableName;
    private final Class<T> targetClass;
    private final BigQueryMapper mapper;

    @Override
    public Optional<T> findById(ID id) throws InterruptedException {
        String query = "SELECT * FROM `@tableName` LIMIT 1;";
        QueryJobConfiguration queryConfig = QueryJobConfiguration
                .newBuilder(query)
                .addNamedParameter("tableName", QueryParameterValue.string(tableName))
                .build();
        TableResult tableResult = bigQuery.query(queryConfig);
        if (tableResult.getTotalRows() == 0) {
            return Optional.empty();
        }
        if (tableResult.getTotalRows() > 1) {
            throw new DataAccessException("Multiple rows returned.");
        }
        FieldValueList fieldValues = tableResult.iterateAll().iterator().next();
        T result = mapper.fromFieldValueList(fieldValues, targetClass);
        return Optional.of(result);
    }

    @Override
    public List<T> findAllByIds(Iterable<ID> ids) {
        return null;
    }

    @Override
    public <S extends T> S save(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

}
