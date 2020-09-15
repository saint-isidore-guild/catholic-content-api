# Catholic Content API
RESTful endpoints for prayers, calculating Ember Days, etc.

## Uses
[Grails 3](http://docs.grails.org/3.3.x/)

## Setup
 - Grails 3: `$ sdk install grails 3.3.6`
 - Gradle (latest): `$ sdk install gradle`
 - Groovy (latest): `$ sdk install groovy`
 
## Run
```
./gradlew bootRun
```

### API Examples
get a full list of prayers
```
curl -i localhost:8080/prayers
```
get a prayer by id
```
curl -i localhost:8080/prayers/1
```
searching the name of a prayer returns that prayer and any language variations
```
curl -i "localhost:8080/prayers/search?q=our&max=10"
```

specify a language variant
```
curl -i "localhost:8080/prayers/search?q=our&lang=eng"
```

search

### Tests
```
./gradlew test
```
