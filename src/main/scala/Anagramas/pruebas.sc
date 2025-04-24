import Anagramas._

// Ejemplos de la consigna

anagramasDePalabra("sos")

combinaciones(List(('a', 2), ('b', 2)))

complemento(List(('c', 2), ('a', 1), ('o', 1)), List(('c', 1)))

anagramasDeFrase(List("cosas", "como", "yo"))

// Caso propio 1

lOcpal("cosas") // List((a,1), (c,1), (o,1), (s,2))

lOcFrase(List("y", "cosas")) // List((a,1), (c,1), (o,1), (s,2), (y,1))

anagramasDePalabra("cosas") // List(cosas)

combinaciones(List(('c', 1), ('o', 1), ('s', 1), ('a', 1), ('s', 1)))
// List(List((c,1), (o,1), (s,1), (a,1), (s,1)), List((c,1), (o,1), (s,1), (a,1)), List((c,1), (o,1), (s,1), (s,1)), List((c,1), (o,1), (s,1)), List((c,1), (o,1), (a,1), (s,1)), List((c,1), (o,1), (a,1)), List((c,1), (o,1), (s,1)), List((c,1), (o,1)), List((c,1), (s,1), (a,1), (s,1)), List((c,1), (s,1), (a,1)), List((c,1), (s,1), (s,1)), List((c,1), (s,1)), List((c,1), (a,1), (s,1)), List((c,1), (a,1)), List((c,1), (s,1)), List((c,1)), List((o,1), (s,1), (a,1), (s,1)), List((o,1), (s,1), (a,1)), List((o,1), (s,1), (s,1)), List((o,1), (s,1)), List((o,1), (a,1), (s,1)), List((o,1), (a,1)), List((o,1), (s,1)), List((o,1)), List((s,1), (a,1), (s,1)), List((s,1), (a,1)), List((s,1), (s,1)), List((s,1)), List((a,1), (s,1)), List((a,1)), List((s,1)), List())

complemento(List(('c', 1), ('o', 1), ('s', 1), ('a', 1), ('s', 1)), List(('c', 1), ('o', 1), ('s', 1), ('a', 1), ('s', 1))) // List()

anagramasDeFrase(List("y", "cosas")) // List(List(cosas, y), List(y, cosas))

