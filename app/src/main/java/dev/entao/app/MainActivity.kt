package dev.entao.app

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dev.entao.app.viewbuilder.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ll = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            textView {
                linearParams {
                    matchX()
                    wrapY()
                }
                text = "fill-x, wrap-y"
            }
            textView {
                linearParams {
                    width = 100.dp
                    height = 50.dp
                }
                text = "100*50"
            }
        }

        setContentView(ll)
    }

    fun testRelative() {
        RelativeLayout(this).apply {
            textView {
                relativeParams {
                    top().right()
                    width = 100.dp
                    wrapY()
                }
                text = "top and right, width=100dp, height wrap"
            }
            textView {
                relativeParams {
                    center()
                    width = 100.dp
                    wrapY()
                }
                text = "center in parent, width=100dp, height wrap"
            }
        }
    }

    fun testLinear() {
        LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            textView {
                linearParams {
                    matchX()
                    wrapY()
                }
                text = "fill-x, wrap-y"
            }
            textView {
                linearParams {
                    width = 100.dp
                    height = 50.dp
                }
                text = "100*50"
            }
        }

    }
}