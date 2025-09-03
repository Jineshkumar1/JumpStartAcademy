package com.brightsprouts.data.di;

import com.brightsprouts.data.database.JumpStartAcademyDatabase;
import com.brightsprouts.data.database.dao.ProgressDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class DataModule_Companion_ProvideProgressDaoFactory implements Factory<ProgressDao> {
  private final Provider<JumpStartAcademyDatabase> databaseProvider;

  public DataModule_Companion_ProvideProgressDaoFactory(
      Provider<JumpStartAcademyDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ProgressDao get() {
    return provideProgressDao(databaseProvider.get());
  }

  public static DataModule_Companion_ProvideProgressDaoFactory create(
      Provider<JumpStartAcademyDatabase> databaseProvider) {
    return new DataModule_Companion_ProvideProgressDaoFactory(databaseProvider);
  }

  public static ProgressDao provideProgressDao(JumpStartAcademyDatabase database) {
    return Preconditions.checkNotNullFromProvides(DataModule.Companion.provideProgressDao(database));
  }
}
