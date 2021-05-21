package com.example.demoBatchApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanShutdown {

    private static final Logger LOG = LoggerFactory.getLogger(BeanShutdown.class);

    public BeanShutdown() {
    }

    public final void shutdown() {
        LOG.info("+++++++++++++++ shutdown!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
