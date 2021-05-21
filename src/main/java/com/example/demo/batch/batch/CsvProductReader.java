package com.example.demoBatchApplication.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.batch.entity.Product;

/**
 * Read from a csv file a list of products
 */
@Component
public class CsvProductReader extends FlatFileItemReader<Product> {

    @Autowired
    private CsvProductLineMapper csvProductLineMapper;

    @Override
    public void afterPropertiesSet() {
        setLineMapper(csvProductLineMapper);
    }

    /**
     * Sets the delimiter of csv fields
     *
     * @param delimiter delimiter of csv fields
     */
    public void setDelimiter(final String delimiter) {
        csvProductLineMapper.setDelimiter(delimiter);
    }

}
