package com.gaston.bottomactivityexample

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private lateinit var navController:NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val navView: BottomNavigationView = findViewById(R.id.nav_view)

    navController = findNavController(R.id.nav_host_fragment)
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    val appBarConfiguration = AppBarConfiguration(setOf(
      R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,
      R.id.navigation_profile))
    setupActionBarWithNavController(navController, appBarConfiguration)
    navView.setupWithNavController(navController)
    setBottomNavVisibility()
  }


  private fun setBottomNavVisibility(){
    navController.addOnDestinationChangedListener { controller, destination, arguments ->
      when(destination.id){
        R.id.navigation_frag_b -> hideBottomNav()
        else -> showBottomNav()
      }
    }
  }

  private fun showBottomNav(){
    nav_view.visibility = View.VISIBLE
  }

  private fun hideBottomNav(){
    nav_view.visibility = View.GONE
  }

  override fun onSupportNavigateUp(): Boolean {
    return findNavController(R.id.nav_host_fragment).navigateUp()
  }

}
