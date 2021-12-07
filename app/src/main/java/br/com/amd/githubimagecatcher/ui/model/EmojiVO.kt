package br.com.amd.githubimagecatcher.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EmojiVO(
    val id: Int,
    val url: String
) : Parcelable
