package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val animatoin = AnimationUtils.loadAnimation(this, R.anim.moon).apply {
            duration = 700
            interpolator = AccelerateInterpolator()
        }
        binding.moon.setOnClickListener{
            binding.moon.isVisible = false
            binding.imgeMoon.isVisible = true
            binding.imgeMoon.startAnimation(animatoin) {
                binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                binding.imgeMoon.isVisible = false
                binding.imgeSun.isVisible = false
                binding.sun.isVisible = true
            }
        }
        binding.sun.setOnClickListener{
            binding.sun.isVisible = false
            binding.imgeSun.isVisible = true
            binding.imgeSun.startAnimation(animatoin){
                binding.root.setBackgroundColor(ContextCompat.getColor(this,R.color.buile))
                binding.imgeSun.isVisible = false
                binding.imgeMoon.isVisible=false
                binding.moon.isVisible=true
            }

        }

    }
}