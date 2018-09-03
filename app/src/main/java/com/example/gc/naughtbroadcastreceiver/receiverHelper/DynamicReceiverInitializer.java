package com.example.gc.naughtbroadcastreceiver.receiverHelper;

import android.content.BroadcastReceiver;

import com.broadcasts.annotations.BroadcastReceiverActions;
import com.broadcasts.annotations.BroadcastReceiverDataAuthority;
import com.broadcasts.annotations.BroadcastReceiverDataMimeType;
import com.broadcasts.annotations.BroadcastReceiverDataPath;
import com.broadcasts.annotations.BroadcastReceiverDataScheme;
import com.broadcasts.annotations.BroadcastReceiverEnabled;
import com.broadcasts.annotations.BroadcastReceiverPermission;

/**
 * an annotation scanner function
 * <p>
 * Created by Gaurav.
 */
class DynamicReceiverInitializer {

    DynamicReceiver apply(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver.getClass().getAnnotations().length > 0) {
            return dynamicReceiverFromAnnotations(broadcastReceiver);
        } else {
            return new DynamicReceiver(broadcastReceiver);
        }
    }

    private DynamicReceiver dynamicReceiverFromAnnotations(BroadcastReceiver receiver) {
        DynamicReceiver dynamicReceiver = new DynamicReceiver(receiver);
        Class<?> receiverClass = receiver.getClass();
        scanForActions(dynamicReceiver, receiverClass);
        scanForPermission(dynamicReceiver, receiverClass);
        scanForEnabled(dynamicReceiver, receiverClass);
        scanForDataAuthority(dynamicReceiver, receiverClass);
        scanForDataMimeType(dynamicReceiver, receiverClass);
        scanForDataPath(dynamicReceiver, receiverClass);
        scanForDataScheme(dynamicReceiver, receiverClass);
        return dynamicReceiver;
    }

    private void scanForActions(DynamicReceiver dynamicReceiver, Class<?> receiverClass) {
        BroadcastReceiverActions actions = receiverClass.getAnnotation(BroadcastReceiverActions.class);
        if (actions != null) {
            addActionsValues(dynamicReceiver, actions.value());
        }
    }

    private void addActionsValues(DynamicReceiver dynamicReceiver, String[] actions) {
        for (String action : actions) {
            dynamicReceiver.action(action);
        }
    }

    private void scanForPermission(DynamicReceiver dynamicReceiver, Class<?> receiverClass) {
        BroadcastReceiverPermission permission = receiverClass.getAnnotation(BroadcastReceiverPermission.class);
        if (permission != null) {
            dynamicReceiver.permission(permission.value());
        }
    }

    private void scanForEnabled(DynamicReceiver dynamicReceiver, Class<?> receiverClass) {
        BroadcastReceiverEnabled enabled = receiverClass.getAnnotation(BroadcastReceiverEnabled.class);
        if (enabled != null) {
            dynamicReceiver.enabled(enabled.value());
        }
    }

    private void scanForDataAuthority(DynamicReceiver dynamicReceiver, Class<?> receiverClass) {
        BroadcastReceiverDataAuthority authority = receiverClass.getAnnotation(BroadcastReceiverDataAuthority.class);
        if (authority != null) {
            dynamicReceiver.dataAuthority(authority.host(), authority.port());
        }
    }

    private void scanForDataMimeType(DynamicReceiver dynamicReceiver, Class<?> receiverClass) {
        BroadcastReceiverDataMimeType type = receiverClass.getAnnotation(BroadcastReceiverDataMimeType.class);
        if (type != null) {
            dynamicReceiver.dataMimeType(type.value());
        }
    }

    private void scanForDataPath(DynamicReceiver dynamicReceiver, Class<?> receiverClass) {
        BroadcastReceiverDataPath path = receiverClass.getAnnotation(BroadcastReceiverDataPath.class);
        if (path != null) {
            dynamicReceiver.dataPath(path.path(), path.type());
        }
    }

    private void scanForDataScheme(DynamicReceiver dynamicReceiver, Class<?> receiverClass) {
        BroadcastReceiverDataScheme scheme = receiverClass.getAnnotation(BroadcastReceiverDataScheme.class);
        if (scheme != null) {
            dynamicReceiver.dataScheme(scheme.value());
        }
    }


}
