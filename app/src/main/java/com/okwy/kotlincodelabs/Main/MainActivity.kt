package com.okwy.kotlincodelabs.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.okwy.kotlincodelabs.Coroutines.CoroutineActivity
import com.okwy.kotlincodelabs.DiceRoller.DiceRollerActivity
import com.okwy.kotlincodelabs.IntentsWithActivities.IntentActivity
import com.okwy.kotlincodelabs.Main.Adapter.MainAdapter
import com.okwy.kotlincodelabs.R
import com.okwy.kotlincodelabs.SnackBar.SnackbarActivity
import com.okwy.kotlincodelabs.Toast.ToastActivity
import java.util.ArrayList

class MainActivity : AppCompatActivity(), MainAdapter.ListItemClickListener {
    private var mainRecycler: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainRecycler = findViewById(R.id.mainRecycler)
        displayRecyclerView()
    }

    private fun displayRecyclerView() {
        val conceptList: MutableList<String> = ArrayList()
        conceptList.add("Toast")
        conceptList.add("Snackbar")
//        conceptList.add("Custom Views")
//        conceptList.add("Notification")
//        conceptList.add("Localization")
//        conceptList.add("WorkManager")
//        conceptList.add("JobScheduler")
//        conceptList.add("Tab Navigation")
//        conceptList.add("Bottom Navigation")
//        conceptList.add("Navigation Drawer")
//        conceptList.add("Navigation Component")
//        conceptList.add("Menus And Pickers")
//        conceptList.add("Reactive Programming")
//        conceptList.add("Paging with Retrofit")
//        conceptList.add("Volley with Picasso")
//        conceptList.add("Coordinator Layout")
//        conceptList.add("Foreground Service")
//        conceptList.add("Broadcast Receivers")
//        conceptList.add("Android Architecture")
        conceptList.add("Intents and Activities")
        conceptList.add("Coroutines")
        conceptList.add("Dice Roller")
//        conceptList.add("Drawables, Styles and Themes")
//        conceptList.add("App Settings and Preferences")
        println(conceptList.toString())
        val mainAdapter = MainAdapter(this, conceptList, this@MainActivity)
        mainRecycler!!.layoutManager = LinearLayoutManager(this)
        mainRecycler!!.adapter = mainAdapter
    }

    override fun onListItemClick(menuItem: String?, position: Int) {
        when (menuItem) {
            "Toast" -> startActivity(Intent(this, ToastActivity::class.java))
            "Snackbar" -> startActivity(Intent(this, SnackbarActivity::class.java))
//            "Custom Views" -> startActivity(Intent(this, CustomViewActivity::class.java))
//            "Notification" -> startActivity(Intent(this, NotificationActivity::class.java))
//            "Localization" -> startActivity(Intent(this, LocaleActivity::class.java))
//            "WorkManager" -> startActivity(Intent(this, WorkManagerActivity::class.java))
//            "JobScheduler" -> startActivity(Intent(this, JobSchedulerActivity::class.java))
//            "Reactive Programming" -> startActivity(Intent(this, RxJavaActivity::class.java))
//            "Paging with Retrofit" -> startActivity(Intent(this, PagingActivity::class.java))
//            "App Settings and Preferences" -> startActivity(Intent(this, AppSettingsActivity::class.java))
//            "Tab Navigation" -> startActivity(Intent(this, TabNavigationActivity::class.java))
//            "Bottom Navigation" -> startActivity(Intent(this, BottomNavigationActivity::class.java))
//            "Navigation Drawer" -> startActivity(Intent(this, NavigationDrawerActivity::class.java))
//            "Navigation Component" -> startActivity(Intent(this, NavigationComponentActivity::class.java))
//            "Menus And Pickers" -> startActivity(Intent(this, MenusWithPickersActivity::class.java))
//            "Volley with Picasso" -> startActivity(Intent(this, VolleyActivity::class.java))
//            "Foreground Service" -> startActivity(Intent(this, ServiceActivity::class.java))
//            "Broadcast Receivers" -> startActivity(Intent(this, BroadcastReceiverActivity::class.java))
//            "Android Architecture" -> startActivity(Intent(this, NoteActivity::class.java))
//            "Coordinator Layout" -> startActivity(Intent(this, CoordinatorLayoutActivity::class.java))
            "Intents and Activities" -> startActivity(Intent(this, IntentActivity::class.java))
            "Coroutines" -> startActivity(Intent(this, CoroutineActivity::class.java))
            "Dice Roller" -> startActivity(Intent(this, DiceRollerActivity::class.java))
//            "Drawables, Styles and Themes" -> startActivity(Intent(this, ScoreKeeperActivity::class.java))
        }
    }
}