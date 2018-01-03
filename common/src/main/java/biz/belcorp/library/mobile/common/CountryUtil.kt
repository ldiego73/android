package biz.belcorp.library.mobile.common

import android.annotation.SuppressLint
import android.content.Context
import android.support.annotation.DrawableRes
import android.telephony.TelephonyManager
import biz.belcorp.library.mobile.common.annotation.BrandFocus
import biz.belcorp.library.mobile.common.annotation.Country
import biz.belcorp.library.mobile.common.annotation.CountryDialCode
import biz.belcorp.library.mobile.common.annotation.Theme

class CountryUtil private constructor(private val ctx: Context?) {

    companion object {
        private const val DEFAULT = Country.PE
        private const val ESIKA_DEFAULT = DEFAULT
        private const val LBEL_DEFAULT = Country.MX

        @SuppressLint("StaticFieldLeak")
        private var instance: CountryUtil? = null

        @Synchronized
        fun create(ctx: Context?): CountryUtil = instance ?: CountryUtil(ctx)
    }

    private val simCountryIso: String?
        get() {
            val tm = ctx?.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
            return tm?.simCountryIso?.toUpperCase()
        }

    val all: List<String> = arrayListOf(
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
            Country.VE
    )


    val code: String
        get() = simCountryIso ?: DEFAULT

    val dialCode: String?
        get() {
            return when (simCountryIso) {
                Country.BO -> CountryDialCode.BO
                Country.CL -> CountryDialCode.CL
                Country.CO -> CountryDialCode.CO
                Country.CR -> CountryDialCode.CR
                Country.DO -> CountryDialCode.DO
                Country.EC -> CountryDialCode.EC
                Country.GT -> CountryDialCode.GT
                Country.MX -> CountryDialCode.MX
                Country.PA -> CountryDialCode.PA
                Country.PE -> CountryDialCode.PE
                Country.PR -> CountryDialCode.PR
                Country.SV -> CountryDialCode.SV
                Country.VE -> CountryDialCode.VE
                else -> null
            }
        }

    fun getCode(@BrandFocus brandFocus: Int): String {
        val country = simCountryIso

        return if (BrandFocus.LBEL == brandFocus)
            when (country) {
                Country.CR,
                Country.MX,
                Country.PA,
                Country.PR -> country
                else -> LBEL_DEFAULT
            }
        else
            when (country) {
                Country.BO,
                Country.CL,
                Country.CO,
                Country.DO,
                Country.EC,
                Country.GT,
                Country.PE,
                Country.SV,
                Country.VE -> country
                else -> ESIKA_DEFAULT
            }
    }

    fun getByBrandFocus(@BrandFocus brandFocus: Int): List<String> {
        return if (BrandFocus.LBEL == brandFocus)
            arrayListOf(
                    Country.CR,
                    Country.MX,
                    Country.PA,
                    Country.PR
            )
        else
            arrayListOf(
                    Country.BO,
                    Country.CL,
                    Country.CO,
                    Country.DO,
                    Country.EC,
                    Country.GT,
                    Country.PE,
                    Country.SV,
                    Country.VE
            )
    }

    @Theme
    fun getTheme(country: String): Int {
        return when (country) {
            Country.BO, Country.CL, Country.CO, Country.DO, Country.EC, Country.GT, Country.PE, Country.SV, Country.VE -> Theme.ESIKA
            Country.CR, Country.MX, Country.PA, Country.PR -> Theme.LBEL
            else -> Theme.LBEL
        }
    }

    @DrawableRes
    fun getIcon(country: String? = simCountryIso): Int {
        return when (country) {
            Country.BO -> R.drawable.country_bo
            Country.CL -> R.drawable.country_cl
            Country.CO -> R.drawable.country_co
            Country.CR -> R.drawable.country_cr
            Country.DO -> R.drawable.country_do
            Country.EC -> R.drawable.country_ec
            Country.GT -> R.drawable.country_gt
            Country.MX -> R.drawable.country_mx
            Country.PA -> R.drawable.country_pa
            Country.PE -> R.drawable.country_pe
            Country.PR -> R.drawable.country_pr
            Country.SV -> R.drawable.country_sv
            Country.VE -> R.drawable.country_ve
            else -> R.drawable.country_default
        }
    }

    fun getMaximumCampaign(country: String? = simCountryIso): Int {
        return when (country) {
            Country.VE -> 12
            Country.PE,
            Country.CO,
            Country.EC,
            Country.BO,
            Country.GT,
            Country.SV,
            Country.DO,
            Country.PR,
            Country.CL,
            Country.MX,
            Country.PA,
            Country.CR -> 18
            else -> 18
        }
    }

}

val Context.country: CountryUtil
    get() = CountryUtil.create(applicationContext)