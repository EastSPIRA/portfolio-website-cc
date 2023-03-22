import org.gradle.internal.impldep.org.eclipse.jgit.lib.ObjectChecker.type

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        jcenter(){
            content {
                includeModule("com.todkars", "shimmer-recyclerview")
                in