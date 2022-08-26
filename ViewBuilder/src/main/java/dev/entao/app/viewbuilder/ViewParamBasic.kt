@file:Suppress("unused")

package dev.entao.app.viewbuilder

import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TableRow


fun FrameParams.grav(block: Grav.() -> Unit): FrameParams {
    Grav { g -> this.gravity = g }.apply(block)
    return this
}

fun LinearParams.grav(block: Grav.() -> Unit): LinearParams {
    Grav { g -> this.gravity = g }.apply(block)
    return this
}

val FrameParams.grav: Grav get() = Grav { g -> this.gravity = g }
val LinearParams.grav: Grav get() = Grav { g -> this.gravity = g }


fun <T : GroupParams> T.width(value: Int): T {
    this.width = value
    return this
}

fun <T : GroupParams> T.height(value: Int): T {
    this.width = value
    return this
}

fun <T : GroupParams> T.wrap(): T {
    this.height = GroupParams.WRAP_CONTENT
    this.width = GroupParams.WRAP_CONTENT
    return this
}

fun <T : GroupParams> T.wrapX(): T {
    this.width = GroupParams.WRAP_CONTENT
    return this
}

fun <T : GroupParams> T.wrapY(): T {
    this.height = GroupParams.WRAP_CONTENT
    return this
}

fun <T : GroupParams> T.match(): T {
    this.height = GroupParams.MATCH_PARENT
    this.width = GroupParams.MATCH_PARENT
    return this
}

fun <T : GroupParams> T.matchX(): T {
    this.width = GroupParams.MATCH_PARENT
    return this
}

fun <T : GroupParams> T.matchY(): T {
    this.height = GroupParams.MATCH_PARENT
    return this
}


var ViewGroup.MarginLayoutParams.marginY: Int
    get() = this.topMargin
    set(value) {
        topMargin = value
        bottomMargin = value
    }

var ViewGroup.MarginLayoutParams.marginX: Int
    get() = this.leftMargin
    set(value) {
        leftMargin = value
        rightMargin = value
    }

var ViewGroup.MarginLayoutParams.marginAll: Int
    get() = this.leftMargin
    set(value) {
        this.setMargins(value, value, value, value)
    }


fun <T : LinearLayout.LayoutParams> T.flexX(w: Number = 1f): T {
    width = 0
    weight = w.toFloat()
    return this
}

fun <T : LinearLayout.LayoutParams> T.flexY(w: Number = 1f): T {
    height = 0
    weight = w.toFloat()
    return this
}


fun <T : LinearLayout.LayoutParams> T.weight(w: Number): T {
    weight = w.toFloat()
    return this
}


fun TableRow.LayoutParams.span(n: Int): TableRow.LayoutParams {
    this.span = n
    return this
}

fun TableRow.LayoutParams.atColumn(n: Int): TableRow.LayoutParams {
    this.column = n
    return this
}
