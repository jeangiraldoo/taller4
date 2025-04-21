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

diccionarioPorOcurrencias