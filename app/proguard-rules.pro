# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in the Android Studio default proguard file.

# Keep Room entity classes
-keep class com.example.mylist.data.** { *; }

# Kotlin
-dontwarn kotlin.**
