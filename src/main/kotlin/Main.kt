data class Articulo(
    var codigo: String,
    var nombre: String,
    var categoria: String,
    var precio: Int,
    private var stock: Int
) {
    fun vender(cantidad: Int): Boolean {
        return if (cantidad <= stock) {
            stock -= cantidad
            true
        } else {
            false
        }
    }

    fun obtenerStock(): Int {
        return stock
    }
}

fun main() {

    println("BIENVENIDO A PUERTO GAMES")

    val inventario = mutableListOf<Articulo>()

    val audifonos = Articulo(
        codigo = " ",
        nombre = "",
        categoria = "",
        precio = 0,
        stock = 5
    ).apply {
        codigo = "A002"
        nombre = "Audífonos Gamer"
        categoria = "Accesorio"
        precio = 49990
    }

    audifonos.also {
        println("Artículo registrado: ${it.nombre}")
    }

    inventario.add(audifonos)

    val articuloEncontrado = inventario.find {
        it.codigo == "A002"
    }

    articuloEncontrado?.let {
        println("Artículo encontrado: ${it.nombre}")
    } ?: println("Artículo no encontrado")

    articuloEncontrado?.run {
        if (vender(2)) {
            println("Venta realizada: $nombre")
            println("Stock restante: ${obtenerStock()}")
        } else {
            println("No hay suficiente stock")
        }
    }

    with(inventario) {
        val valorTotal = sumOf {
            it.precio * it.obtenerStock()
        }

        println("RESUMEN DEL INVENTARIO")
        println("Cantidad de artículos: $size")
        println("Valor total actualizado: $$valorTotal")
    }

    println("Gracias por comprar en Puerto Games")
}