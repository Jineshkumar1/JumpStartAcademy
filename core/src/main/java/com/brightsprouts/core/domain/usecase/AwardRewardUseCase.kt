package com.brightsprouts.core.domain.usecase

import com.brightsprouts.core.domain.repository.ProgressRepository
import javax.inject.Inject

class AwardRewardUseCase @Inject constructor(
    private val progressRepository: ProgressRepository
) {
    suspend operator fun invoke(stickerId: String) {
        progressRepository.unlockSticker(stickerId)
    }
}
