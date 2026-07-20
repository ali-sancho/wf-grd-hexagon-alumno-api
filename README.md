curl localhost:8080/alumnos/activos | jq

curl -i localhost:8080/alumnos/activos

curl -iX POST localhost:8080/alumnos -H "Content-Type: application/json" -d '{"id":1,"nombre":"Ali","apellido":"Sancho","edad": 48, "estado":"ACTIVO"}'

curl -iX POST localhost:8080/alumnos -H "Content-Type: application/json" -d '{"id":2,"nombre":"Isabel","apellido":"Canaza","edad": 70, "estado":"ACTIVO"}'
