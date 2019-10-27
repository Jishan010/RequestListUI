package com.mobility.myapplication

import android.content.Context
import android.widget.Toast

/**
 *
 * Created By JISHAN ANSARI On 10/26/2019
 */

fun Context.showMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}