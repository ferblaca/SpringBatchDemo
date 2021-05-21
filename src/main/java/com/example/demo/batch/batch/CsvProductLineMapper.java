package com.example.demoBatchApplication.batch;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.example.batch.entity.Product;

/**
 * {@link LineMapper} which maps a csv line with a {@link Product}
 */
@Component
public class CsvProductLineMapper extends DefaultLineMapper<Product> {

    private final DelimitedLineTokenizer tokenizer;

    /**
     * Constructor
     */
    public CsvProductLineMapper() {
        this.tokenizer = new DelimitedLineTokenizer();
        this.tokenizer.setNames("ID", "NAME");

        this.setLineTokenizer(this.tokenizer);

        FieldSetMapper<Product> fieldSetMapper = new FieldSetMapper<Product>() {

            @Override
            public Product mapFieldSet(final FieldSet fieldSet) throws BindException {
                Product product = new Product();
                product.setId(fieldSet.readString(0));
                product.setName(fieldSet.readString(1));

                return product;
            }
        };

        this.setFieldSetMapper(fieldSetMapper);
    }

    /**
     * Sets the delimiter between the product fields
     */
    public final void setDelimiter(final String delimiter) {
        tokenizer.setDelimiter(delimiter);
    }

    @Override
    public final void setLineTokenizer(LineTokenizer tokenizer) {
        super.setLineTokenizer(tokenizer);
    }

    @Override
    public final void setFieldSetMapper(FieldSetMapper<Product> fieldSetMapper) {
        super.setFieldSetMapper(fieldSetMapper);
    }

}
