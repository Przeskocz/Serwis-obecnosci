# Serwis-obecnosci
Serwis obsługujący obecności studentów na wykładach
```bash
Aplikacja Spring Boot
```

## URL wykorzystywane w aplikacji

JSON wszystkich studentów i przedmiotów
```
/all
```
### Obecności
JSON wszystkich obecności
```
/obecnosci
```

JSON konkretnej obecności
```
obecnosci/{id}
```

JSON obecności według kryteriów 
```
obecnosci/create/{ByCriteria}
```

### Studenci
Widok wszystkich studentów
```
/studenci
```

Widok konkretnego studenta
```
studenci/{id}
```

Tworzenie studenta
```
studenci/create?name=value&surname=value&age=value
```

Aktualizacja studenta
```
studenci/update?id=value&name=value&surname=value&age=value
```

Usunięcie stuenta
```
studenci/delete/{id}
```

### Przedmioty
JSON wszystkich przedmiotów
```
/przedmioty
```

JSON konkretnego przedmiotu
```
przedmioty/{id}
```

Tworzenie nowego przedmiotu
```
przedmioty/create?name=value&length=value
```

Usunięcie przedmiotu o podanym id
```
przedmioty/delete/{id}
```

Aktualizacja przedmiotu o podanym id i nowych wartościach
```
przedmioty/update/{id}?name=value&length=value
```
