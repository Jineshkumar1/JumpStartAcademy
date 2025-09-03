package com.brightsprouts.core.domain.usecase;

import com.brightsprouts.core.domain.repository.ContentRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class LoadLessonUseCase_Factory implements Factory<LoadLessonUseCase> {
  private final Provider<ContentRepository> contentRepositoryProvider;

  public LoadLessonUseCase_Factory(Provider<ContentRepository> contentRepositoryProvider) {
    this.contentRepositoryProvider = contentRepositoryProvider;
  }

  @Override
  public LoadLessonUseCase get() {
    return newInstance(contentRepositoryProvider.get());
  }

  public static LoadLessonUseCase_Factory create(
      Provider<ContentRepository> contentRepositoryProvider) {
    return new LoadLessonUseCase_Factory(contentRepositoryProvider);
  }

  public static LoadLessonUseCase newInstance(ContentRepository contentRepository) {
    return new LoadLessonUseCase(contentRepository);
  }
}
