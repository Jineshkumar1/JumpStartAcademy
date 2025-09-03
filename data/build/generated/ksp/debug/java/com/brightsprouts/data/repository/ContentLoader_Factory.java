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
public final class ContentLoader_Factory implements Factory<ContentLoader> {
  private final Provider<Context> contextProvider;

  public ContentLoader_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ContentLoader get() {
    return newInstance(contextProvider.get());
  }

  public static ContentLoader_Factory create(Provider<Context> contextProvider) {
    return new ContentLoader_Factory(contextProvider);
  }

  public static ContentLoader newInstance(Context context) {
    return new ContentLoader(context);
  }
}
