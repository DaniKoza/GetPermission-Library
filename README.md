# GetPermission-Library
Permission manager for android to ease with future projects development. The library has various options including dialogbox permissions, keep track on user's preferences and routing user to app settings in the smartphone.

## Integration
Add it in your root build.gradle at the end of repositories:
```Java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the dependency

```Java
	dependencies {
	    implementation 'com.github.DaniKoza:GetPermission-Library:1.0.1'
	}
```

## How To Use It
**1.** Create an instance of "GrantMe" class in your activity.
```Java
   GrantMe grantMe = new GrantMe(this);
   grantMe.setDebug(true); // This is optional, set true if you want to see the logs.
```

**2.** Create a response listener like this. you can create as many listeners as you like.
```Java
   private final ResponseListener listener = new ResponseListener() {
        @Override
        public void onGranted(boolean allGranted) {
            
        }

        @Override
        public void onNotGranted(String[] permissions) {
   
        }

        @Override
        public void onNeverAskAgain(String[] permissions) {   
                @Override
                public void onPositiveButton() {
                
                }

                @Override
                public void onNegativeButton() {
                
                }
            });
        }
    };
```

**3.** Override these methods to bind them in your activity.
```Java
   @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        grantMe.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        grantMe.onActivityResult(requestCode, resultCode, data);
    }
```

**4.** Now you can use the library's options, use the one's that are most suitable for you.
### NOTE: when using method without passing ResponseListener the libary will use the last used ResponseListener. 
* **Request Permissions:** request permissions from the user.
```Java
public void requestPermissions(@NonNull String[] permissions) 
```

```Java
public void requestPermissions(@NonNull String[] permissions, @NonNull ResponseListener resListener) 	
```

* **Ask Permissions From Setting:** request the user to grant permissions from the app's settings in the phone (with a dialog box). 
```Java
public void askPermissionsFromSetting(String msg, String[] permissions, DialogListener dialogListener)	
```
```Java
public void askPermissionsFromSetting(String msg, String[] permissions, @NonNull ResponseListener resListener, DialogListener dialogListener) 
```

*  **Request Permissions With Force:** request permissions from the user. if the user select's "don't ask me again", a dialog will open. if "re-try" button is selected the user will be transfered to app settings to grant the relevant permissions.
```Java
public void requestPermissionsWithForce(@NonNull String[] permissions, @NonNull ResponseListener resListener, String msg, DialogListener dialogListener) 
```
```Java
public void requestPermissionsWithForce(@NonNull String[] permissions, String msg, DialogListener dialogListener) 
```

* **Request Permissions With Dialog Box:** request permissions from the user with a dialog box first. If the user selects "agree" the grant permissions dialogs will show or the user will be transfered to app setting to grant the permissions in case he selects "don't ask me again".
```Java
public void requestPermissionsWithDialog(@NonNull String[] permissions, @NonNull GrantListener grantListener, String title, String msg, DialogListener dialogListener) 	
```
```Java
public void requestPermissionsWithDialog(@NonNull String[] permissions, String title, String msg, DialogListener dialogListener) 	
```










