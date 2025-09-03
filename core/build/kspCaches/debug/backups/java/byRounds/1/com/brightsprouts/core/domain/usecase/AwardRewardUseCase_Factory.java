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
public final class AwardRewardUseCase_Factory implements Factory<AwardRewardUseCase> {
  private final Provider<ProgressRepository> progressRepositoryProvider;

  public AwardRewardUseCase_Factory(Provider<ProgressRepository> progressRepositoryProvider) {
    this.progressRepositoryProvider = progressRepositoryProvider;
  }

  @Override
  public AwardRewardUseCase get() {
    return newInstance(progressRepositoryProvider.get());
  }

  public static AwardRewardUseCase_Factory create(
      Provider<ProgressRepository> progressRepositoryProvider) {
    return new AwardRewardUseCase_Factory(progressRepositoryProvider);
  }

  public static AwardRewardUseCase newInstance(ProgressRepository progressRepository) {
    return new AwardRewardUseCase(progressRepository);
  }
}
