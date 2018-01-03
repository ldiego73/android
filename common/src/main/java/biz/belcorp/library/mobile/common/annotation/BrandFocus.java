package biz.belcorp.library.mobile.common.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@IntDef({
        BrandFocus.LBEL,
        BrandFocus.ESIKA
})
public @interface BrandFocus {
    int LBEL = 1;
    int ESIKA = 2;
}