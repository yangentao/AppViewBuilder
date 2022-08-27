# AppViewBuilder
Android Library, build views use DSL

### setup global application context first
```kotlin
AppInst.setApplicationContext(this)
```

### LinearLayout example
```kotlin
contentView.linearLayout {
    linearParams{
        matchX().matchY()
    }
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
```

### RelativeLayout example
```kotlin
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
```

### ConstraintLayout example
```kotlin
parentRelativeLayout.constraintLayout {
    relativeParams {
        parentFill
    }
    val v1 = textView {
        text = "Hello"
        backColor = Color.LTGRAY
        constraints {
            centerXParent(10.dp, 10.dp)
            widthMatch()
            topParent(10.dp)
            heightPercent(0.3f)
        }
    }
    textView {
        text = "HaHaHa"
        backColor = Color.CYAN
        constraints {
            centerX(v1)
            below(v1, 10.dp)
            widthPercent(0.5f)
            ratioH(2, 1)
        }
    }
}
```