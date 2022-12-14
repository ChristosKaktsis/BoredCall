package com.example.boredcall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.boredcall.databinding.FragmentBoredviewBinding


class BoredviewFragment : Fragment() {
private val viewModel:BoredviewViewModel by viewModels()
    private lateinit var binding: FragmentBoredviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBoredviewBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.description.observe(viewLifecycleOwner
        ) {
            binding.resultTextView.text = viewModel.description.value
        }

        viewModel.isBusy.observe(viewLifecycleOwner
        ) {
            binding.progressIndicator.isIndeterminate = viewModel.isBusy.value ?: true
        }
        binding.actionButton.setOnClickListener { viewModel.getActivity() }
    }
}