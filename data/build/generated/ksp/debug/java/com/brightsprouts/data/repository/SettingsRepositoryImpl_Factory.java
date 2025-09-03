package com.brightsprouts.data.repository;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class SettingsRepositoryImpl_Factory implements Factory<SettingsRepositoryImpl> {
  private final Provider<Context> contextProvider;

  public SettingsRepositoryImpl_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SettingsRepositoryImpl get() {
    return newInstance(contextProvider.get());
  }

  public static SettingsRepositoryImpl_Factory create(Provider<Context> contextProvider) {
    return new SettingsRepositoryImpl_Factory(contextProvider);
  }

  public static SettingsRepositoryImpl newInstance(Context context) {
    return new SettingsRepositoryImpl(context);
  }
}
