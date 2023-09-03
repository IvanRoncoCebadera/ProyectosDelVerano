package config

import utils.getProperty
import java.io.File

class ConfigApp {
    val appData: String by lazy {
        System.getProperty("user.dir") + File.separator + getProperty("app.data")
    }
}