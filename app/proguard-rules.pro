# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/jay/android-sdk-macosx/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-include 'proguard_annotations.pro'

-dontwarn java.**
-dontwarn sun.**

-dontwarn android.**
-dontwarn com.google.**

-dontwarn okio.**
-dontwarn retrofit2.**


#Response
-keepclassmembers class com.example.jay.myapplication.net.Response { <init>(); }
-keepclassmembers class * extends com.example.jay.myapplication.net.Response { <init>(); }



-keepclassmembernames class com.example.jay.myapplication.bean.AdBean$*{ *; }
-keepclassmembernames class com.example.jay.myapplication.bean.LoginBean$*{ *; }
-keepclassmembernames class com.example.jay.myapplication.bean.LoginModel$*{ *; }
-keepclassmembernames class com.example.jay.myapplication.bean.RecommendBean$*{ *; }
-keepclassmembernames class com.example.jay.myapplication.bean.RegisterModel$*{ *; }
-keepclassmembernames class com.example.jay.myapplication.bean.SuccessfulCaseBean$*{ *; }
-keepclassmembernames class com.example.jay.myapplication.bean.UserInfo$*{ *; }

