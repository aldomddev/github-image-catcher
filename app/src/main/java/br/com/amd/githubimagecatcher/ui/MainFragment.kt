package br.com.amd.githubimagecatcher.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.amd.githubimagecatcher.R
import br.com.amd.githubimagecatcher.databinding.FragmentMainBinding
import coil.load
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
        setObservers()
    }

    private fun setListeners() {
        with(binding) {
            btnEmojisList.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_emojisListFragment)
            }

            btnRandomEmoji.setOnClickListener {
                viewModel.randomEmoji()
            }
        }
    }

    private fun setObservers() {
        viewModel.randomEmoji.observe(
            viewLifecycleOwner, { emoji ->
                binding.ivEmoji.load(emoji.url)
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}