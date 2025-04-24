package object Anagramas {

  type Palabra = String
  type Frase = List[Palabra]
  type Ocurrencias = List[(Char, Int)]

  //val diccionario : List[Palabra] = List("cosas", "como","yo", "y", "ocasos","cayo", "mocosos","roca","moco","sos") // diccionario para el caso 1

  // val diccionario: List[Palabra] = List("amar", "rama", "mar", "ama", "correr", "cerro", "error", "roer", "creer") // diccionario para el caso 2

  val diccionario: List[Palabra] = List("ratón", "tornar", "norte", "terno", "nota", "tona", "ron", "trono", "arte", "reta")

  def lOcpal(p: Palabra): Ocurrencias = {
    p.groupBy(identity).map { case (c, cs) => (c, cs.length) }.toList.sortBy(_._1)
  }

  def lOcFrase(f: Frase): Ocurrencias = {
    val palabra = f.mkString
    lOcpal(palabra)
  }

  lazy val diccionarioPorOcurrencias: Map[Ocurrencias, List[Palabra]] = {
    diccionario.groupBy(palabra => lOcpal(palabra))
  }

  def anagramasDePalabra(palabra: Palabra): List[Palabra] = {
    val ocurrenciasPalabra = lOcpal(palabra)
      diccionarioPorOcurrencias(ocurrenciasPalabra)
  }

  def combinaciones(listaOcurrencias: Ocurrencias): List[Ocurrencias] = {
    val opcionesPorLetra: List[List[Ocurrencias]] = listaOcurrencias.map {
      case (char, max) =>
        (1 to max).map(n => List((char, n))).toList :+ Nil
    }

    val combinaciones: List[Ocurrencias] =
      for {
        combinacion <- opcionesPorLetra.foldRight(List[List[(Char, Int)]](Nil)) {
          (opcionesLetra, acumulador) =>
            for {
              opcion <- opcionesLetra
              combinacionPrevia <- acumulador
            } yield opcion ++ combinacionPrevia
        }
      } yield combinacion

    combinaciones
  }

  def complemento(listaOcurrencias: Ocurrencias, sublistaOcurrencias: Ocurrencias): Ocurrencias = {
    for {
      (char, num) <- listaOcurrencias
      subCantidad = sublistaOcurrencias.find(_._1 == char).map(_._2).getOrElse(0)
      nuevaCantidad = num - subCantidad
      if nuevaCantidad > 0
    } yield (char, nuevaCantidad)
  }

  def anagramasDeFrase(frase: Frase): List[Frase] = {
    val ocurrenciasFrase: Ocurrencias = lOcFrase(frase)

    def anagramas(ocurrencias: Ocurrencias): List[Frase] = ocurrencias match {
      case Nil => List(Nil)
      case _ =>
        for {
          combinacion <- combinaciones(ocurrencias)
          palabras <- diccionarioPorOcurrencias.getOrElse(combinacion, Nil)
          resto = complemento(ocurrencias, combinacion)
          fraseResto <- anagramas(resto)
        } yield palabras :: fraseResto
    }

    anagramas(ocurrenciasFrase)
  }

}
