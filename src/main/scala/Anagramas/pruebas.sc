import Anagramas._

// Ejemplos de la consigna

//anagramasDePalabra("sos")
//
//combinaciones(List(('a', 2), ('b', 2)))
//
//complemento(List(('c', 2), ('a', 1), ('o', 1)), List(('c', 1)))
//
//anagramasDeFrase(List("cosas", "como", "yo"))

// Nota: Deben descomentar y usar los diccionarios en package.scala para que todo funcione bien

// Caso propio 1

//lOcpal("cosas") // List((a,1), (c,1), (o,1), (s,2))
//
//lOcFrase(List("y", "cosas")) // List((a,1), (c,1), (o,1), (s,2), (y,1))
//
//anagramasDePalabra("cosas") // List(cosas)
//
//combinaciones(List(('c', 1), ('o', 1), ('s', 1), ('a', 1), ('s', 1)))
//// List(List((c,1), (o,1), (s,1), (a,1), (s,1)), List((c,1), (o,1), (s,1), (a,1)), List((c,1), (o,1), (s,1), (s,1)), List((c,1), (o,1), (s,1)), List((c,1), (o,1), (a,1), (s,1)), List((c,1), (o,1), (a,1)), List((c,1), (o,1), (s,1)), List((c,1), (o,1)), List((c,1), (s,1), (a,1), (s,1)), List((c,1), (s,1), (a,1)), List((c,1), (s,1), (s,1)), List((c,1), (s,1)), List((c,1), (a,1), (s,1)), List((c,1), (a,1)), List((c,1), (s,1)), List((c,1)), List((o,1), (s,1), (a,1), (s,1)), List((o,1), (s,1), (a,1)), List((o,1), (s,1), (s,1)), List((o,1), (s,1)), List((o,1), (a,1), (s,1)), List((o,1), (a,1)), List((o,1), (s,1)), List((o,1)), List((s,1), (a,1), (s,1)), List((s,1), (a,1)), List((s,1), (s,1)), List((s,1)), List((a,1), (s,1)), List((a,1)), List((s,1)), List())
//
//complemento(List(('c', 1), ('o', 1), ('s', 1), ('a', 1), ('s', 1)), List(('c', 1), ('o', 1), ('s', 1), ('a', 1), ('s', 1))) // List()
//
//anagramasDeFrase(List("y", "cosas")) // List(List(cosas, y), List(y, cosas))

// Caso propio 3

//lOcpal("error") // List((e,1), (o,1), (r,3))
//
//lOcFrase(List("error", "creer", "amar")) // List((a,2), (c,1), (e,3), (m,1), (o,1), (r,6))
//
//anagramasDePalabra("amar") // List(amar, rama)
//
//combinaciones(List(('a', 1), ('m', 1), ('a', 1), ('r', 1))) // List(List((a,1), (m,1), (a,1), (r,1)), List((a,1), (m,1), (a,1)), List((a,1), (m,1), (r,1)), List((a,1), (m,1)), List((a,1), (a,1), (r,1)), List((a,1), (a,1)), List((a,1), (r,1)), List((a,1)), List((m,1), (a,1), (r,1)), List((m,1), (a,1)), List((m,1), (r,1)), List((m,1)), List((a,1), (r,1)), List((a,1)), List((r,1)), List())
//
//complemento(List(('a', 2), ('m', 1), ('r', 3), ('e', 1), ('o', 1)), List(('a', 2), ('m', 1), ('r', 1))) // List((r,2), (e,1), (o,1))
//
//anagramasDeFrase(List("error", "creer", "amar")) // List(List(amar, creer, error), List(amar, error, creer), List(rama, creer, error), List(rama, error, creer), List(creer, amar, error), List(creer, rama, error), List(creer, error, amar), List(creer, error, rama), List(error, amar, creer), List(error, rama, creer), List(error, creer, amar), List(error, creer, rama))

// Caso propio 4

lOcpal("norte") // List((n,1), (o,1), (r,1), (t, 1), (e, 1))

lOcFrase(List("norte", "terno", "ratón")) // List((a,1), (e,2), (n,3), (o,2), (r,3), (t,3), (ó,1))

anagramasDePalabra("terno") // List(norte, terno)

combinaciones(List(('n', 2), ('o', 2), ('r', 2), ('t', 2), ('e', 2))) // List(List((n,1), (o,1), (r,1), (t,1), (e,1)), List((n,1), (o,1), (r,1), (t,1), (e,2)), List((n,1), (o,1), (r,1), (t,1)), List((n,1), (o,1), (r,1), (t,2), (e,1)), List((n,1), (o,1), (r,1), (t,2), (e,2)), List((n,1), (o,1), (r,1), (t,2)), List((n,1), (o,1), (r,1), (e,1)), List((n,1), (o,1), (r,1), (e,2)), List((n,1), (o,1), (r,1)), List((n,1), (o,1), (r,2), (t,1), (e,1)), List((n,1), (o,1), (r,2), (t,1), (e,2)), List((n,1), (o,1), (r,2), (t,1)), List((n,1), (o,1), (r,2), (t,2), (e,1)), List((n,1), (o,1), (r,2), (t,2), (e,2)), List((n,1), (o,1), (r,2), (t,2)), List((n,1), (o,1), (r,2), (e,1)), List((n,1), (o,1), (r,2), (e,2)), List((n,1), (o,1), (r,2)), List((n,1), (o,1), (t,1), (e,1)), List((n,1), (o,1), (t,1), (e,2)), List((n,1), (o,1), (t,1)), ...

complemento(List(('n', 2), ('o', 2), ('r', 2), ('t', 2), ('e', 2)), List(('n', 1), ('o', 1), ('r', 1), ('t', 1), ('e', 1))) // List((n,1), (o,1), (r,1), (t,1), (e,1))

anagramasDeFrase(List("norte", "terno", "ratón")) // List(List(ratón, norte, norte), List(ratón, norte, terno), List(ratón, terno, norte), List(ratón, terno, terno), List(norte, ratón, norte), List(norte, ratón, terno), List(norte, norte, ratón), List(norte, terno, ratón), List(terno, ratón, norte), List(terno, ratón, terno), List(terno, norte, ratón), List(terno, terno, ratón))