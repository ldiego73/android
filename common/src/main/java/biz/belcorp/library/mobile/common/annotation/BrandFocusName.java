package biz.belcorp.library.mobile.common.annotation;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@StringDef({
        BrandFocusName.LBEL,
        BrandFocusName.ESIKA
})
public @interface BrandFocusName {
    String LBEL = "L'Bel";
    String ESIKA = "Ésika";
}