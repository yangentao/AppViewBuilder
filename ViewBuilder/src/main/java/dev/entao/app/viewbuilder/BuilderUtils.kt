package dev.entao.app.viewbuilder

import android.view.View

fun <T : View> T.requireId(): T {
    if (this.id == View.NO_ID) {
        this.id = View.generateViewId()
    }
    return this
}

val View.idx: Int
    get() {
        if (this.id == View.NO_ID) {
            this.id = View.generateViewId()
        }
        return this.id
    }
