package com.kvest.gcmtest.broadcastreceiver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;

/**
 * Created with IntelliJ IDEA.
 * User: Kvest
 * Date: 15.12.13
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class AlternativeGcmBroadcastReceiver extends GcmBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
        // The getMessageType() intent parameter must be the intent you received
        // in your BroadcastReceiver.
        String messageType = gcm.getMessageType(intent);
        if (!messageType.isEmpty()) {
            Log.d("KVEST_TAG", "Alternative messageType=" + messageType);

            if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                Log.d("KVEST_TAG", "Alternative Received: ");
                for (String key : intent.getExtras().keySet()) {
                    Log.d("KVEST_TAG", key + "=" + intent.getExtras().get(key).toString());
                }
                Log.d("KVEST_TAG", "------------------");
            }
        }

        setResultCode(Activity.RESULT_OK);
    }
}
