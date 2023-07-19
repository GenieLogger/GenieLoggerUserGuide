package com.kt.genieloggersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import genie.log.GenieLog
import genie.log.GenieTree

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logValueText = findViewById<TextView>(R.id.logValueText)
        val setLoggableButton = findViewById<Button>(R.id.setLoggableButton)
        val logButton = findViewById<Button>(R.id.logButton)
        val callerStackButton = findViewById<Button>(R.id.callerStackButton)
        val callerStackUmlButton = findViewById<Button>(R.id.callerStackUmlButton)
        val testClass = TestClass()

        // 로그 출력 상태 판단
        var isLogBlock:Boolean = GenieTree.getIsBlockLog()
        if (isLogBlock) logValueText.text = "Disable"
        else logValueText.text = "Enable"

        Log.d(TAG, "Log MainActivity onCreate() !")
        GenieLog.d("GenieLog MainActivity onCreate() !")
        GenieLog.tag("testTag").d("GenieLog MainActivity onCreate() !")

        // 로그 출력 변경
        setLoggableButton.setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_DPAD_CENTER) {
                isLogBlock = !isLogBlock
                GenieLog.setLoggable(!isLogBlock)
                if (GenieTree.getIsBlockLog()) logValueText.text = "Disable"
                else logValueText.text = "Enable"
            }
            false
        })

        // 로그 출력
        logButton.setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_DPAD_CENTER) {
                GenieLog.d("GenieLog Log Button pressed !")
            }
            false
        })

        // 콜 스택 출력
        callerStackButton .setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_DPAD_CENTER) {
                testClass.printCallerStack()
            }
            false
        })

        // 콜 스택 기반 UML 출력
        callerStackUmlButton.setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_DPAD_CENTER) {
                testClass.printCallerStackUml()
            }
            false
        })
    }
}