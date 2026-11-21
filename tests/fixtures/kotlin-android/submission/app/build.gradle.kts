plugins { id("com.android.application"); id("org.jetbrains.kotlin.android") }

android {
    namespace = "edu.fixture.notes"
    compileSdk = 35
    defaultConfig { applicationId = "edu.fixture.notes"; minSdk = 24; targetSdk = 35; versionCode = 1; versionName = "1.0" }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    testImplementation("junit:junit:4.13.2")
}
