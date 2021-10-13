package pawel.hn.coinmarketapp.notification

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.hilt.work.HiltWorker
import androidx.preference.PreferenceManager
import androidx.work.CoroutineWorker
import androidx.wo