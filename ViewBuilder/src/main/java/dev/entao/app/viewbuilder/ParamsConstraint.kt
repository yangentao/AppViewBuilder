@file:Suppress("unused")

package dev.entao.app.viewbuilder


import android.view.View
import androidx.constraintlayout.widget.Barrier
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import dev.entao.app.idx
import dev.entao.app.requireId

//constraintLayout.apply {
//    textView {
//        constraintParams {
//            right()
//            verParent()
//            widthPercent(0.6f)
//            heightPercent(0.5f)
//        }
//
//        text = "Hello1"
//        backColor = Color.CYAN
//        gravityCenter()
//        name = "t1"
//    }
//    textView {
//        constraintParams {
//            left()
//            below(sibling("t1"))
//            widthPercent(0.6f)
//            height = 50.dp
//        }
//
//        text = "Hello2"
//        backColor = Color.BLUE
//        gravityCenter()
//    }
//}


fun ConstraintParams.left() {
    leftToLeft = 0
}

fun ConstraintParams.leftOf(v: View) {
    leftToLeft = v.idx
}

fun ConstraintParams.top() {
    topToTop = 0
}

fun ConstraintParams.topOf(v: View) {
    topToTop = v.idx
}

fun ConstraintParams.right() {
    rightToRight = 0
}

fun ConstraintParams.rightOf(v: View) {
    rightToRight = v.idx
}

fun ConstraintParams.bottom() {
    bottomToBottom = 0
}

fun ConstraintParams.bottomOf(v: View) {
    bottomToBottom = v.idx
}

fun ConstraintParams.below(v: View) {
    topToBottom = v.idx
}

fun ConstraintParams.above(v: View) {
    bottomToTop = v.idx
}

fun ConstraintParams.toLeftOf(v: View) {
    rightToLeft = v.idx
}

fun ConstraintParams.toRightOf(v: View) {
    leftToRight = v.idx
}


fun ConstraintParams.horParent(horBias: Float = 0.5f): ConstraintParams {
    leftToLeft = 0
    rightToRight = 0
    horizontalBias = horBias
    return this
}

fun ConstraintParams.verParent(verBias: Float = 0.5f): ConstraintParams {
    topToTop = 0
    bottomToBottom = 0
    verticalBias = verBias
    return this
}

fun ConstraintParams.edgesParent(horBias: Float = 0.5f, verBias: Float = 0.5f): ConstraintParams {
    leftToLeft = 0
    rightToRight = 0
    topToTop = 0
    bottomToBottom = 0
    horizontalBias = horBias
    verticalBias = verBias
    return this
}


fun ConstraintParams.circle(viewId: Int, angle: Int, radius: Int): ConstraintParams {
    this.circleConstraint = viewId
    this.circleAngle = angle.toFloat()
    this.circleRadius = radius
    return this
}


fun ConstraintParams.widthPercent(percent: Float = 1F): ConstraintParams {
    this.width = 0
    matchConstraintPercentWidth = percent
    return this
}

fun ConstraintParams.heightPercent(percent: Float = 1F): ConstraintParams {
    this.height = 0
    matchConstraintPercentHeight = percent
    return this
}

fun ConstraintParams.heightRange(minVal: Int, maxVal: Int): ConstraintParams {
    this.height = GroupParams.WRAP_CONTENT
    this.matchConstraintMinHeight = minVal
    this.matchConstraintMaxHeight = maxVal
    return this
}


fun ConstraintParams.widthRange(minVal: Int, maxVal: Int): ConstraintParams {
    this.width = GroupParams.WRAP_CONTENT
    this.matchConstraintMinWidth = minVal
    this.matchConstraintMaxWidth = maxVal
    return this
}

fun ConstraintParams.heightWeight(v: Float): ConstraintParams {
    this.height = 0
    this.verticalWeight = v
    return this
}

fun ConstraintParams.widthWeight(v: Float): ConstraintParams {
    this.width = 0
    this.horizontalWeight = v
    return this
}

//W,1:2
fun ConstraintParams.ratioW(w: Int, h: Int): ConstraintParams {
    this.dimensionRatio = "W,$h:$w"
    return this
}

private fun Any.setFieldValue(fieldName: String, value: Any?) {
    val f = this.javaClass.getDeclaredField(fieldName)
    f.isAccessible = true
    f.set(this, value)
}

fun ConstraintParams.horSpread(): ConstraintParams {
    this.horizontalChainStyle = ConstraintParams.CHAIN_SPREAD
    return this
}

fun ConstraintParams.horPacked(): ConstraintParams {
    this.horizontalChainStyle = ConstraintParams.CHAIN_PACKED
    return this
}

fun ConstraintParams.horSpreadInside(): ConstraintParams {
    this.horizontalChainStyle = ConstraintParams.CHAIN_SPREAD_INSIDE
    return this
}

fun ConstraintParams.verSpread(): ConstraintParams {
    this.verticalChainStyle = ConstraintParams.CHAIN_SPREAD
    return this
}

fun ConstraintParams.verPacked(): ConstraintParams {
    this.verticalChainStyle = ConstraintParams.CHAIN_PACKED
    return this
}

fun ConstraintParams.verSpreadInside(): ConstraintParams {
    this.verticalChainStyle = ConstraintParams.CHAIN_SPREAD_INSIDE
    return this
}


fun ConstraintLayout.guideline(block: Guideline.() -> Unit): Guideline {
    val g = Guideline(context)
    g.requireId()
    g.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
    addView(g)
    g.block()
    return g
}

fun ConstraintLayout.barrier(block: Barrier.() -> Unit): Barrier {
    val g = Barrier(context)
    g.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
    addView(g)
    g.block()
    return g
}


fun <T : ConstraintHelper> T.referIds(vararg ids: Int): T {
    this.referencedIds = IntArray(ids.size) {
        ids[it]
    }
    return this
}
