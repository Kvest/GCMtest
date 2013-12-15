package com.kvest.gcmtest.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.kvest.gcmtest.broadcastreceiver.GcmBroadcastReceiver;

/**
 * Created with IntelliJ IDEA.
 * User: Kvest
 * Date: 14.12.13
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public class GcmIntentService extends IntentService {
    public GcmIntentService() {
        super("GcmIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        // The getMessageType() intent parameter must be the intent you received
        // in your BroadcastReceiver.
        String messageType = gcm.getMessageType(intent);
        if (!messageType.isEmpty()) {
            Log.d("KVEST_TAG", "messageType=" + messageType);

            if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                Log.d("KVEST_TAG", "Received: ");
                for (String key : extras.keySet()) {
                    Log.d("KVEST_TAG", key + "=" + extras.get(key).toString());
                }
                Log.d("KVEST_TAG", "------------------");
            }
        }

        // Release the wake lock provided by the WakefulBroadcastReceiver.
        GcmBroadcastReceiver.completeWakefulIntent(intent);

    }
}
