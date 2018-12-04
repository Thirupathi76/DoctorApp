package com.marolix.doctorapp.font;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextView_UbuntuMedium extends AppCompatTextView {
    public TextView_UbuntuMedium(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public TextView_UbuntuMedium(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TextView_UbuntuMedium(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Ubuntu_Medium.ttf"));
        }
    }
}
