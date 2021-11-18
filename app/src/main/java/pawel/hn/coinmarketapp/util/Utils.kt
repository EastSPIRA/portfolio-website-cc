
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
    } else {
       spannableVol
    }
}

fun showSnack(view: View, text: String) {
    Snackbar.make(view, text, Snackbar.LENGTH_SHORT).apply {
        this.view.apply {
            setBackgroundColor(ContextCompat.getColor(view.context, R.color.snackBarBackground))
            textAlignment = View.TEXT_ALIGNMENT_CENTER
        }
        show()
    }
}

fun showLog(string: String) = Log.d(TAG, string)

fun hideKeyboard(view: View) {
    val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun formatPriceChange(price: Double): String {
    val priceString = price.toString()

    return if (priceString.substring(priceString.indexOf('.')).length > 2) {
        priceString.substring(0, priceString.indexOf('.') + 3) + " %"
    } else {
        "$priceString %"
    }
}

fun setPriceChangeColor(view: TextView, change: Double) {
    if (change < 0.00) {
        view.setTextColor(ContextCompat.getColor(view.context, R.color.priceDrop))
    } else {
        view
            .setTextColor(
                ContextCompat.getColor(
                    view.context, R.color.priceUp
                )
            )
    }
}

fun hasInternetConnection(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetwork ?: return false
    val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
    return when {
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        else -> false
    }
}

