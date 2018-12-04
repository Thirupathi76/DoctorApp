package com.marolix.doctorapp.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class CheckBox_AvenirLTStd_Book extends CheckBox {
    public CheckBox_AvenirLTStd_Book(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public CheckBox_AvenirLTStd_Book(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CheckBox_AvenirLTStd_Book(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/AvenirLTStd_Book.otf"));
        }
    }
}
