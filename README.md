
# calculator
Calculadora con las funciones básicas de suma y resta. 

## Requisitos previos
Java 17 y Maven 3.9.3
Codigo descargado del github
Ejecutar el comando `mvn clean install` en la carpeta raíz del proyecto
Ejecutar el jar que se ha generado en la carpeta `/target` con el comando
 `java -jar target/calculadora-0.0.1-SNAPSHOT.jar`

El puerto configurado es 8080, se puede cambiar antes de generar el jar en el `application.properties`

Para probar la calculadora, puede hacerse mendiante el Swagger 

http://localhost:8080/swagger-ui/index.html

Los valores a introducir en el campo operations son 'sum' o 'subtract' (no case sensitive)

EJEMPLOS:

firstParam 1; secondParam  1; operation sum; --> Value calculate: 2
firstParam 2; secondParam  1; operation sum; --> Value calculate: 1

Si la operación introducida no puede está en la lista muestra el sigueinte error 
{
  "statusCode": 400,
  "message": "Operation not allowed",
  "requestUri": "/rest/calculator/calculates"
}

## Requisitos previos
Implementar nuevas funcionalidades:
 - Incluir la operación en el `application.properties`, separado por una coma con respecto al valor anterior.
 - Incluir la operación en el case del `CalculatorServiceImp.java` y la funcionaldiad del mismo. (Se debe tener en ceunta si es una divisón controlar el valor cero)
 