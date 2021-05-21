package com.example.demo.batch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The type Batch sample properties.
 */
@ConfigurationProperties(prefix = "app.sample")
public class BatchSampleProperties {


    private Integer chunkSize;

    private String delimiter;

    private String inputFile;

    /**
     * Gets chunk size.
     *
     * @return the chunk size
     */
    public Integer getChunkSize() {
        return chunkSize;
    }

    /**
     * Sets chunk size.
     *
     * @param chunkSize the chunk size
     */
    public void setChunkSize(Integer chunkSize) {
        this.chunkSize = chunkSize;
    }

    /**
     * Gets delimiter.
     *
     * @return the delimiter
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * Sets delimiter.
     *
     * @param delimiter the delimiter
     */
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Gets input file.
     *
     * @return the input file
     */
    public String getInputFile() {
        return inputFile;
    }

    /**
     * Sets input file.
     *
     * @param inputFile the input file
     */
    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

}
