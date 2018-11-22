package com.broadcasts.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * an annotation that determines the Broadcast Receiver data SCHEME in manifest, and
 * it is also the same as calling {@code IntentFilter.addDataScheme(String)}
 * <p>
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BroadcastReceiverDataScheme {

    String value();
}
