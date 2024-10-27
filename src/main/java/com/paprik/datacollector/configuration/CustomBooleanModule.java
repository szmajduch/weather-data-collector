package com.paprik.datacollector.configuration;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.paprik.datacollector.mapper.BooleanDeserializer;

public class CustomBooleanModule extends SimpleModule {
    public CustomBooleanModule() {
        addDeserializer(Boolean.class, new BooleanDeserializer());
        addDeserializer(boolean.class, new BooleanDeserializer());  // for primitive booleans
    }
}
