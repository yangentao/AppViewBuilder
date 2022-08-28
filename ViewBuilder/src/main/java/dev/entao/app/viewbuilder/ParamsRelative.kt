@file:Suppress("unused")

package dev.entao.app.viewbuilder

import android.view.View
import android.widget.RelativeLayout


fun <T : RelativeLayout.LayoutParams> T.fill(): T {
    addRule(RelativeLayout.ALIGN_PARENT_LEFT)
    addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
    addRule(RelativeLayout.ALIGN_PARENT_TOP)
    addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.fillX(): T {
    addRule(RelativeLayout.ALIGN_PARENT_LEFT)
    addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.fillY(): T {
    addRule(RelativeLayout.ALIGN_PARENT_TOP)
    addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.left(): T {
    addRule(RelativeLayout.ALIGN_PARENT_LEFT)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.right(): T {
    addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.top(): T {
    addRule(RelativeLayout.ALIGN_PARENT_TOP)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.bottom(): T {
    addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.center(): T {
    addRule(RelativeLayout.CENTER_IN_PARENT)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.centerX(): T {
    addRule(RelativeLayout.CENTER_HORIZONTAL)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.centerY(): T {
    addRule(RelativeLayout.CENTER_VERTICAL)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.center(anchor: Int): T {
    addRule(RelativeLayout.CENTER_HORIZONTAL, anchor)
    addRule(RelativeLayout.CENTER_VERTICAL, anchor)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.center(v: View): T {
    return center(v.idx)
}

fun <T : RelativeLayout.LayoutParams> T.centerX(anchor: Int): T {
    addRule(RelativeLayout.CENTER_HORIZONTAL, anchor)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.centerX(v: View): T {
    return centerX(v.idx)
}

fun <T : RelativeLayout.LayoutParams> T.centerY(anchor: Int): T {
    addRule(RelativeLayout.CENTER_VERTICAL, anchor)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.centerY(v: View): T {
    return centerY(v.idx)
}

fun <T : RelativeLayout.LayoutParams> T.above(anchor: Int): T {
    addRule(RelativeLayout.ABOVE, anchor)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.above(v: View): T {
    return this.above(v.idx)
}

fun <T : RelativeLayout.LayoutParams> T.baseline(anchor: Int): T {
    addRule(RelativeLayout.ALIGN_BASELINE, anchor)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.baseline(v: View): T {
    return this.baseline(v.idx)
}

fun <T : RelativeLayout.LayoutParams> T.bottom(anchor: Int): T {
    addRule(RelativeLayout.ALIGN_BOTTOM, anchor)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.bottom(v: View): T {
    return this.bottom(v.idx)
}

fun <T : RelativeLayout.LayoutParams> T.left(anchor: Int): T {
    addRule(RelativeLayout.ALIGN_LEFT, anchor)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.left(v: View): T {
    return this.left(v.idx)
}

fun <T : RelativeLayout.LayoutParams> T.right(anchor: Int): T {
    addRule(RelativeLayout.ALIGN_RIGHT, anchor)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.right(v: View): T {
    return this.right(v.idx)
}

fun <T : RelativeLayout.LayoutParams> T.top(anchor: Int): T {
    addRule(RelativeLayout.ALIGN_TOP, anchor)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.top(v: View): T {
    return this.top(v.idx)
}

fun <T : RelativeLayout.LayoutParams> T.below(anchor: Int): T {
    addRule(RelativeLayout.BELOW, anchor)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.below(v: View): T {
    return this.below(v.idx)
}

fun <T : RelativeLayout.LayoutParams> T.toLeft(anchor: Int): T {
    addRule(RelativeLayout.LEFT_OF, anchor)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.toLeft(v: View): T {
    return this.toLeft(v.idx)
}

fun <T : RelativeLayout.LayoutParams> T.toRight(anchor: Int): T {
    addRule(RelativeLayout.RIGHT_OF, anchor)
    return this
}

fun <T : RelativeLayout.LayoutParams> T.toRight(v: View): T {
    return this.toRight(v.idx)
}
