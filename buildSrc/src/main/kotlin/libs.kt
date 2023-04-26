@file:Suppress("ClassName")

object versions {
    const val ksp = "1.8.20-1.0.11"
    const val versionPlugin = "0.46.0"
    const val core = "1.9.0"
    const val lifecycle = "2.6.1"
    const val coroutines = "1.7.0-RC"
    const val composeCompiler = "1.4.6"
    const val compose = "1.4.6"
    const val composeTest = "1.4.2"
    const val dagger = "2.45"
    const val paging = "3.1.1"
    const val pagingCompose = "1.0.0-alpha18"
    const val accompanist = "0.25.1"
    const val retrofit = "2.9.0"
    const val moshi = "1.14.0"
    const val room = "2.5.1"
    const val mockk = "1.13.5"
    const val material3 = "1.1.0-rc01"
    const val activityCompose = "1.7.1"
    const val navigationCompose = "2.5.3"
    const val composeBom = "2023.04.01"
}

object libs {
    val android = listOf(
        "androidx.core:core-ktx:${versions.core}",
        "androidx.lifecycle:lifecycle-runtime-ktx:${versions.lifecycle}"
    )
    val compose = listOf(
        Bom("androidx.compose:compose-bom:${versions.composeBom}"),
        "androidx.compose.ui:ui-tooling-preview",
        "androidx.compose.ui:ui-tooling",
        "androidx.compose.material3:material3:${versions.material3}",
        "androidx.activity:activity-compose:${versions.activityCompose}",
        "androidx.navigation:navigation-compose:${versions.navigationCompose}",
    )
    val paging = listOf(
        "androidx.paging:paging-runtime-ktx:${versions.paging}",
        "androidx.paging:paging-compose:${versions.pagingCompose}"
    )
    const val permissionsCompose =
        "com.google.accompanist:accompanist-permissions:${versions.accompanist}"

    const val swipeRefreshCompose =
        "com.google.accompanist:accompanist-swiperefresh:${versions.accompanist}"

    const val palette =
        "androidx.palette:palette-ktx:1.0.0"

    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${versions.coroutines}"

    const val dagger =
        "com.google.dagger:dagger:${versions.dagger}"

    const val daggerCompiler =
        "com.google.dagger:dagger-compiler:${versions.dagger}"

    val retrofit = listOf(
        "com.squareup.retrofit2:retrofit:${versions.retrofit}",
        "com.squareup.retrofit2:converter-moshi:${versions.retrofit}",
        "com.squareup.okhttp3:logging-interceptor:4.10.0",
        "com.squareup.moshi:moshi-adapters:${versions.moshi}",
    )
    val moshiCompiler = "com.squareup.moshi:moshi-kotlin-codegen:${versions.moshi}"
    val room = listOf(
        "androidx.room:room-ktx:${versions.room}",
        "androidx.room:room-runtime:${versions.room}",
        "androidx.room:room-paging:2.5.0-alpha01",
    )
    const val roomCompiler =
        "androidx.room:room-compiler:${versions.room}"

    val unitTests = listOf(
        "junit:junit:4.13.2",
        "io.mockk:mockk:${versions.mockk}",
        "io.mockk:mockk-agent-jvm:${versions.mockk}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${versions.coroutines}"
    )
    val androidTests = listOf(
        "androidx.test.ext:junit:1.1.5",
        "androidx.test.espresso:espresso-core:3.5.1",
        "androidx.compose.ui:ui-test-junit4:${versions.composeTest}"
    )
    const val uiautomator =
        "androidx.test.uiautomator:uiautomator:2.2.0"

    const val macroBenchmark =
        "androidx.benchmark:benchmark-macro-junit4:1.1.0-beta04"

    const val profileInstaller =
        "androidx.profileinstaller:profileinstaller:1.3.0"

    val debug = listOf(
        "androidx.compose.ui:ui-test-manifest:${versions.composeTest}"
    )
}