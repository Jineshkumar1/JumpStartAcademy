package com.brightsprouts.data.repository;

import com.brightsprouts.data.database.dao.ProgressDao;
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
public final class ProgressRepositoryImpl_Factory implements Factory<ProgressRepositoryImpl> {
  private final Provider<ProgressDao> progressDaoProvider;

  public ProgressRepositoryImpl_Factory(Provider<ProgressDao> progressDaoProvider) {
    this.progressDaoProvider = progressDaoProvider;
  }

  @Override
  public ProgressRepositoryImpl get() {
    return newInstance(progressDaoProvider.get());
  }

  public static ProgressRepositoryImpl_Factory create(Provider<ProgressDao> progressDaoProvider) {
    return new ProgressRepositoryImpl_Factory(progressDaoProvider);
  }

  public static ProgressRepositoryImpl newInstance(ProgressDao progressDao) {
    return new ProgressRepositoryImpl(progressDao);
  }
}
