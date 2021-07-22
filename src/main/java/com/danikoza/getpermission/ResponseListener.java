package com.danikoza.getpermission;

public interface ResponseListener {
    void onGranted(boolean allGranted);

    void onNotGranted(String[] permissions);

    void onNeverAskAgain(String[] permissions);
}
