package com.example.bmicalc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.bmicalc.databinding.ActivityMainBinding
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    var gender: String = "Male"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.sliderHeight.addOnChangeListener { _: Slider, fl: Float, b: Boolean ->
            binding.tvHeight.text = fl.toInt().toString()
        }


        binding.btnFemale.setOnClickListener {
            if (gender == "Female") {
                return@setOnClickListener
            } else {
                gender = "Female"
                binding.btnFemale.setCardBackgroundColor(getColor(R.color.custom_selected))
                binding.btnMale.setCardBackgroundColor(getColor(R.color.custom_card))
            }
        }

        binding.btnMale.setOnClickListener {
            if (gender == "Male") {
                return@setOnClickListener
            } else {
                gender = "Male"
                binding.btnMale.setCardBackgroundColor(getColor(R.color.custom_selected))
                binding.btnFemale.setCardBackgroundColor(getColor(R.color.custom_card))
            }
        }

        binding.btnIncAge.setOnClickListener {
            val value = binding.tvAge.text.toString().toInt()
            if (value in 1..105) {
                if (value <= 8) {
                    binding.tvAge.text = "0" + (value + 1).toString()
                } else {
                    binding.tvAge.text = (value + 1).toString()
                }
            }
        }

        binding.btnDecAge.setOnClickListener {
            val value = binding.tvAge.text.toString().toInt()
            if (value in 2..105) {
                if (value in 1..10) {
                    binding.tvAge.text = "0" + (value - 1).toString()
                } else {
                    binding.tvAge.text = (value - 1).toString()
                }
            }
        }

        binding.btnDecWeight.setOnClickListener {
            val value = binding.tvWeight.text.toString().toInt()
            if (value in 2..200) {
                if (value in 1..10) {
                    binding.tvWeight.text = "0" + (value - 1).toString()
                } else {
                    binding.tvWeight.text = (value - 1).toString()
                }
            }
        }

        binding.btnIncWeight.setOnClickListener {
            val value = binding.tvWeight.text.toString().toInt()
            if (value in 1..200) {
                if (value <= 8) {
                    binding.tvWeight.text = "0" + (value + 1).toString()

                } else {
                    binding.tvWeight.text = (value + 1).toString()
                }
            }
        }

    }
}

