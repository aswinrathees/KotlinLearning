package com.opensource.samples.activities.unitTests

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.opensource.samples.R
import com.opensource.samples.activities.unitTests.utils.Calculator
import com.opensource.samples.activities.unitTests.utils.CalculatorViewModel
import com.opensource.samples.activities.unitTests.utils.CalculatorViewModelFactory
import com.opensource.samples.databinding.ActivityUnitTestsBinding

class UnitTestsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUnitTestsBinding
    private lateinit var viewModel: CalculatorViewModel
    private lateinit var viewModelFactory: CalculatorViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_unit_tests)
        viewModelFactory = CalculatorViewModelFactory(Calculator())
        viewModel = ViewModelProvider(this, viewModelFactory).get(CalculatorViewModel::class.java)
        binding.calcViewModel = viewModel
        binding.lifecycleOwner = this
    }
}