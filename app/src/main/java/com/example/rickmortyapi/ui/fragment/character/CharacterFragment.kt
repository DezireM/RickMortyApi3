package com.example.rickmortyapi.ui.fragment.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickmortyapi.data.base.BaseFragment
import com.example.rickmortyapi.data.network.model.Character
import com.example.rickmortyapi.databinding.FragmentCharacterBinding
import com.example.rickmortyapi.utils.Resource
import com.example.rickmortyapi.utils.gone
import com.example.rickmortyapi.utils.visible
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<FragmentCharacterBinding>() {

    private val viewModel by viewModel<CartoonViewModel>()

    private val cartoonAdapter by lazy {
        CharacterAdapter { character ->
            onClicked(character)
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCharacterBinding {
        return FragmentCharacterBinding.inflate(inflater, container, false)
    }

    override fun setupRecycler() {
        setupRecyclerView()
    }

    override fun setupObservers() {
        viewModel.characters.observe(viewLifecycleOwner) { resource ->
            binding.progressBar.apply { if (resource is Resource.Loading) visible() else gone()
            }

            resourceHandler(resource) { data ->
                cartoonAdapter.submitList(data)
            }
        }
    }

    private fun setupRecyclerView() = with(binding.rvCartoon) {
        layoutManager = LinearLayoutManager(context)
        adapter = cartoonAdapter
    }

    private fun onClicked(character: Character) {
        val action = CharacterFragmentDirections.actionCharacterFragmentToDetailFragment(character.id)
        findNavController().navigate(action)
    }
}