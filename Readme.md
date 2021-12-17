AspectOriented Programming start

created the project with spring initilazer . in the pom.xml manually added these 2 dependencies for aspectJ reason: SpringBoot makes use of aspectJ codes and it requires these classes to work upon.

Dependency1:

 <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.7</version>
</dependency>
Dependency2: just in case if 1st one alone is not working. org.aspectj aspectjrt

 <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjrt</artifactId>
            <version>1.8.9</version> 
</dependency>