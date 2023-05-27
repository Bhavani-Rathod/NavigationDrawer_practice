package com.bhavani.navigation_drawer_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.compose.ui.focus.FocusDirection.Companion.In
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.settings -> Toast.makeText(applicationContext, "Clicked", Toast.LENGTH_SHORT).show()
                R.id.activity -> Toast.makeText(applicationContext, "Clicked", Toast.LENGTH_SHORT).show()
                R.id.saved -> Toast.makeText(applicationContext, "Clicked", Toast.LENGTH_SHORT).show()
                R.id.login -> {startActivity(Intent(this, SecondActivity::class.java))}
                R.id.exit-> Toast.makeText(applicationContext, "exit", Toast.LENGTH_SHORT).show()

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}