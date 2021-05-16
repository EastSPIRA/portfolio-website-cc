package pawel.hn.coinmarketapp.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import pawel.hn.coinmarketapp.R
import pawel.hn.coinmarketapp.databinding.ActivityMainBinding
import pawel.hn.coinmarketapp.util.CHANNEL_ID
import pawel.hn.coinmarketapp.util.CHANNEL_NAME

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MyTheme)
        val binding = DataBindingUtil
            .setContentView<ActivityMainBi