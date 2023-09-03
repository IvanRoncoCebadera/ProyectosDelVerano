package com.example.projectofinalitv.utils

import com.example.practicajavafxenverano.routes.RoutesManager
import mu.KotlinLogging
import java.io.InputStream
import java.net.URL

private val logger = KotlinLogging.logger {  }



/**
 * función que consigue el recurso pedido como URL
 * @author IvanRoncoCebadera
 * @param resource es el nombre del recurso a conseguir
 * @return el recurso pedido como URL
 * @throws RuntimeException si no se encuentra el recurso pedido
 */
fun getResource(resource: String): URL {
    logger.debug { "Conseguimos el recurso: $resource como URL" }
    return RoutesManager.app::class.java.getResource(resource)
        ?: throw RuntimeException("No se ha encontrado el recurso: $resource")
}

/**
 * función que consigue el recurso pedido como Stream
 * @author IvanRoncoCebadera
 * @param resource es el nombre del recurso a conseguir
 * @return el recurso pedido como Stream
 * @throws RuntimeException si no se encuentra el recurso pedido
 */
fun getResourceAsStream(resource: String): InputStream {
    logger.debug { "Conseguimos el recurso: $resource como Stream" }
    return RoutesManager.app::class.java.getResourceAsStream(resource)
        ?: throw RuntimeException("No se ha encontrado el recurso como stream: $resource")
}
