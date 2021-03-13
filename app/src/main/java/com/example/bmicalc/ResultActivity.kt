package com.example.bmicalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bmicalc.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    val formatterValue = "%.2f"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val values = intent.getStringArrayListExtra("Values")
        val weight = values?.get(0)?.toString()?.toInt()
        values?.get(1)?.toString()?.let { Log.d("TAG", it) }
        val height = values!![1]!!.toString().toInt()

        val heightInMeter: Double = (height.toDouble()/100)

        val result : Double = String.format("%.1f", weight!! / ((String.format("%.8f", heightInMeter * heightInMeter).toDouble()))).toDouble()

        binding.tvResult.text = result.toString()

        if (result in 18.5..25.0){
            binding.tvResultString.text = "Your BMI is Normal"
        }else if (result < 18.5){
            binding.tvResultStatus.setTextColor(getColor(R.color.custom_red))
            binding.tvResultStatus.text = "Underweight"
            binding.tvResultString.text = "Eat more and better, Your BMI is less than usual."
        }else {
            binding.tvResultStatus.setTextColor(getColor(R.color.custom_red))
            binding.tvResultStatus.text = "Overweight"
            binding.tvResultString.text = "Eat less and exercise more, BMI is more than normal."
        }

        binding.btnRecalculate.setOnClickListener {
            finishAndRemoveTask()
        }
    }
}