Aufgabe 4: Konzept

Eine Variante wäre eine History in der Datenbank zu erstellen. Diese History könnte z.B. aus einer eindeutigen Nummer und einem String, z.B. des Objekts mit seinen Parametern mit Create, Read, Update oder Delete, bestehen. Wenn man dann z.B. undo bei Objekt x, das Deletet wurde, machen will, wird einfach alles wieder hergestellt von Objekt x. Bei Update werden die vorherigen Parameter wieder hergestellt und bei Create wieder gelöscht. Read benötigt man in diesem Zusammenhang nicht.
