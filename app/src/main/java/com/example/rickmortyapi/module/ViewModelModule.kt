package com.example.rickmortyapi.module

import com.example.rickmortyapi.ui.fragment.character.CartoonViewModel
import com.example.rickmortyapi.ui.fragment.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule : Module = module {

    viewModel {
        CartoonViewModel(get())
    }

    viewModel {
        DetailViewModel(get())
    }
}