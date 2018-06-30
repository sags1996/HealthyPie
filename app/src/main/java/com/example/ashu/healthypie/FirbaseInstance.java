package com.example.ashu.healthypie;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirbaseInstance extends FirebaseInstanceIdService{
    @Override
    public void onTokenRefresh() {
        String refreshedToken= FirebaseInstanceId.getInstance().getToken();
        Log.d("My Token",""+refreshedToken);
        Helper.firebaseToken=refreshedToken;
    }
}
