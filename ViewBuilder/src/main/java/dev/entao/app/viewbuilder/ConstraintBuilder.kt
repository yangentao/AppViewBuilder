@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package dev.entao.app.viewbuilder


import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

//rel.constraintLayout {
//    relativeParams {
//        parentFill
//    }
//    val v1 = textView {
//        gravityCenter()
//        text = "Hello"
//        backColor = Color.LTGRAY
//        constraints {
//            centerXParent(10.dp, 10.dp)
//            widthMatch()
//            topParent(10.dp)
//            heightPercent(0.3f)
//        }
//    }
//    val v2 = textView {
//        gravityCenter()
//        text = "HaHaHa"
//        backColor = Color.CYAN
//        requireId()
//        constraints {
//            centerX(v1)
//            below(v1, 10.dp)
//            widthPercent(0.5f)
//            ratioH(2, 1)
//        }
//    }
//}

fun ConstraintLayout.constraints(block: ConstraintBuilder.() -> Unit) {
    this.constraintBuilder.apply(block)
}

fun ViewGroup.constraintLayout(block: ConstraintLayout.() -> Unit): ConstraintLayout {
    val cl = append(block)
    cl.constraintBuilder.finish()
    return cl
}

fun ConstraintLayout.applyConstraints() {
    constraintBuilder.finish()
}

fun ConstraintLayout.buildViews(block: ConstraintLayout.() -> Unit) {
    this.block()
    constraintBuilder.finish()
}

val ConstraintLayout.constraintBuilder: ConstraintBuilder
    get() {
        this.getTag(R.id.constraintBuilder)?.also { return it as ConstraintBuilder }
        return ConstraintBuilder(this).also { this.setTag(R.id.constraintBuilder, it) }
    }

class ConstraintBuilder(val layout: ConstraintLayout) {
    val set: ConstraintSet = ConstraintSet().apply { clone(layout) }

    fun View.left() {
        set.connect(this.idx, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT)
    }

    fun View.right() {
        set.connect(this.idx, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)
    }

