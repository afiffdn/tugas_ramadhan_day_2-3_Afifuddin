package com.example.tugasramadhanday2_3

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TableName(@PrimaryKey @ColumnInfo(name = "kata") val word :String)