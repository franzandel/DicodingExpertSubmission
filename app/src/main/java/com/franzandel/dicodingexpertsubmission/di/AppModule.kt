package com.franzandel.dicodingexpertsubmission.di

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.lifecycle.ViewModel
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.franzandel.core.presentation.vm.ViewModelFactory
import com.franzandel.dicodingexpertsubmission.BuildConfig
import com.google.gson.Gson
import com.securepreferences.SecurePreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by Franz Andel on 01/05/21.
 * Android Engineer
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val SESSION_NAME = "DicodingExpert Session"
    private const val TIMEOUT_TIME = 60L
    private const val gamesDomain = "api.rawg.io"
    private val certificatePinner = CertificatePinner.Builder()
        .add(gamesDomain, BuildConfig.CERT_PINNER_1)
        .add(gamesDomain, BuildConfig.CERT_PINNER_2)
        .add(gamesDomain, BuildConfig.CERT_PINNER_3)
        .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .certificatePinner(certificatePinner)
            .writeTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.GAMES_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Suppress("DEPRECATION")
    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val keyGenParameterSpec = KeyGenParameterSpec.Builder(
                MasterKey.DEFAULT_MASTER_KEY_ALIAS,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            ).apply {
                setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                setKeySize(MasterKey.DEFAULT_AES_GCM_MASTER_KEY_SIZE)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    setUserAuthenticationParameters(
                        15,
                        KeyProperties.AUTH_DEVICE_CREDENTIAL
                                or KeyProperties.AUTH_BIOMETRIC_STRONG
                    )
                } else
                    setUserAuthenticationValidityDurationSeconds(15)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
                    setUnlockedDeviceRequired(true)
            }.build()

            val masterKey = MasterKey.Builder(context)
                .setKeyGenParameterSpec(keyGenParameterSpec)
                .build()
            EncryptedSharedPreferences
                .create(
                    context,
                    SESSION_NAME,
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                )
        } else
            SecurePreferences(context, BuildConfig.SESSION_KEY, SESSION_NAME)

    @Provides
    fun provideViewModelFactory(
        providerMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
    ): ViewModelFactory =
        ViewModelFactory(providerMap)
}