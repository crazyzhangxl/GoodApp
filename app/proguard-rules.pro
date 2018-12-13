
#-------------------------------------------定制化区域----------------------------------------------
#---------------------------------1.实体类---------------------------------


#-------------------------------------------------------------------------

#---------------------------------2.第三方包-------------------------------
-dontwarn javax.annotation.**
-dontwarn javax.inject.**
# OkHttp3
-dontwarn okhttp3.logging.**
-keep class okhttp3.internal.**{*;}
-dontwarn okio.**
# Retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
# RxJava RxAndroid
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

#ok3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**
-dontwarn okhttp3.internal.platform.ConscryptPlatform

#rxjava
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
 long producerIndex;
 long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

#okio
-dontwarn okio.**
-keep class okio.**{*;}

#glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
#glide如果你的API级别<=Android API 27 则需要添加
-dontwarn com.bumptech.glide.load.resource.bitmap.VideoDecoder

#picasso
-keep class com.parse.*{ *; }
-dontwarn com.parse.**
-dontwarn com.squareup.picasso.**
-keepclasseswithmembernames class * {
    native <methods>;
}

#fastjson
-dontwarn com.alibaba.fastjson.**
-keep class com.alibaba.fastjson.**{*; }

#eventBus
-keep class org.greenrobot.** {*;}
-keep class de.greenrobot.** {*;}
-keepclassmembers class ** {
    public void onEvent*(**);
    void onEvent*(**);
}

#BRVAH混淆
-keep class com.chad.library.adapter.** {
*;
}
-keep public class * extends com.chad.library.adapter.base.BaseQuickAdapter
-keep public class * extends com.chad.library.adapter.base.BaseViewHolder
-keepclassmembers  class **$** extends com.chad.library.adapter.base.BaseViewHolder {
     <init>(...);
}

#指定继承自某个类的所有类
-dontwarn com.roughike.bottombar.BottomNavigationBehavior

# 高德地图
-dontwarn com.amap.api.**
-dontwarn com.a.a.**
-dontwarn com.autonavi.**
-keep class com.amap.api.**  {*;}
-keep class com.autonavi.**  {*;}
-keep class com.a.a.**  {*;}

#butterknife
-dontwarn butterknife.internal.**
-keep class butterknife.** { *; }
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#fastjson
-dontwarn com.alibaba.fastjson.**
-keep public class com.alibaba.fastjson.**{*;}

#zingscan
-dontwarn com.google.**
-keep class com.google.** {*;}

#joda混淆
-dontwarn org.joda.convert.**
-dontwarn org.joda.time.**
-keep class org.joda.time.** { *; }
-keep interface org.joda.time.** { *;}

#blugy抗混淆配置
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}
-keep class android.support.**{*;}

##支付宝
#-dontwarn com.alipay.**
#-keep class com.alipay.android.app.IAliPay{*;}
#-keep class com.alipay.android.app.IAlixPay{*;}
#-keep class com.alipay.android.app.IRemoteServiceCallback{*;}
#-keep class com.alipay.android.app.lib.ResourceMap{*;}


# 萤火虫SDK
#-dontwarn com.ezviz.player.**
#-keep class com.ezviz.player.** { *;}
#
#-dontwarn com.ezviz.statistics.**
#-keep class com.ezviz.statistics.** { *;}
#
#-dontwarn com.ezviz.stream.**
#-keep class com.ezviz.stream.** { *;}
#
#-dontwarn com.ezviz.hcnetsdk.**
#-keep class com.ezviz.hcnetsdk.** { *;}
#
#
#-dontwarn com.ezviz.opensdk.**
#-keep class com.ezviz.opensdk.** { *;}
#
#-dontwarn com.hik.**
#-keep class com.hik.** { *;}
#
#-dontwarn com.hikvision.**
#-keep class com.hikvision.** { *;}
#
#-dontwarn com.videogo.**
#-keep class com.videogo.** { *;}
#
#-dontwarn org.MediaPlayer.PlayM4.**
#-keep class org.MediaPlayer.PlayM4.** { *;}
#
#-dontwarn com.sun.jna.**
#-keep class com.sun.jna.**{*;}

#Gson混淆配置
-keepattributes Annotation
-keep class sun.misc.Unsafe { *; }
-keep class com.idea.fifaalarmclock.entity.*
-keep class com.google.gson.stream.* { *; }

