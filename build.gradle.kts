import org.gradle.internal.impldep.org.eclipse.jgit.lib.ObjectChecker.type

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        jcenter(){
            content {
                includeModule("com.todkars", "shimmer-recyclerview")
                includeModule("com.facebook.shimmer", "shimmer")
                includeModule("com.toptoche.searchablespinner", "searchablespinnerlibrary")
            }
        }
        mavenCentral()
        maven ( url ="https://jitpack.io" )

    }
    dependencies {
        classpath ("com.android.tools.build:gradle:4.2.1")
    