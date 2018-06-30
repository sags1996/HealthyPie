package com.example.ashu.healthypie;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirbseMsggService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        String title=remoteMessage.getNotification().getTitle();
        String body=remoteMessage.getNotification().getBody();

        MyNotificationManager.getMyInsatnce(getApplicationContext())
                .displayNotification(title,body);

    }
}

