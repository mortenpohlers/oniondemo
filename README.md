# Demo Projekt für eine Onion Architektur

## Module

* oniondemo-core: Der Core ist in ein eigenes Modul ausgelagert und wird entsprechend als eigenes jar erstellt. Dieses wird in dem Projekt [berechnungsnativ](https://github.com/mortenpohlers/berechnungsnative) dazu verwendet, eine Shared Libaray zu bauen.
* oniondemo-application: Eine mittels Onion Architektur geschriebene Springboot Anwendung, die eine fiktive und fachliche völlig blödsinnige Tarifierung ausführt. Der dor implementierte REST service kann über die [swagger-ui](http://localhost:8080/swagger-ui/index.html) aufgerufen werden.  
