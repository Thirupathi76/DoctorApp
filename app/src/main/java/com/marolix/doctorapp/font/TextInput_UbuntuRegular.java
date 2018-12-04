package com.marolix.doctorapp.font;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;

public class TextInput_UbuntuRegular extends TextInputLayout {
    public TextInput_UbuntuRegular(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public TextInput_UbuntuRegular(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TextInput_UbuntuRegular(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Ubuntu_Regular.ttf"));
        }
    }
}
