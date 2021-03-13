package com.example.bmicalc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bmicalc.databinding.ActivityMainBinding
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    private var gender: String = "Male"
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setTheme(R.style.Theme_BMICalc)
        setContentView(binding.root)

        binding.btnIncWeight.setBackgroundColor(getColor(R.color.custom_floating_button))
        binding.btnIncAge.setBackgroundColor(getColor(R.color.custom_floating_button))
        binding.btnDecWeight.setBackgroundColor(getColor(R.color.custom_floating_button))
        binding.btnDecAge.setBackgroundColor(getColor(R.color.custom_floating_button))

        binding.sliderHeight.addOnChangeListener { _: Slider, fl: Float, _: Boolean ->
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
                this.gender = "Male"
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

        binding.btnSubmit.setOnClickListener {
            Log.d("BRUH", binding.tvWeight.text.toString())
            Log.d("BRUH", binding.tvHeight.text.toString())
            val values : ArrayList<String> = getValues()
            val intent = Intent(this, ResultActivity::class.java).putStringArrayListExtra("Values", values)
            startActivity(intent)
        }

    }

    private fun getValues(): ArrayList<String> {
        val weight = binding.tvWeight.text.toString()
        val height = binding.tvHeight.text.toString()

        return arrayListOf(weight, height)
    }
}

