package com.opensource.armmovies.domain.usecases

import com.opensource.armmovies.domain.repoInterfaces.TVShowRepository
import com.opensource.armmovies.data.model.tvshow.TVShow

class GetTVShowsUseCase(private val tvShowRepository: TVShowRepository) {

    suspend fun execute(): List<TVShow>? = tvShowRepository.getTVShows()
}