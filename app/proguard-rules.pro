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

#我的项目混淆文件-----》文件名为proguard-project.txt

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
-dontwarn com.umeng.**
-dontwarn org.apache.**
-dontwarn com.j256.**
-dontwarn com.j256.**
-dontwarn com.sohu.**
-dontwarn com.baidu.**
-dontwarn com.google.zxing.**
-dontwarn com.tendcloud.tenddata.**
-dontwarn org.codehaus.jackson.**
-dontwarn com.tencent.smtt.**
-dontwarn com.google.gson.**
-dontwarn com.squareup.picasso.**
-dontwarn com.tv.filemanager.**
-dontwarn com.dangbei.www.okhttp.**
-dontwarn com.squareup.okhttp.**
-dontwarn okio.**
-dontwarn okhttp3.**
-dontwarn org.greenrobot.eventbus.**
-keep class org.greenrobot.eventbus.** {*;}
-keepattributes SourceFile,LineNumberTable
-keep class com.dangbeimarket.** {*;}
-keep class com.question.** {*;}
-keep class com.dangbei.www.okhttp.** {*;}
-keep class com.squareup.okhttp.** {*;}
-keep class okhttp3.** {*;}
-keep class okio.** {*;}
-keep class com.squareup.picasso.** {*;}
-keep class com.tv.filemanager.**{*;}
-keep class android.** {*;}
-keep class com.umeng.** {*;}
-keep class org.apache.** {*;}
-keep class com.j256.** {*;}
-keep class com.sohu.** {*;}
-keep class com.baidu.**
#-keep class com.google.gson.**{*;}
-keep class com.google.zxing.**{*;}

-keep public class com.tendcloud.tenddata.** { public protected *;}

-keep class com.dangbeimarket.download.me.database.DownloadApkEntity {*;}



-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
    public <fields>;
}
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.examples.android.model.** { *; }

-keep public class pl.droidsonroids.gif.GifIOException{<init>(int);}

-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
public static java.lang.String TABLENAME;
}

#######################greenDao混淆######################

-keep class **$Properties
-dontwarn org.greenrobot.greendao.database.**
-dontwarn org.greenrobot.greendao.rx.**

#######################greenDao混淆######################

#######################广告混淆##########################
-dontwarn com.db.android.api.**
-keep class com.db.android.api.** {*;}


#######################广告混淆##########################

# *************  Retrolamdba START *************
# hide warnings caused by Retrolamdba
-dontwarn java.lang.invoke.*
# *************  Retrolamdba END *************


#######################友盟推送#########################

-dontwarn com.taobao.**
-dontwarn anet.channel.**
-dontwarn anetwork.channel.**
-dontwarn org.android.**
-dontwarn org.apache.thrift.**
-dontwarn com.xiaomi.**
-dontwarn com.huawei.**

-keepattributes *Annotation*

-keep class com.taobao.** {*;}
-keep class org.android.** {*;}
-keep class anet.channel.** {*;}
-keep class com.umeng.** {*;}
-keep class com.xiaomi.** {*;}
-keep class com.huawei.** {*;}
-keep class org.apache.thrift.** {*;}
-keep class org.json.** { *; }
-keep public class **.R$*{
   public static final int *;
}
#######################友盟推送#########################

#######################TalkingData####################
-dontwarn com.tendcloud.tenddata.**
-keep class com.tendcloud.** {*;}
-keep public class com.tendcloud.tenddata.** { public protected *;}
-keepclassmembers class com.tendcloud.tenddata.**{
public void *(***);
}
-keep class com.talkingdata.sdk.TalkingDataSDK {public *;}
-keep class com.apptalkingdata.** {*;}
-keep class dice.** {*; }
-dontwarn dice.**
#######################TalkingData####################

#ijk播放器
-keep class tv.danmaku.ijk.** { *; }
-dontwarn tv.danmaku.ijk.**

#友盟统计
-keepclassmembers class * {
   public <init> (org.json.JSONObject);
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#友盟统计 end

#talkingdata
-dontwarn com.tendcloud.tenddata.**
-keep class com.tendcloud.** {*;}
-keep public class com.tendcloud.tenddata.** { public protected *;}
-keepclassmembers class com.tendcloud.tenddata.**{
public void *(***);
}
-keep class com.talkingdata.sdk.TalkingDataSDK {public *;}
-keep class com.apptalkingdata.** {*;}
-keep class dice.** {*; }
-dontwarn dice.**
#talkingdata end

-keep class com.dangbei.euthenia.**{*;}

#自更新
-dontwarn com.dangbei.downloader.**
-keep class com.dangbei.downloader.** {*;}

-dontwarn com.dangbei.update.**
-keep class com.dangbei.update.** {*;}

-keep public class **.R$*{
    public static final int *;
}

######################glide##start##########################
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
######################glide##end##########################

######################gson##end##########################
-keep public class com.google.gson.**
-keep public class com.google.gson.** {public private protected *;}

-keepattributes Signature
-keepattributes *Annotation*
-keep public class com.dangbei.haqu.db.** {*;}
-keep public class com.dangbei.haqu.model.** {*;}

######################gson##end##########################

