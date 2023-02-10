# SOAP


## Serving

http://localhost:8080/ws/countries.wsdl

curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws > output.xmlcurl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws > output.xml

## Consuming

http://localhost:8081/test

http://localhost:8081/country

http://localhost:8081/myobject