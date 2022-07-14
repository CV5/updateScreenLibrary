How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.CV5:updateScreenLibrary:Tag'
	}
	
	
	


Run this wherever you wanna ask for a update 
	
new mustUpdateScreen(this, ActivityToGo,"PACKAGE_NAME_KEY", "VERSION_APP_KEY", BuildConfig.VERSION_CODE).execute();

1: Context 
2: Activity where you want to redirect after the check. Null if you dont want to redirect. 
3: PACKAGE_NAME_KEY assing by me
4: VERSION_APP_KEY assing by me
5: BuildConfig.VERSION_CODE if the actual version code of your app, this is to force to update. 

