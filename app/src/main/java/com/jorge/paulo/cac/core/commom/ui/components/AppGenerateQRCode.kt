package com.jorge.paulo.cac.core.commom.ui.components

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

private fun getQrCodeBitmap(idPlace: String): Bitmap {
    val size = 512 //pixels
    val qrCodeContent = idPlace
    //  val hints = hashMapOf<EncodeHintType, Int>().also { it[EncodeHintType.MARGIN] = 1 } // Make the QR code buffer border narrower
    val bits = QRCodeWriter().encode(qrCodeContent, BarcodeFormat.QR_CODE, size, size)
    return Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888).also {
        for (x in 0 until size) {
            for (y in 0 until size) {
                it.setPixel(x, y, if (bits[x, y]) Color.BLACK else Color.WHITE)
            }
        }
    }
}


@Composable
fun AppGetQrcode(idPlace: String){
    Image(
        bitmap = getQrCodeBitmap(idPlace).asImageBitmap(),
        contentDescription = "some useful description",
    )
}
