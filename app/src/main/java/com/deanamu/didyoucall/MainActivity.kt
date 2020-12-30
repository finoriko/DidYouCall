package com.deanamu.didyoucall

import android.os.Bundle
import android.provider.CallLog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun removeCallLog() {
        val where = CallLog.Calls.DATE + " between ? and ?"
        val selectionArgs = arrayOf(
            createDate(2014, 4, 1).toString(),
            createDate(2014, 4, 30).toString()
        )
        contentResolver.delete(CallLog.Calls.CONTENT_URI, where, selectionArgs)
    }

    fun createDate(year: Int, month: Int, day: Int): Long? {
        val calendar: Calendar = Calendar.getInstance()
        calendar.set(year, month - 1, day)
        return calendar.getTimeInMillis()
    }
}