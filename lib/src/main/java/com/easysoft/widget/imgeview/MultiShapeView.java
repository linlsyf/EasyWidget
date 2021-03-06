package com.easysoft.widget.imgeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.easysoft.widget.lib.R;



public class MultiShapeView extends View {

    private Context mContext;


    private Bitmap  mBitmap;


    private Paint   mBitmapPaint;



    private Paint   mBorderPaint;



    private boolean mIsPressed;


    private Shader  mBitmapShader;



    private Matrix  mShaderMatrix;

    private int     mShape;


    private RectF   mRcBitmap;



    private RectF   mRcBorder;


    private float   mRoundRadius;


    private float   mBorderRadius;



    private float   mCircleRadius;


    private int     mBorderColor;



    private int     mBorderWidth;




    private int     mCoverColor;


    private static final int DEFAULT_BORDER_WIDTH = 0;


    private static final int DEFAULT_BORDER_COLOR = Color.TRANSPARENT;

    private static final int DEFAULT_COVER_COLOR  = Color.parseColor("#40333333");


    private static final int DEFAULT_ROUND_RADIUS = 0;


    public static final  int  SHAPE_REC    = 1; // 矩形
    public static final  int  SHAPE_CIRCLE = 2; // 圆形


    public MultiShapeView(Context context) {
        this(context, null);
    }

    public MultiShapeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultiShapeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MultiShapeView, defStyleAttr, 0);

        mContext = context;
        mBorderColor = typedArray.getColor(R.styleable.MultiShapeView_border_color, DEFAULT_BORDER_COLOR);
        mCoverColor  = typedArray.getColor(R.styleable.MultiShapeView_cover_color, DEFAULT_COVER_COLOR);
        mBorderWidth = typedArray.getDimensionPixelSize(R.styleable.MultiShapeView_border_width, DEFAULT_BORDER_WIDTH);
        mShape       = typedArray.getInteger(R.styleable.MultiShapeView_shape, SHAPE_REC);
        mRoundRadius = typedArray.getDimensionPixelSize(R.styleable.MultiShapeView_round_radius, DEFAULT_ROUND_RADIUS);
        typedArray.recycle();

        init();

    }

    private void init() {
        mBitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setColor(mBorderColor);
        mBorderPaint.setStrokeWidth(mBorderWidth);

        mRcBitmap = new RectF();
        mRcBorder = new RectF();
        mShaderMatrix = new Matrix();
    }


    public void setImageBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
        preDraw();
    }


    public void setImageDrawable(Drawable drawable) {
        mBitmap = getBitmapFromDrawable(drawable);
        preDraw();
    }

    public void setImageResource(int resId) {
        if (resId != 0) {
            try {
                mBitmap = getBitmapFromDrawable(mContext.getResources().getDrawable(resId));
            } catch (Exception e) {
                Log.w("MultiShapeView", "Unable to find resource: " + resId, e);
            }
        }
        preDraw();
    }


    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        try {
            Bitmap bitmap;

            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            }

            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }


    private void preDraw() {

        if (mBitmap == null) {
            return;
        }

        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mBitmapPaint.setShader(mBitmapShader);

        mRcBorder.set(0, 0, getWidth(), getHeight());
        mBorderRadius = Math.min((mRcBorder.height() - mBorderWidth) / 2, (mRcBorder.width() - mBorderWidth) / 2);

        if (mShape == SHAPE_CIRCLE) {
            mRcBitmap.set(mBorderWidth, mBorderWidth, mRcBorder.width() - mBorderWidth, mRcBorder.height() - mBorderWidth);
        } else if (mShape == SHAPE_REC) {
            mRcBitmap.set(mBorderWidth/2, mBorderWidth/2, mRcBorder.width() - mBorderWidth/2, mRcBorder.height() - mBorderWidth/2);
        }
        mCircleRadius = Math.min(mRcBitmap.height() / 2, mRcBitmap.width() / 2);
        updateShaderMatrix();
        invalidate();
    }


    /**
     * 伸缩变换
     */
    private void updateShaderMatrix() {
        float scale;
        float dx = 0;
        float dy = 0;

        mShaderMatrix.set(null);

        if (mBitmap.getWidth() * mRcBitmap.height() > mRcBitmap.width() * mBitmap.getHeight()) {
            scale = mRcBitmap.height() / (float) mBitmap.getHeight();
            dx = (mRcBitmap.width() - mBitmap.getWidth() * scale) * 0.5f;
        } else {
            scale = mRcBitmap.width() / (float) mBitmap.getWidth();
            dy = (mRcBitmap.height() - mBitmap.getHeight() * scale) * 0.5f;
        }

        mShaderMatrix.setScale(scale, scale);
        mShaderMatrix.postTranslate((int) (dx + 0.5f) + mBorderWidth, (int) (dy + 0.5f) + mBorderWidth);
        mBitmapShader.setLocalMatrix(mShaderMatrix);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        preDraw();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        preDraw();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        if (mBitmap != null) {
            if (mShape == SHAPE_CIRCLE) {
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, mCircleRadius, mBitmapPaint);
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, mBorderRadius, mBorderPaint);
            } else if (mShape == SHAPE_REC) {
                canvas.drawRoundRect(mRcBitmap, mRoundRadius, mRoundRadius, mBitmapPaint);
                canvas.drawRoundRect(mRcBorder, mRoundRadius, mRoundRadius, mBorderPaint);
            }
        }
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        if (mIsPressed == pressed) {
            return;
        }
        mIsPressed = pressed;
        if (mIsPressed) {
            mBitmapPaint.setColorFilter(new PorterDuffColorFilter(mCoverColor, PorterDuff.Mode.SRC_ATOP));
        } else {
            mBitmapPaint.setColorFilter(null);
        }
        invalidate();
    }

 

    //-----------------------------------------------getter/setter------------------------------

    public int getBorderColor() {
        return mBorderColor;
    }

    public void setBorderColor(int borderColor) {
        if (borderColor == mBorderColor) {
            return;
        }
        mBorderColor = borderColor;
        invalidate();
    }

    public int getBorderWidth() {
        return mBorderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        if (borderWidth == mBorderWidth) {
            return;
        }
        mBorderWidth = borderWidth;
        preDraw();
    }

    public int getCoverColor() {
        return mCoverColor;
    }

    public void setCoverColor(int coverColor) {
        if (coverColor == mCoverColor) {
            return;
        }
        mCoverColor = coverColor;
    }

    public int getShape() {
        return mShape;
    }

    public void setShape(int shape) {
        mShape = shape;
        preDraw();
    }

    public float getRoundRadius() {
        return mRoundRadius;
    }

    public void setRoundRadius(float roundRadius) {
        mRoundRadius = roundRadius;
        preDraw();
    }
}
