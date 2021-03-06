package com.etb.zooappcat1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.etb.zooappcat1.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
      setContentView(binding.root)

        // setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        //displayUser()
        val navView: NavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_content_main)


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
      //  displayUser()

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //drawer is open

        // Log.e("drawer", "open")

        // drawerLayout.setOn

//  var tog=ActionBarDrawerToggle(applicationContext,drawerLayout)
//    }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    private fun displayUser() {
        // to display the user s name and email in the navigation drawer

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(
            sharedPrefFile,
            Context.MODE_PRIVATE
        )

        val userNames = sharedPreferences.getString("Name", "Username")
        val userEmail = sharedPreferences.getString("emailAddress", " Developerr@hmail.com")

        var currentUserNames: TextView = findViewById(R.id.nameOfUser)
        var currentUserMail: TextView = findViewById(R.id.emailOfUser)

        currentUserNames.text = userNames
        currentUserMail.text = userEmail
        println("$userNames + $userEmail")
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> Toast.makeText(
                applicationContext,
                "My Setting",
                Toast.LENGTH_LONG
            )
                .show()
            R.id.Logout -> {
                Toast.makeText(
                    applicationContext,
                    "Your have been signed out",
                    Toast.LENGTH_LONG
                ).show()
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
            }


            R.id.action_profile -> Toast.makeText(
                applicationContext,
                "My Profile",
                Toast.LENGTH_LONG
            ).show()


        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}