    fun View.top() {
        set.connect(this.idx, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
    }

    fun View.bottom() {
        set.connect(this.idx, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
    }
    //----------------------------------

    fun View.leftOf(v: View) {
        set.connect(this.idx, ConstraintSet.LEFT, v.idx, ConstraintSet.LEFT)
    }

    fun View.rightOf(v: View) {
        set.connect(this.idx, ConstraintSet.RIGHT, v.idx, ConstraintSet.RIGHT)
    }

    fun View.topOf(v: View) {
        set.connect(this.idx, ConstraintSet.TOP, v.idx, ConstraintSet.TOP)
    }

    fun View.bottomOf(v: View) {
        set.connect(this.idx, ConstraintSet.BOTTOM, v.idx, ConstraintSet.BOTTOM)
    }

    //-------------------
    fun View.toLeftOf(v: View) {
        set.connect(this.idx, ConstraintSet.RIGHT, v.idx, ConstraintSet.LEFT)
    }

    fun View.toRightOf(v: View) {
        set.connect(this.idx, ConstraintSet.LEFT, v.idx, ConstraintSet.RIGHT)
    }

    fun View.above(v: View) {
        set.connect(this.idx, ConstraintSet.BOTTOM, v.idx, ConstraintSet.TOP)
    }

    fun View.below(v: View) {
        set.connect(this.idx, ConstraintSet.TOP, v.idx, ConstraintSet.BOTTOM)
    }


    //-----------------

    fun View.centerX(v: View) {
        leftOf(v)
        rightOf(v)
        horizontalBias(0.5f)
    }

    fun View.centerY(v: View) {
        topOf(v)
        bottomOf(v)
        verticalBias(0.5f)
    }

    fun View.centerX() {
        left()
        right()
        horizontalBias(0.5f)
    }

    fun View.centerY() {
        top()
        bottom()
        verticalBias(0.5f)
    }

    //-----------
    fun View.width(w: Int) {
        set.constrainWidth(this.idx, w)
    }

    fun View.height(h: Int) {
        set.constrainHeight(this.idx, h)
    }

    fun View.widthWrap() {
        set.constrainWidth(this.idx, ConstraintSet.WRAP_CONTENT)
    }

    fun View.heightWrap() {
        set.constrainHeight(this.idx, ConstraintSet.WRAP_CONTENT)
    }

    fun View.widthMatch() {
        set.constrainWidth(this.idx, ConstraintSet.MATCH_CONSTRAINT)
    }

    fun View.heightMatch() {
        set.constrainHeight(this.idx, ConstraintSet.MATCH_CONSTRAINT)
    }

    fun View.widthPercent(percent: Float) {
        widthMatch()
        set.constrainPercentWidth(this.idx, percent)
    }

    fun View.heightPercent(percent: Float) {
        heightMatch()
        set.constrainPercentHeight(this.idx, percent)
    }

    fun View.widthRatio(w: Int, h: Int) {
        widthMatch()
        set.setDimensionRatio(this.idx, "W,$w:$h")
    }

    fun View.heightRatio(w: Int, h: Int) {
        heightMatch()
        set.setDimensionRatio(this.idx, "H,$w:$h")
    }

    fun View.heightWeight(w: Float) {
        heightMatch()
        set.setVerticalWeight(this.idx, w)
    }

    fun View.widthWeight(w: Float) {
        widthMatch()
        set.setHorizontalWeight(this.idx, w)
    }

    fun View.verticalBias(bias: Float) {
        set.setVerticalBias(this.idx, bias)
    }

    fun View.horizontalBias(bias: Float) {
        set.setHorizontalBias(this.idx, bias)
    }

    fun View.leftMargin(m: Int) {
        set.setMargin(this.idx, ConstraintSet.LEFT, m)
    }

    fun View.rightMargin(m: Int) {
        set.setMargin(this.idx, ConstraintSet.RIGHT, m)
    }

    fun View.topMargin(m: Int) {
        set.setMargin(this.idx, ConstraintSet.TOP, m)
    }

    fun View.bottomMargin(m: Int) {
        set.setMargin(this.idx, ConstraintSet.BOTTOM, m)
    }

    fun View.startMargin(m: Int) {
        set.setMargin(this.idx, ConstraintSet.START, m)
    }

    fun View.endMargin(m: Int) {
        set.setMargin(this.idx, ConstraintSet.END, m)
    }

    fun View.baselineMargin(m: Int) {
        set.setMargin(this.idx, ConstraintSet.BASELINE, m)
    }

    fun View.marginX(m: Int) {
        leftMargin(m)
        rightMargin(m)
    }

    fun View.marginY(m: Int) {
        topMargin(m)
        bottomMargin(m)
    }

    fun chainVerticalParent(views: List<View>, style: Int = ConstraintSet.CHAIN_SPREAD) {
        chainVertical(style, 0, ConstraintSet.TOP, views.map { it.idx }, 0, ConstraintSet.BOTTOM)
    }

    fun chainVertical(style: Int, topId: Int, topSide: Int, viewIdList: List<Int>, bottomId: Int, bottomSide: Int) {
        require(viewIdList.size >= 2) { "must have 2 or more widgets in a chain" }
        set.setVerticalChainStyle(viewIdList[0], style)
        set.connect(viewIdList[0], ConstraintSet.TOP, topId, topSide)
        for (i in 1 until viewIdList.size) {
            set.connect(viewIdList[i], ConstraintSet.TOP, viewIdList[i - 1], ConstraintSet.BOTTOM)
            set.connect(viewIdList[i - 1], ConstraintSet.BOTTOM, viewIdList[i], ConstraintSet.TOP)
        }
        set.connect(viewIdList[viewIdList.size - 1], ConstraintSet.BOTTOM, bottomId, bottomSide)
    }

    fun chainHorizontalParent(views: List<View>, style: Int = ConstraintSet.CHAIN_SPREAD) {
        chainHorizontal(style, 0, ConstraintSet.LEFT, views.map { it.idx }, 0, ConstraintSet.RIGHT)
    }

    fun chainHorizontal(style: Int, leftId: Int, leftSide: Int, viewIdList: List<Int>, rightId: Int, rightSide: Int) {
        require(viewIdList.size >= 2) { "must have 2 or more widgets in a chain" }
        set.setHorizontalChainStyle(viewIdList[0], style)
        set.connect(viewIdList[0], ConstraintSet.LEFT, leftId, leftSide)
        for (i in 1 until viewIdList.size) {
            set.connect(viewIdList[i], ConstraintSet.LEFT, viewIdList[i - 1], ConstraintSet.RIGHT)
            set.connect(viewIdList[i - 1], ConstraintSet.RIGHT, viewIdList[i], ConstraintSet.LEFT)
        }
        set.connect(viewIdList[viewIdList.size - 1], ConstraintSet.RIGHT, rightId, rightSide)
    }

    fun finish() {
        set.applyTo(layout)
    }
}