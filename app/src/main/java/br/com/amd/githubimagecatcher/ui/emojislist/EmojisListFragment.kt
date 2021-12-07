package br.com.amd.githubimagecatcher.ui.emojislist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import br.com.amd.githubimagecatcher.R
import br.com.amd.githubimagecatcher.databinding.FragmentEmojisListBinding
import br.com.amd.githubimagecatcher.ui.common.EmojisAdapter
import br.com.amd.githubimagecatcher.ui.model.EmojiVO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmojisListFragment : Fragment() {
    private var _binding: FragmentEmojisListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: EmojisAdapter
    private val viewModel: EmojisListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmojisListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        setObservers()
    }

    private fun setAdapter() {
        adapter = EmojisAdapter()
        binding.rvEmojis.layoutManager = GridLayoutManager(requireContext(), ITEMS_PER_ROW)
        binding.rvEmojis.adapter = adapter
    }

    private fun setObservers() {
        viewModel.viewState.observe(
            viewLifecycleOwner,
            Observer { state ->
                when (state) {
                    EmojisListViewModel.ViewState.Loading -> renderLoadingState()
                    EmojisListViewModel.ViewState.Error -> renderErrorState()
                    is EmojisListViewModel.ViewState.Loaded -> renderLoadedState(state.data)
                }
            }
        )
    }

    private fun renderLoadingState() {
        with(binding) {
            cpiLoading.isVisible = true
            tvEmptyMessage.isVisible = false
            rvEmojis.isVisible = false
        }
    }

    private fun renderErrorState() {
        with(binding) {
            cpiLoading.isVisible = false
            tvEmptyMessage.isVisible = true
            rvEmojis.isVisible = false
        }
    }

    private fun renderLoadedState(emojis: List<EmojiVO>) {
        with(binding) {
            cpiLoading.isVisible = false
            tvEmptyMessage.isVisible = false
            rvEmojis.isVisible = true
        }

        adapter.submitList(emojis)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ITEMS_PER_ROW = 4
    }
}