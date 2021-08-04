package com.lobster.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface Constants {
    String DEFAULT_LANGUAGE = "en";

    @Getter
    @AllArgsConstructor
    enum Validation {
        NAME_LENGTH(100),
        SUMMARY_LENGTH(255),
        DESCRIPTION_LENGTH(1024),
        PRODUCT_SPECIFICATION_LENGTH(255);
        private final int length;
    }

    enum ErrorCode{
        NOT_FOUND
    }

}
