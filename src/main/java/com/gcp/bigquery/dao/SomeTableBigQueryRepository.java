package com.gcp.bigquery.dao;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.gcp.bigquery.domain.ProductSku;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SomeTableBigQueryRepository implements DataRepository<ProductSku, Long> {

    // BigQuery client object provided by our autoconfiguration.
    private final BigQuery bigQuery;

    @Override
    public Optional<ProductSku> findById(Long id) throws InterruptedException {
        String query = "SELECT column FROM table;";
        var queryConfig = QueryJobConfiguration.newBuilder(query).build();
        // Run the query using the BigQuery object
        for (FieldValueList row : bigQuery.query(queryConfig).iterateAll()) {
            for (FieldValue val : row) {
                System.out.println(val);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<ProductSku> findAllByIds(Iterable<Long> ids) {
        return null;
    }

    @Override
    public <S extends ProductSku> S save(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends ProductSku> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }


}
