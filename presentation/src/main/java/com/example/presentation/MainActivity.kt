package com.example.presentation

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val button: Button = binding.mButton


        viewModel.liveData.observe(this){
            binding.mainTextView.text = it

        }
        viewModel.titleLiveData.observe(this) {
            binding.mainTitleView.text = it
        }

        viewModel.load()


        button.setOnClickListener {
            // Загружаем данные при нажатии на кнопку
            viewModel.load()
        }
    }
        }

