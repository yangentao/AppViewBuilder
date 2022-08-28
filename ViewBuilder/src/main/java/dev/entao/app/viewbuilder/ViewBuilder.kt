@file:Suppress("unused")

package dev.entao.app.viewbuilder


import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.radiobutton.MaterialRadioButton
import kotlin.reflect.KClass


fun <T : View> KClass<T>.newInstance(context: Context): T {
    val c = this.constructors.first { it.parameters.size == 1 && (it.parameters.first().type.classifier == Context::class || it.parameters.first().type.classifier == Activity::class) }
    return c.call(context)
}


fun <T : View> LinearLayout.addViewParam(view: T, block: LinearParams.() -> Unit): T {
    val p = LinearParams(LinearParams.WRAP_CONTENT, LinearParams.WRAP_CONTENT)
    p.block()
    this.addView(view, p)
    return view
}

fun <T : View> LinearLayout.addViewParam(view: T, index: Int, block: LinearParams.() -> Unit): T {
    val p = LinearParams(LinearParams.WRAP_CONTENT, LinearParams.WRAP_CONTENT)
    p.block()
    this.addView(view, index, p)
    return view
}

fun <T : View> RelativeLayout.addViewParam(view: T, block: RelativeParams.() -> Unit): T {
    val p = RelativeParams(RelativeParams.WRAP_CONTENT, RelativeParams.WRAP_CONTENT)
    p.block()
    this.addView(view, p)
    return view
}

fun <T : View> RelativeLayout.addViewParam(view: T, index: Int, block: RelativeParams.() -> Unit): T {
    val p = RelativeParams(RelativeParams.WRAP_CONTENT, RelativeParams.WRAP_CONTENT)
    p.block()
    this.addView(view, index, p)
    return view
}

fun <T : View> ViewGroup.appendView(view: T): T {
    this.addView(view)
    return view
}

fun <T : View> ViewGroup.appendView(view: T, index: Int): T {
    this.addView(view, index)
    return view
}

fun <T : View> ViewGroup.appendView(view: T, params: ViewGroup.LayoutParams): T {
    this.addView(view, params)
    return view
}

fun <T : View> ViewGroup.appendView(view: T, index: Int, params: ViewGroup.LayoutParams): T {
    this.addView(view, index, params)
    return view
}

fun <T : View> ViewGroup.appendView(view: T, block: T.() -> Unit): T {
    this.addView(view)
    view.block()
    return view
}


inline fun <reified T : View> ViewGroup.append(block: T.() -> Unit): T {
    val b = T::class.newInstance(this.context).requireId()
    this.addView(b)
    b.block()
    return b
}

inline fun <reified T : View> ViewGroup.append(index: Int, block: T.() -> Unit): T {
    val b = T::class.newInstance(this.context).requireId()
    this.addView(b, index)
    b.block()
    return b
}


fun ViewGroup.view(block: View.() -> Unit): View {
    return append(block)
}

fun ViewGroup.linearLayout(block: LinearLayout.() -> Unit): LinearLayout {
    return append(block)
}


fun ViewGroup.relativeLayout(block: RelativeLayout.() -> Unit): RelativeLayout {
    return append(block)
}

fun ViewGroup.frameLayout(block: FrameLayout.() -> Unit): FrameLayout {
    return append(block)
}


fun ViewGroup.drawerLayout(block: DrawerLayout.() -> Unit): DrawerLayout {
    return append(block)
}


fun ViewGroup.viewPager(block: ViewPager.() -> Unit): ViewPager {
    return append(block)
}


//fun ViewGroup.viewPager2(block: ViewPager2.() -> Unit): ViewPager2 {
//    return append(block)
//}
fun ViewGroup.textView(block: TextView.() -> Unit): TextView {
    return append(block)
}


fun ViewGroup.button(block: Button.() -> Unit): Button {
    return append(block)
}


fun ViewGroup.editText(block: EditText.() -> Unit): EditText {
    return append(block)
}

fun ViewGroup.listView(block: ListView.() -> Unit): ListView {
    return append(block)
}

fun ViewGroup.gridView(block: GridView.() -> Unit): GridView {
    return append(block)
}

fun ViewGroup.gridLayout(block: GridLayout.() -> Unit): GridLayout {
    return append(block)
}

fun ViewGroup.imageView(block: ImageView.() -> Unit): ImageView {
    return append(block)
}


fun ViewGroup.imageButton(block: ImageButton.() -> Unit): ImageButton {
    return append(block)
}


fun RadioGroup.radioButton(block: RadioButton.() -> Unit): RadioButton {
    return append(block)
}

fun RadioGroup.radioButtonMaterial(block: MaterialRadioButton.() -> Unit): MaterialRadioButton {
    return append(block)
}


fun ViewGroup.radioGroup(block: RadioGroup.() -> Unit): RadioGroup {
    return append(block)
}


fun ViewGroup.checkBox(block: CheckBox.() -> Unit): CheckBox {
    return append(block)
}

fun RadioGroup.checkButtonMaterial(block: MaterialCheckBox.() -> Unit): MaterialCheckBox {
    return append(block)
}


fun ViewGroup.tableLayout(block: TableLayout.() -> Unit): TableLayout {
    return append(block)
}


fun ViewGroup.tableRow(block: TableRow.() -> Unit): TableRow {
    return append(block)
}


fun ViewGroup.scrollView(block: ScrollView.() -> Unit): ScrollView {
    return append(block)
}


fun ViewGroup.scrollHorizontal(block: HorizontalScrollView.() -> Unit): HorizontalScrollView {
    return append(block)
}


