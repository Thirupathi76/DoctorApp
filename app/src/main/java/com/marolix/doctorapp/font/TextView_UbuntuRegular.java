package com.marolix.doctorapp.font;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextView_UbuntuRegular extends AppCompatTextView {
    public TextView_UbuntuRegular(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public TextView_UbuntuRegular(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TextView_UbuntuRegular(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Ubuntu_Regular.ttf"));
        }
    }
}
