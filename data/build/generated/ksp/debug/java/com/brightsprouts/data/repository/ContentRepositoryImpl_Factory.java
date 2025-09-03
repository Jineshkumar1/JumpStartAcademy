package com.brightsprouts.data.repository;

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
public final class ContentRepositoryImpl_Factory implements Factory<ContentRepositoryImpl> {
  private final Provider<ContentLoader> contentLoaderProvider;

  public ContentRepositoryImpl_Factory(Provider<ContentLoader> contentLoaderProvider) {
    this.contentLoaderProvider = contentLoaderProvider;
  }

  @Override
  public ContentRepositoryImpl get() {
    return newInstance(contentLoaderProvider.get());
  }

  public static ContentRepositoryImpl_Factory create(
      Provider<ContentLoader> contentLoaderProvider) {
    return new ContentRepositoryImpl_Factory(contentLoaderProvider);
  }

  public static ContentRepositoryImpl newInstance(ContentLoader contentLoader) {
    return new ContentRepositoryImpl(contentLoader);
  }
}
