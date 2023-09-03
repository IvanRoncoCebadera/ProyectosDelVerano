package storage

interface StorageServiceI <T> {
    fun exportToFile(entity: T)
    fun importFile(): T
}