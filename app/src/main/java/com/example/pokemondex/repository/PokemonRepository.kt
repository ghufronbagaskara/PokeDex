package com.example.pokemondex.repository

import com.example.pokemondex.data.remote.PokeApi
import com.example.pokemondex.data.remote.responses.Pokemon
import com.example.pokemondex.data.remote.responses.PokemonList
import com.example.pokemondex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
){
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>{
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String, ): Resource<Pokemon>{
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}