package com.example.demo.batch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.example.batch.entity.Product;

/**
 * {@link ItemWriter} to save a list of {@link Product}
 */
@Component
public class ProductWriter implements ItemWriter<Product> {

    @Override
    public void write(final List<? extends Product> products) throws Exception {
        // do nothing
    }

}
