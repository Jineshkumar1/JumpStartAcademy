package com.brightsprouts.data.di;

import android.content.Context;
import com.brightsprouts.data.database.JumpStartAcademyDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DataModule_Companion_ProvideDatabaseFactory implements Factory<JumpStartAcademyDatabase> {
  private final Provider<Context> contextProvider;

  public DataModule_Companion_ProvideDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public JumpStartAcademyDatabase get() {
    return provideDatabase(contextProvider.get());
  }

  public static DataModule_Companion_ProvideDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new DataModule_Companion_ProvideDatabaseFactory(contextProvider);
  }

  public static JumpStartAcademyDatabase provideDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(DataModule.Companion.provideDatabase(context));
  }
}
