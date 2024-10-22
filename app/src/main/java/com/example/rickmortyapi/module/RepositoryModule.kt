package com.example.rickmortyapi.module

import com.example.rickmortyapi.data.repositories.CharacterRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule : Module = module {
    factory {
        CharacterRepository(get())
    }
}