package uz.iraimjanov.lazycolumn.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri

fun makeCall(activity: Activity, number: String) {
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${number}"))
    activity.startActivity(intent)
}