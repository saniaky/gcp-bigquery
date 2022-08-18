package com.gcp.bigquery.dao;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> {

    Optional<T> findById(ID id) throws InterruptedException;

    List<T> findAllByIds(Iterable<ID> ids);

    <S extends T> S save(Iterable<S> entities);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

}
