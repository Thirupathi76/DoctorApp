package com.marolix.doctorapp.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextView_AvenirLTStd_Book extends TextView {
    public TextView_AvenirLTStd_Book(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public TextView_AvenirLTStd_Book(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TextView_AvenirLTStd_Book(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/AvenirLTStd_Book.otf"));
        }
    }
}
