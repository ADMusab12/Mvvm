package com.example.mvvm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.mvvm.databinding.FragmentOutputBinding

class OutputFragment : Fragment() {
    lateinit var _binding:FragmentOutputBinding
    private lateinit var viewModel: SumViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding=FragmentOutputBinding.inflate(layoutInflater)
        _binding.fragResult.setOnClickListener {
            findNavController().navigate(R.id.action_outputFragment_to_inputFragment)
        }
        return _binding.root
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(requireActivity())[SumViewModel::class.java]
            viewModel.value.observe(viewLifecycleOwner, Observer { value ->

                _binding.fragResult.text=value.toString()
            })
        }
    }