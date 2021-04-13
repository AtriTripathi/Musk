package com.atritripathi.musk

import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * This activity is used to attach our fragment to, during testing
 * whenever we use Dagger-Hilt in our app.
 */
@AndroidEntryPoint
class HiltTestActivity : AppCompatActivity() {
}