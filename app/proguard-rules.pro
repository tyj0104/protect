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
#-include 'proguard-rules.pro'
#
#
#-dontwarn java.**
#-dontwarn sun.**
#-dontwarn android.**
#-dontwarn com.google.**
#-dontwarn okio.**
#
#
##Response


#代码混淆压缩比，在0~7之间，默认为5，一般不做修改
-optimizationpasses 5

#混合时不使用大小写混合，混合后的类名为小写
-dontusemixedcaseclassnames

#指定不去忽略非公共库的类
-dontskipnonpubliclibraryclasses

#这句话能够使我们的项目混淆后产生映射文件
#包含有类名->混淆后类名的映射关系
-verbose

#指定不去忽略非公共库的类
-dontskipnonpubliclibraryclassmembers

#不做预校验，preverify是proguard的四个步骤之一，Android不需要preverify，去掉这一步能够加快混淆速度。
-dontpreverify

#保留Annotation不混淆
-keepattributes *Annotation*,InnerClasses
#避免混淆泛型
-keepattributes Signature

#抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable


#指定混淆是采用的算法，后面的参数是一个过滤器
#这个过滤器是谷歌推荐的算法，一般不做更改
-optimizations !code/simplification/cast,!field/*,!class/merging/*
-ignorewarnings
-dontwarn android.**
-dontwarn org.apache.**
-dontwarn com.google.**
-dontwarn com.squareup.okhttp.**
-dontwarn okio.**
-dontwarn okhttp3.**
-dontwarn retrofit2.**

-keepattributes SourceFile,LineNumberTable

-keep class com.squareup.okhttp.** {*;}
-keep class okhttp3.** {*;}
-keep class okio.** {*;}
-keep class com.squareup.picasso.** {*;}
-keep class android.** {*;}
-keep class com.umeng.** {*;}
-keep class org.apache.** {*;}
-keep public class com.google.gson.**
-keep public class com.google.gson.** {public private protected *;}
-keep public class com.example.jay.myapplication.bean.** {*;}
-keepclassmembers class com.example.jay.myapplication.net.Response { <init>(); }
-keepclassmembers class * extends com.example.jay.myapplication.net.Response { <init>(); }
-keepclassmembernames class com.example.jay.myapplication.bean.AdBean$*{ *; }
-keepclassmembernames class com.example.jay.myapplication.bean.LoginBean$*{ *; }
-keepclassmembernames class com.example.jay.myapplication.bean.LoginModel$*{ *; }
-keepclassmembernames class com.example.jay.myapplication.bean.RecommendBean$*{ *; }
-keepclassmembernames class com.example.jay.myapplication.bean.RegisterModel$*{ *; }
-keepclassmembernames class com.example.jay.myapplication.bean.SuccessfulCaseBean$*{ *; }
-keepclassmembernames class com.example.jay.myapplication.bean.UserInfo$*{ *; }

-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;

}
