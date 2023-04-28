package com.severalcircles.bluesky.fairplay;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FairplayProtected {
    boolean value() default true;
}
