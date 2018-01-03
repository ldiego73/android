package biz.belcorp.library.mobile.common.annotation;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@StringDef({
        Country.BO,
        Country.CL,
        Country.CO,
        Country.CR,
        Country.DO,
        Country.EC,
        Country.GT,
        Country.MX,
        Country.PA,
        Country.PE,
        Country.PR,
        Country.SV,
        Country.VE,
})
public @interface CountryDialCode {
    String BO = "591";
    String CL = "56";
    String CO = "57";
    String CR = "506";
    String DO = "1";
    String EC = "593";
    String GT = "502";
    String MX = "52";
    String PA = "507";
    String PE = "51";
    String PR = "1";
    String SV = "503";
    String VE = "58";
}
