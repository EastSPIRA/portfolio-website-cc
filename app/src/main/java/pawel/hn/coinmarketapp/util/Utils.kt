
package pawel.hn.coinmarketapp.util

import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import pawel.hn.coinmarketapp.R
import java.math.RoundingMode
import java.text.DecimalFormat

enum class ValueType(val pattern: String) {
    Crypto(COIN_PATTERN),
    Fiat(FIAT_PATTERN),
}

fun formatPriceAndVolForView(volume: Double, type: ValueType, currency: String): SpannableString {
    val ccySymbol = when (currency) {
        CURRENCY_USD -> "$"
        CURRENCY_PLN-> "zł"
        CURRENCY_EUR -> "€"
        else -> ""
    }
    val df = DecimalFormat(type.pattern)
    df.roundingMode = RoundingMode.DOWN

    val spannablePrice = SpannableString("$ccySymbol ${df.format(volume)}")
    val spannableVol = SpannableString(df.format(volume))
    val dollarColor = ForegroundColorSpan(
        Color.GRAY
    )
    if (currency == CURRENCY_PLN) {
        spannablePrice.setSpan(dollarColor, 0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    } else {
        spannablePrice.setSpan(dollarColor, 0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    }
    return if (type == ValueType.Fiat) {
        spannablePrice