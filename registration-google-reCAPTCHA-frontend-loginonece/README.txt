Adding features of limiting multiple login.


A couple of high-level changes

1. Add the Thymeleaf pom entries

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.thymeleaf.extras</groupId>
			<artifactId>thymeleaf-extras-springsecurity5</artifactId>
		</dependency>

2. Spring Boot Auto-Configuration
When Spring Boot finds Thymeleaf dependency in the Maven POM file, it automatically configures Thymeleaf template engine. 
No need to manually configure Thymeleaf in our code since it is auto-configured by Spring Boot.

3. Create Thymeleaf views
See code examples in: src/main/resources/templates


