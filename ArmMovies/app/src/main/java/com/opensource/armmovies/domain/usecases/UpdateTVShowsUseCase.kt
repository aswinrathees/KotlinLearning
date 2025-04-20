package com.opensource.armmovies.domain.usecases

import com.opensource.armmovies.data.model.tvshow.TVShow
import com.opensource.armmovies.domain.repoInterfaces.TVShowRepository

class UpdateTVShowsUseCase(private val repository: TVShowRepository) {

    suspend fun execute(): List<TVShow>? = repository.updateTVShows()

}