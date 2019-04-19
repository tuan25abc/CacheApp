package com.example.myapplication.helper

import android.content.Context
import javax.inject.Inject
import java.io.*

class FileHelper @Inject constructor(
    private val context: Context
) {
    fun getDataFromFile(fileName: String): String {
        val file = File("${context.cacheDir}/$fileName.txt")

        if (!file.exists()) return ""

        val result = StringBuilder()
        val br = BufferedReader(FileReader(file))
        try {
            var line = br.readLine()
            while (line != null) {
                result.append(line)
                result.append('\n')
                line = br.readLine()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            br.close()
        }
        return result.toString()
    }

    fun putDataToFile(fileName: String, data: String) {
        val file = File("${context.cacheDir}/$fileName.txt")

        try {
            val outputStreamWriter = OutputStreamWriter(FileOutputStream(file))
            outputStreamWriter.write(data)
            outputStreamWriter.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}