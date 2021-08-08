# restful-services-crud

![image](https://user-images.githubusercontent.com/52471507/128646564-74a723c8-3274-4d30-b766-320be58fdf9c.png)



**Internationalization** is the process of designing an application so that it can be adapted to various languages and regions without engineering changes.


**HATEOAS** is a constraint on REST that says that a client of a REST application 
need only know a single fixed URL to access it. Any and all resources should be discoverable 
dynamically from that URL through hyperlinks included in the representations of returned resources


Generally, resources can have multiple presentations, mostly because there may be multiple different clients expecting different representations. Asking for a suitable presentation by a client, is referred as **Content Negotiation**.-->jackson-dataformat-xml


**Swagger** is **documentation format** for RESTful.-->springfox-swagger2 & springfox-swagger-ui


**Spring Boot Actuator**  --> spring-boot-starter-actuator
is a sub-project of the Spring Boot Framework. It includes a number of additional features that help us to **_monitor and manage the Spring Boot application_**. It contains the actuator endpoints (the place where the resources live). 
through HAL we could see how many people are logged in the system and how many dependencies or beans are there.


**Filtering** in REST: don't want to send the passwod filed in the json format.-->@JsonIgnore & @JsonIgnoreProperties(Static filtering)
dynamic filtering


**Versioning** When the system evolves or the requirements change we do not want to change the APIs so much that our old system do not work and we want to cater the change and evolution of the requirements as well.
to acheive it we can do:

Versioning through URI Path.
Versioning through query parameters.
Versioning through custom headers.
Versioning through content negotiation.


**Richardson Maturity Model**
