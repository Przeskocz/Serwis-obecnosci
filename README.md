# Serwis-obecnosci
Serwis obsługujący obecności studentów na wykładach
```bash
Aplikacja Spring Boot
```

## URL wykorzystywane w aplikacji

/all
```
JSON wszystkich studentów i przedmiotów
```



/obecnosci
```
JSON wszystkich obecności
```

+/{id}
```
JSON konkretnej obecnosci
```

+/create/{ByCriteria}
```
JSON obecności według kryteriów 
```



/studenci
```
widok wszystkich studentów
```

+/{id}
```
widok konkretnego studenta
```

+/create?name=value&surname=value&age=value
```
tworzenie studenta
```

+/update?id=value&name=value&surname=value&age=value
```
aktualizacja studenta
```

+/delete/{id}
```
usuniecie stuenta
```



/przedmioty
```
JSON wszystkich przedmiotów
```

+/{id}
```
JSON konkretnego przedmiotu
```

+/create?name=value&length=value
```
tworzenie nowego przedmiotu
```

+/delete/{id}
```
usunięcie przedmiotu o podanym id
```

+/update/{id}?name=value&length=value
```
aktualizacja przedmiotu o podanym id i nowych wartosciach
```
