package com.example.githubsearchbar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Region
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dynamic_view.*


private var addRectangle = 0
private var drawingslist = ArrayList<Drawings>()

class DynamicView : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_view)
        add.setOnClickListener {
            addRectangle = 1
            customview.invalidate()
        }

        delete.setOnClickListener {
            addRectangle = 2
            customview.invalidate()
        }
    }
}

class Drawings(
    val mRect: Rect,
    val paint: Paint,
    val paintfill: Paint
)


class CustomView(context: Context, attrs: AttributeSet?) :
    View(context, attrs) {


    private var bLackcolor40trans = 0x66000000
    private var blue20trans = 0x330000FF
    private var borderWidth = 5.0f


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (addRectangle == 1) {
            val mRect = Rect()
            val mOffset = 220

            val vWidth = measuredWidth
            val vHeight = measuredHeight
            mRect.set(
                mOffset, mOffset, vWidth - mOffset, vHeight - mOffset
            )


            val paint = Paint(Paint.ANTI_ALIAS_FLAG)

            paint.color = bLackcolor40trans
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = borderWidth

            val paintfill = Paint(Paint.ANTI_ALIAS_FLAG)
            paintfill.color = blue20trans
            paintfill.style = Paint.Style.FILL

            drawingslist.add(Drawings(mRect, paint, paintfill))
        } else if (addRectangle == 2) {
            if (drawingslist.isNotEmpty())
                drawingslist.removeAt(drawingslist.size - 1)
        }

        for (i in 0 until drawingslist.size) {

            canvas!!.drawRect(
                drawingslist[i].mRect,
                drawingslist[i].paint
            )

            canvas!!.drawRect(
                drawingslist[i].mRect,
                drawingslist[i].paintfill
            )
        }

    }

    var prevX = 0
    var prevY = 0

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //   return super.onTouchEvent(event)
        addRectangle = 0

        val positionX = event!!.rawX.toInt()
        val positionY = event!!.rawY.toInt()

        var mImagePosition = drawingslist[0].mRect
     //   var mImageRegion = Region()
     //   mImageRegion.set(mImagePosition)

        var configuration = ViewConfiguration.get(context)
        var mTouchSlop = configuration.getScaledTouchSlop()
        var mScreenHeight: Int
        var mScreenWidth: Int
        mScreenHeight = measuredHeight
        mScreenWidth = measuredWidth

        when (event.action) {

            MotionEvent.ACTION_MOVE -> {
                if (positionX >= mImagePosition.left && positionX <= mImagePosition.right) {

                    if (positionY >= mImagePosition.top && positionY <= mImagePosition.bottom) {


                        var distY = Math.abs(positionY - prevY)
                        var distX = Math.abs(positionX - prevX)

                        if (distX > mTouchSlop || distY > mTouchSlop) {
                            var deltaX = positionX - prevX;
                            var deltaY = positionY - prevY;
                            if ((mImagePosition.left + deltaX) > 0 && ((mImagePosition.right + deltaX) < mScreenWidth) && (mImagePosition.top + deltaY) > 0 && (mImagePosition.bottom + deltaY) < mScreenHeight) {

                                mImagePosition.left = mImagePosition.left + deltaX
                                mImagePosition.top = mImagePosition.top + deltaY
                                mImagePosition.right = mImagePosition.right + deltaX
                                mImagePosition.bottom = mImagePosition.bottom + deltaY
                           //     mImageRegion.set(mImagePosition)
                                // prevX = positionX
                                // prevY = positionY

                                invalidate()
                            }

                        }
                    }
                }

            }
        }

        prevX = positionX
        prevY = positionY
        return true;
    }


}



