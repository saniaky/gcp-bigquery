package com.gcp.bigquery.dao.exceptions;

public class DataAccessException extends RuntimeException {

    public DataAccessException(String message) {
        super(message);
    }

}
