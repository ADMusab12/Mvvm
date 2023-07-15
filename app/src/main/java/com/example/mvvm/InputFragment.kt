package com.example.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mvvm.databinding.FragmentInputBinding

class InputFragment : Fragment() {
    lateinit var _binding :FragmentInputBinding

    private lateinit var viewModel: SumViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding=FragmentInputBinding.inflate(layoutInflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(requireActivity())[SumViewModel::class.java]

        _binding.btSum.setOnClickListener {
            val num1= _binding.etFirstnum.text.toString().toInt()
            val num2=_binding.etSecondnum.text.toString().toInt()
            viewModel.sumNumbers(num1,num2)

            findNavController().navigate(R.id.action_inputFragment_to_outputFragment)
        }
        _binding.btSub.setOnClickListener {
            val num1= _binding.etFirstnum.text.toString().toInt()
            val num2= _binding.etSecondnum.text.toString().toInt()
            viewModel.subNumbers(num1,num2)

            findNavController().navigate(R.id.action_inputFragment_to_outputFragment)
        }
    }
}