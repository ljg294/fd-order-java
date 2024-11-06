package com.fitdine.order.common.binder;

import org.springframework.core.convert.converter.Converter;
import com.fitdine.order.common.converter.DefaultDateTimeFormat;

import java.time.LocalDate;

public class LocalDateParamBinder implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {
        if (source.isEmpty()) {
            return null;
        }
        return LocalDate.parse(source, DefaultDateTimeFormat.DATE_FORMAT);
    }
}