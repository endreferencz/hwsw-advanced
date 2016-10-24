package com.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RepeatingAnnotations {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filter {
        String value();
    }

    @Filters({@Filter("filter1"), @Filter("filter2")})
    public interface Filterable {
    }

    public static void main(String[] args) {
        Filters filters = Filterable.class.getAnnotation(Filters.class);
        for (Filter filter : filters.value()) {
            System.out.println(filter.value());
        }
    }
}