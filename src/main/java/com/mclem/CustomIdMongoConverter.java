package com.mclem;

import org.springframework.core.convert.converter.Converter;

public final class CustomIdMongoConverter {

    public static final class ReadConverter implements Converter<String, CustomId> {

        public CustomId convert(String source) {
            return new CustomId(source);
        }

    }

    public static final class WriteConverter implements Converter<CustomId, String> {

        public String convert(CustomId source) {
            return source.getValue();
        }

    }

}
