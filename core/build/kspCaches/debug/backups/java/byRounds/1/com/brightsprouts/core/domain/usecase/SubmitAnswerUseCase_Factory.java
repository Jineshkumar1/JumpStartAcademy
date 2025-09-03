package com.brightsprouts.core.domain.usecase;

import com.brightsprouts.core.domain.repository.ProgressRepository;
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
public final class SubmitAnswerUseCase_Factory implements Factory<SubmitAnswerUseCase> {
  private final Provider<ProgressRepository> progressRepositoryProvider;

  public SubmitAnswerUseCase_Factory(Provider<ProgressRepository> progressRepositoryProvider) {
    this.progressRepositoryProvider = progressRepositoryProvider;
  }

  @Override
  public SubmitAnswerUseCase get() {
    return newInstance(progressRepositoryProvider.get());
  }

  public static SubmitAnswerUseCase_Factory create(
      Provider<ProgressRepository> progressRepositoryProvider) {
    return new SubmitAnswerUseCase_Factory(progressRepositoryProvider);
  }

  public static SubmitAnswerUseCase newInstance(ProgressRepository progressRepository) {
    return new SubmitAnswerUseCase(progressRepository);
  }
}
