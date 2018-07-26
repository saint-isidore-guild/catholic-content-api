# Catholic Content API
RESTful endpoints for prayers, etc.

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

get a full list of prayers
```
curl -i localhost:8080/prayers
```
get a prayer by id
```
curl -i localhost:8080/prayers/1
```

### Tests
```
./gradlew test
```
