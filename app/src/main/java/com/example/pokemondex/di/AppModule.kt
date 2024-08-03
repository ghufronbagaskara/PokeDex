package com.example.pokemondex.di

import com.example.pokemondex.data.remote.PokeApi
import com.example.pokemondex.repository.PokemonRepository
import com.example.pokemondex.util.Constants.BASE_URL
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)

    fun providePokeApi(): PokeApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }
}