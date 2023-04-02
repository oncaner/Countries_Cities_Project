# Countries-Cities Project

İçerisinde Ülke ve Şehirler olan bir proje örneği.


### Gereksinimler

```
Java 11+
Maven
Lombok
PostgreSQL
Validation
Spring Data (Jpa)
```

## Nasıl çalışır?

```
1- Projeyi klonla.
2- PostgreSQL'de XXXX adında  bir Database oluştur.

3- Aşağıdaki konfigürasyonları "resources" dosyasında bulunan "application.properties" dosyasında yap.

  spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.hibernate.show-sql=true
  spring.datasource.url=jdbc:postgresql://localhost:5432/XXXX
  spring.datasource.username=postgres
  spring.datasource.password=12345
  spring.jpa.properties.javax.persistence.validation.mode = none


4- Projeyi çalıştır.
```



## Endpoints

### for Countries Controller
```
Request -> GET - URL: http://localhost:8080/api/countries (Tüm Country'leri getirir.)

Response Body -> Response Status: 200 - OK
[
  {
    "id": 0,
    "name": "string",
    "continent": "string",
    "population": 0
  }
]
```

```
Request -> GET - URL: http://localhost:8080/api/countries/{id} (Id'ye göre Country getirir.)

Response Body -> Response Status: 200 - OK

  {
    "id": 0,
    "name": "string",
    "continent": "string",
    "population": 0
  }
```

```
Request -> POST - URL: http://localhost:8080/api/countries/create (Country oluşturur.)
Request Body -> (Required)
{
  "name": "string",
  "continent": "string",
  "population": 0
}

Response Body -> Response Status: 201 - CREATED

  {
    "id": 0,
    "name": "string",
    "continent": "string",
    "population": 0,
    "cities": null
  }
```

```
Request -> PUT - URL: http://localhost:8080/api/countries/update (Id'ye göre Country günceller.)
Request Body -> (Required)
{
  "id": 0,
  "name": "string",
  "continent": "string",
  "population": 0
}

Response Body -> Response Status: 200 - OK

  {
    "id": 0,
    "name": "string",
    "continent": "string",
    "population": 0,
    "cities": null
  }
```

```
Request -> PATCH - URL: http://localhost:8080/api/countries/update/by-name (Name'ye göre Country günceller.)
Request Body -> (Required)
{
  "id": 0,
  "name": "string"
}

Response Body -> Response Status: 200 - OK

  {
  "id": 0,
  "name": "string",
  "continent": "string",
  "population": 0,
  "cities": []
}
```

```
Request -> PATCH - URL: http://localhost:8080/api/countries/update/by-continent (Continent'e göre Country günceller.)
Request Body -> (Required)
{
  "id": 0,
  "continent": "string"
}

Response Body -> Response Status: 200 - OK

  {
  "id": 0,
  "name": "string",
  "continent": "string",
  "population": 0,
  "cities": []
}
```

```
Request -> PATCH - URL: http://localhost:8080/api/countries/update/by-population (Population'a göre Country günceller.)
Request Body -> (Required)
{
  "id": 0,
  "population": 0
}

Response Body -> Response Status: 200 - OK

  {
  "id": 0,
  "name": "string",
  "continent": "string",
  "population": 0,
  "cities": []
}
```

```
Request -> DELETE - URL: http://localhost:8080/api/countries/delete/{id} (Id'ye göre Country siler.)
Request Body -> (Required)
{
  "id": 0,
}

Response Body -> Response Status: 200 - OK

```


### for Cities Controller
```
Request -> GET - URL: http://localhost:8080/api/cities (Tüm City'leri getirir.)

Response Body -> Response Status: 200 - OK
[
  {
    "id": 0,
    "name": "string",
    "population": 0,
    "region": "string",
    "countryName": "string"
  }
]
```

```
Request -> GET - URL: http://localhost:8080/api/cities/{id} (Id'ye göre City getirir.)

Response Body -> Response Status: 200 - OK
[
  {
    "id": 0,
    "name": "string",
    "population": 0,
    "region": "string",
    "countryName": "string"
  }
]
```

```
Request -> POST - URL: http://localhost:8080/api/cities/create (City oluşturur.)
Request Body -> (Required)
{
  "name": "string",
  "population": 0,
  "region": "string",
  "countryId": 0
}

Response Body -> Response Status: 201 - CREATED

  {
  "id": 0,
  "name": "string",
  "population": 0,
  "region": "string"
  }
```

```
Request -> PUT - URL: http://localhost:8080/api/cities/update (Id'ye göre City günceller.)
Request Body -> (Required)
{
  "id": 0,
  "name": "string",
  "population": 0,
  "region": "string"
}

Response Body -> Response Status: 200 - OK

  {
  "id": 0,
  "name": "string",
  "population": 0,
  "region": "string"
  }
```

```
Request -> PUT - URL: http://localhost:8080/api/cities/update/by-name (Name'ye göre City günceller.)
Request Body -> (Required)
{
  "id": 0,
  "name": "string"
}

Response Body -> Response Status: 200 - OK

  {
  "id": 0,
  "name": "string",
  "population": 0,
  "region": "string"
  }
```

```
Request -> PUT - URL: http://localhost:8080/api/cities/update/by-population (Population'a göre City günceller.)
Request Body -> (Required)
{
  "id": 0,
  "population": 0
}

Response Body -> Response Status: 200 - OK

  {
  "id": 0,
  "name": "string",
  "population": 0,
  "region": "string"
  }
```

```
Request -> PUT - URL: http://localhost:8080/api/cities/update/by-region (Region'a göre City günceller.)
Request Body -> (Required)
{
  "id": 0,
  "region": "string"
}

Response Body -> Response Status: 200 - OK

  {
  "id": 0,
  "name": "string",
  "population": 0,
  "region": "string"
  }
```

```
Request -> DELETE - URL: http://localhost:8080/api/cities/delete/{id} (Id'ye göre City siler.)
Request Body -> (Required)
{
  "id": 0,
}

Response Body -> Response Status: 200 - OK

```

## Exceptions for Countries

```
Request -> PUT & PATCH & GET(ById) & DELETE

Eğer mevcut bir CountryId'ye sahip data yok ise "CountryNotFoundException" fırlatır.

Response Body -> Response Status: 400 - BAD REQUEST
{
  "message": "Country not found with: {id}"
}

```

## Exceptions for Cities

```
Request -> PUT & PATCH & GET(ById) & DELETE

Eğer mevcut bir CityId'ye sahip data yok ise "CityNotFoundException" fırlatır.

Response Body -> Response Status: 400 - BAD REQUEST
{
  "message": "City not found with: {id}"
}

```
