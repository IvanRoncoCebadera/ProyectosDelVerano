package utils

import java.util.Properties


fun getProperty(nameProperty: String): String?{
    val properties = Properties()
    properties.load(ClassLoader.getSystemResourceAsStream("application.properties"))
    return properties.getProperty(nameProperty)
}