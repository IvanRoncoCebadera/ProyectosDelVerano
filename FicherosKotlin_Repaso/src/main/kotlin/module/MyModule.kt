package module

import config.ConfigApp
import org.koin.dsl.module
import storage.PersonajeStorageCss
import storage.PersonasStorageJSON
import storage.PersonasStorageXML

val myModule = module {
    single { ConfigApp() }

    single { PersonajeStorageCss(get()) }

    single { PersonasStorageJSON(get()) }

    single { PersonasStorageXML(get()) }
}