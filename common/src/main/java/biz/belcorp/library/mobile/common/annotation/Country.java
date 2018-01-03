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
public @interface Country {
    String BO = "BO";
    String CL = "CL";
    String CO = "CO";
    String CR = "CR";
    String DO = "DO";
    String EC = "EC";
    String GT = "GT";
    String MX = "MX";
    String PA = "PA";
    String PE = "PE";
    String PR = "PR";
    String SV = "SV";
    String VE = "VE";
}