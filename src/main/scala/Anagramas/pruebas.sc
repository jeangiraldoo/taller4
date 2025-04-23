import Anagramas._

type Palabra = String
type Frase = List[Palabra]
type Ocurrencias = List[(Char, Int)]

val diccionario : List[Palabra] = List("cosas", "como","yo", "y", "ocasos","cayo", "mocosos","roca","moco","sos")

def lOcpal(p: Palabra): Ocurrencias = {
  val chars = p.toList.sorted
  chars.distinct.map(c => (c, chars.filter(_ == c).length))
}

def lOcFrase(f: Frase): Ocurrencias = {
  val palabra = f.mkString
  lOcpal(palabra)
}

lazy val diccionarioPorOcurrencias: Map[Ocurrencias, List[Palabra]] = {
  diccionario.groupBy(palabra => lOcpal(palabra))
}

def anagramasDePalabra(palabra: Palabra) = {
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

def complemento(listaOcurrencias: Ocurrencias, sublistaOcurrencias: Ocurrencias) : Ocurrencias = {
  listaOcurrencias.map {
    case (char, num) =>
      if (sublistaOcurrencias.exists(_._1 == char)) {
        val subCantidad = sublistaOcurrencias.find(_._1 == char).map(_._2).getOrElse(0)
        (char, num - subCantidad)
      } else {
        (char, num)
      }
  }.filter(_._2 > 0)
}

diccionarioPorOcurrencias

anagramasDePalabra("sos")

combinaciones(List(('a', 2), ('b', 2)))

complemento(List(('c', 2), ('a', 1), ('o', 1)), List(('c', 1)))