#引用mars的xlog，混淆配置
-keep class com.tencent.mars.** {
 public protected private *;
}

#eventbus打包混淆
-keepattributes *Annotation*
-keepclassmembers class ** {
@org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
<init>(java.lang.Throwable);
}

#-------------------------------------------------------------------------


#---------------------------------3.与js互相调用的类------------------------
#TODO 我的工程里没有。。。
#-------------------------------------------------------------------------


#---------------------------------4.反射相关的类和方法-----------------------
# aviloading
-keep class com.wang.avi.** { *; }
-keep class com.wang.avi.indicators.** { *; }

#----------------------------------------------------------------------------


#-------------------------------------------基本不用动区域--------------------------------------------
#---------------------------------基本指令区----------------------------------
#代码混淆压缩比，在0和7之间，默认为5，一般不需要改
-optimizationpasses 5

#混淆时不使用大小写混合，混淆后的类名为小写
-dontusemixedcaseclassnames

#指定不去忽略非公共的库的类
-dontskipnonpubliclibraryclasses

#指定不去忽略非公共的库的类的成员
-dontskipnonpubliclibraryclassmembers

#不做预校验，preverify是proguard的4个步骤之一，Android不需要preverify，去掉这一步可加快混淆速度
-dontpreverify

#有了verbose这句话，混淆后就会生成映射文件，包含有类名->混淆后类名的映射关系，然后使用printmapping指定映射文件的名称
-verbose
-printmapping proguardMapping.txt

#指定混淆时采用的算法，后面的参数是一个过滤器，这个过滤器是谷歌推荐的算法，一般不改变
-optimizations !code/simplification/arithmetic, !field/*, !class/merging/*

#保护代码中的Annotation不被混淆，这在JSON实体映射时非常重要，比如fastJson
-keepattributes *Annotation*

#避免混淆泛型，这在JSON实体映射时非常重要，比如fastJson
-keepattributes Signature

#抛出异常时保留代码行号，在第6章异常分析中我们提到过
-keepattributes SourceFile, LineNumberTable




#----------------------------------------------------------------------------

#---------------------------------默认保留区---------------------------------
#忽略警告
-dontwarn com.lippi.recorder.utils**
#保留一个完整的包
-keep class com.lippi.recorder.utils.** {
*;
}
-keep class  com.lippi.recorder.utils.AudioRecorder{*;}

#保留了继承自Activity、Application这些类的子类，因为这些子类，都有可能被外部调用
#比如说，第一行就保证了所有Activity的子类不要被混淆
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference

#support-v4包
-dontwarn android.support.v4.**
-keep class android.support.v4.app.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep class android.support.v4.** { *; }

#support-v7包
-dontwarn android.support.v7.**
-keep class android.support.v7.internal.** { *; }
-keep interface android.support.v7.internal.** { *; }
-keep class android.support.v7.** { *; }

#support design
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }


#保留在Activity中的方法参数是view的方法，从而我们在layout里面编写onClick就不会被影响
-keepclassmembers class * extends android.app.Activity {
    public void * (android.view.View);
}

#枚举类不能被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#保留自定义控件（继承自View）不被混淆
-keep public class * extends android.view.View {
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

#保留Parcelable序列化的类不被混淆
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

#保留Serializable序列化的类不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# databinding配置
-dontwarn android.databinding.**
-keep class android.databinding.** { *; }





#关闭 Log日志
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
    public static *** e(...);
    public static *** w(...);
}


#对于R（资源）下的所有类及其方法，都不能被混淆
-keep class **.R$* {
    *;
}

#对于带有回调函数onXXEvent的，不能被混淆
-keepclassmembers class * {
    void * (**On*Event);
}

#webview
-keepclassmembers class fqcn.of.javascript.interface.for.Webview {
   public *;
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, jav.lang.String);
}


# 内部类混淆配置
-keep class com.manjay.housebox.activity.CityListActivity$*{
        <fields>;
        <methods>;
}
-keepclassmembers class com.manjay.housebox.activity.CityListActivity$*{*;}
-keep class com.manjay.housebox.map.MapActivity$*{
        <fields>;
        <methods>;
}
-keepclassmembers class com.manjay.housebox.map.MapActivity$*{*;}

# 这段话的意思是把[Package]包名中的class类中的所有成员和方法都不混淆，记录本次bug



#----------------------------------------------------------------------------
#忽略警告
-ignorewarnings
-dontwarn

