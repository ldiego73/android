package biz.belcorp.library.mobile.common.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@IntDef({
        Theme.ESIKA,
        Theme.LBEL
})
public @interface Theme {
    int ESIKA = 0;
    int LBEL = 1;
}