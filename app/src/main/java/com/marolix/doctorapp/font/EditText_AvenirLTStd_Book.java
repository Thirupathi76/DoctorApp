package com.marolix.doctorapp.font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditText_AvenirLTStd_Book extends EditText {
    public EditText_AvenirLTStd_Book(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public EditText_AvenirLTStd_Book(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public EditText_AvenirLTStd_Book(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/AvenirLTStd_Book.otf"));
        }
    }
}
