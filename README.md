# Hogwarts Artifacts Online - Spring Boot Application

[![GitHub Workflow Status (with event)](https://img.shields.io/github/actions/workflow/status/Washingtonwei/hogwarts-artifacts-online/maven-build.yml?logo=apachemaven&label=Maven%20Build)](https://github.com/Washingtonwei/hogwarts-artifacts-online/actions/workflows/maven-build.yml) [![GitHub Workflow Status (with event)](https://img.shields.io/github/actions/workflow/status/Washingtonwei/hogwarts-artifacts-online/azure-webapps-deploy.yml?logo=microsoftazure&label=Azure%20Deployment)](https://github.com/Washingtonwei/hogwarts-artifacts-online/actions/workflows/azure-webapps-deploy.yml) ![Dynamic XML Badge](https://img.shields.io/badge/dynamic/xml?url=https%3A%2F%2Fraw.githubusercontent.com%2FWashingtonwei%2Fhogwarts-artifacts-online%2Fmain%2Fpom.xml&query=%2F*%5Blocal-name()%3D'project'%5D%2F*%5Blocal-name()%3D'properties'%5D%2F*%5Blocal-name()%3D'java.version'%5D&label=Java) ![Dynamic XML Badge](https://img.shields.io/badge/dynamic/xml?url=https%3A%2F%2Fraw.githubusercontent.com%2FWashingtonwei%2Fhogwarts-artifacts-online%2Fmain%2Fpom.xml&query=%2F*%5Blocal-name()%3D'project'%5D%2F*%5Blocal-name()%3D'parent'%5D%2F*%5Blocal-name()%3D'version'%5D&label=Spring%20Boot) ![Dynamic XML Badge](https://img.shields.io/badge/dynamic/xml?url=https%3A%2F%2Fraw.githubusercontent.com%2FWashingtonwei%2Fhogwarts-artifacts-online%2Fmain%2Fpom.xml&query=%2F*%5Blocal-name()%3D'project'%5D%2F*%5Blocal-name()%3D'properties'%5D%2F*%5Blocal-name()%3D'spring-cloud-azure.version'%5D&label=Spring%20Cloud%20Azure)

## What is 🧙‍♂️ Hogwarts Artifacts Online 🧙‍♀️?

Welcome to *Hogwarts Artifacts Online*, a sample back-end application designed to demonstrate typical use cases and best
practices in Spring Boot development. I wrote this sample application **line-by-line from scratch** in my YouTube course
titled ["Learn Spring Boot 3 with Bingyang" ![Static Badge](https://img.shields.io/badge/YouTube-white?logo=youtube&logoColor=red)](https://youtube.com/playlist?list=PLqq9AhcMm2oPdXXFT3fzjaKLsVymvMXaY&si=QTkudVtqVpO1jPBA).

Throughout the course, *Hogwarts Artifacts Online* serves as a running example and is developed progressively. That is,
each episode introduces new Spring Boot features that add functionality or improvements to this project. This approach
helps you see how different concepts fit together in a practical context.

In addition to exploring the features of Spring Boot, the course delves into essential software engineering practices.
We will start by framing user stories, then move on to crafting REST APIs and applying object-oriented design
principles. Embracing test-driven development, we will meticulously build and refine each feature. The culmination of
this journey is setting up a comprehensive CI/CD pipeline, ensuring smooth deployment of the application.

**Suitable for Muggles and Wizards Alike**

Whether you're new to Spring Boot or an experienced developer looking to add some magic to your skillset, *Hogwarts
Artifacts Online* is the perfect place to start. As you follow along with the videos, I encourage you to actively code
alongside me. Engaging in hands-on practice is an excellent method for mastering programming skills. So grab your wand
🪄 (or keyboard ⌨️) and prepare to embark on a journey
into ["Learn Spring Boot 3 with Bingyang" ![Static Badge](https://img.shields.io/badge/YouTube-white?logo=youtube&logoColor=red)](https://youtube.com/playlist?list=PLqq9AhcMm2oPdXXFT3fzjaKLsVymvMXaY&si=QTkudVtqVpO1jPBA)!

## What Will You Learn?

Through my YouTube course, you will gain practical experience in:

- **Dependency Injection** and the use of Spring Framework's core container.
- Building the web layer with **Spring MVC (Model-View-Controller)**.
- Data persistence in relational databases using **Spring Data JPA (Jakarta Persistence API)**.
- User authentication and authorization with **Spring Security** and **JWT (JSON Web Tokens)**.
- Deploying a Spring Boot application to a cloud platform with **Spring Cloud Azure**.
- Monitoring a running Spring Boot application in the production with **Spring Boot Actuator**.
- Making requests to OpenAI API with **RestClient**.
- Paging and sorting.
- Writing dynamic queries with Spring Data JPA Specifications.
- And more.

Additionally, my course emphasizes good software engineering practices, such as:

- Defining software requirements with **User Stories**.
- Version control and project planning using **Git and GitHub**.
- The **API-First Approach** in designing effective REST APIs.
- **Test-Driven Development (TDD)**: writing tests first, then coding to pass the tests, and refactoring.
- **Object-Oriented Design** with UML.
- **CI/CD (Continuous Integration and Continuous Delivery)** with GitHub Actions.

## Documentation

### Project User Stories

🔗 [The mind map of the Hogwarts Artifacts Online user stories](https://xmind.app/m/999Pse)

### API Documentation

🔗 [Hogwarts Artifacts Online API Documentation](https://app.swaggerhub.com/apis/Washingtonwei/hogwarts-openapi)

## Run Hogwarts Artifacts Online Locally

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Washingtonwei/hogwarts-artifacts-online.git
   ```

2. **Navigate to the project directory:**

   ```bash
   cd hogwarts-artifacts-online
   ```
3. **Launch Redis**

This Spring Boot application uses Redis for caching. You can run a Redis container using Docker:

   ```bash
   docker run -d -p 6379:6379 redis
   ```

4. **Run the application:**

Since *Hogwarts Artifacts Online* is a Spring Boot application built using Maven, you can run it from Maven directly
using the Spring Boot Maven plugin:

   ```bash
   ./mvnw spring-boot:run
   ```

Or on Windows:

   ```bash
   .\mvnw.cmd spring-boot:run
   ```

## Building a Container

There is a `Dockerfile` in this project. You can build a container image (if you have a docker daemon):

```bash
./mvnw clean package -DskipTests # First, build the JAR file
docker build . # Second, build the container image
```

## Database Configuration

In its default configuration, *Hogwarts Artifacts Online* uses an in-memory database (H2) which
gets populated at startup with data. The H2 console is available at <http://localhost/h2-console>,
and it is possible to inspect the content of the database using the `jdbc:h2:mem:hogwarts` URL.

I have defined a
class [`edu.tcu.cs.hogwartsartifactsonline.system.DBDataInitializer`](https://github.com/Washingtonwei/hogwarts-artifacts-online/blob/main/src/main/java/edu/tcu/cs/hogwartsartifactsonline/system/DBDataInitializer.java)
to populate the H2 database at startup.

## Accessing the API Endpoints

[![Static Badge](https://img.shields.io/badge/Postman-white?logo=postman&logoColor=red)](https://www.postman.com/bingyang-wei/workspace/youtube-workspace/collection/7025773-2279d7bf-70f4-4825-9a74-8f46a6b6efaa?action=share&creator=7025773) [<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://god.gw.postman.com/run-collection/7025773-2279d7bf-70f4-4825-9a74-8f46a6b6efaa?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D7025773-2279d7bf-70f4-4825-9a74-8f46a6b6efaa%26entityType%3Dcollection%26workspaceId%3D4369fd7f-4a25-4f67-bc60-4acc92fc0c9e)

## Contributing

The [issue tracker](https://github.com/Washingtonwei/hogwarts-artifacts-online/issues) is the preferred channel for bug
reports, feature requests, and submitting pull requests.

## License

The *Hogwarts Artifacts Online* application is released under version 2.0 of
the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).

## Acknowledgements

- Inspired by the Spring PetClinic Sample Application.
- Inspired by J.K. Rowling's Harry Potter series.

## YouTube Videos

If you're looking to enhance your understanding of this Spring Boot tutorial, I highly recommend watching the
accompanying YouTube video playlist. It provides a comprehensive walk-through of the concepts and code discussed here,
complete with visual demonstrations and step-by-step explanations. Whether you're a visual learner or just prefer a more
interactive approach, those videos are a valuable resource to solidify your grasp of Spring Boot.

Check them out now below to dive deeper into the world of Spring Boot development!

1. [Introduction to Spring Boot 3 Tutorial](https://youtu.be/asS2kcalidY)
2. [What is Spring?](https://youtu.be/B7irjHrHAJo)
3. [Inversion of Control and Dependency Injection](https://youtu.be/FqOQZ1Jvgng)
4. [What is Spring Boot?](https://youtu.be/dpJyNIsQPnc)
5. [Spring Boot Quick Demo](https://youtu.be/JIpaStgf7dE)
6. [Spring Boot Project Structure](https://youtu.be/UlwpnsCjcIs)
7. [Spring Boot Quick Demo Implementation](https://youtu.be/7wWLM-nGzPc)
8. [pom.xml Demystified](https://youtu.be/B7awqZkwvlc)
9. [spring-boot-starter-parent](https://youtu.be/KryEleNWawA)
10. [Introduction to Hogwarts Artifacts Online](https://youtu.be/n5AwXuDeWW8)
11. [Requirements of the Project](https://youtu.be/98npP43Y56g)
12. [Creating a Spring Boot Project and Pushing it to GitHub](https://youtu.be/W7xJf5Wknho)
13. [Project Planning Using GitHub Issues](https://youtu.be/vaIwnefOKZ4)
14. [API-First Approach](https://youtu.be/R0FtVayTJLk)
15. [Creating a Feature Branch for Issue 1 Artifact CRUD](https://youtu.be/yULf9LwWabo)
16. [Object-Oriented Design Using Class Diagram](https://youtu.be/bSLXER_84i8)
17. [Object-Oriented Design Using Sequence Diagram](https://youtu.be/rShN11Hrj-4)
18. [Creating Controller, Service, and Repository for Artifacts](https://youtu.be/Dv1rDEBlkkY)
19. [Introduction to Test Driven Development (TDD)](https://youtu.be/wsny05elumw)
20. [Implementing ArtifactService Using TDD](https://youtu.be/ZjfEpuW8JSM)
21. [Implementing ArtifactController Using TDD](https://youtu.be/BM7TjjJinXA)
22. [Populating the H2 Database with Test Data](https://youtu.be/EGHQZBLAPuQ)
23. [API Integration Testing, Postman, JSON Infinite Recursion, and Data Transfer Object (DTO)](https://youtu.be/N_XlgBpdt6I)
24. [Implementing Find All Artifacts (User Story in GitHub Issue 1)](https://youtu.be/wreoEbmW83w)
25. [Implementing Add an Artifact (User Story in GitHub Issue 1)](https://youtu.be/qe0jM0E8kko)
26. [Implementing Update an Artifact (User Story in GitHub Issue 1)](https://youtu.be/uXh361rDST8)
27. [Implementing Delete an Artifact (User Story in GitHub Issue 1)](https://youtu.be/Rsd9FyQzwDc)
28. [Pushing a Feature Branch to GitHub and Creating a Pull Request](https://youtu.be/Uc9JnXfIv-4)
29. [Homework (Wizard CRUD APIs, Issue 2)](https://youtu.be/bFGhTN5CUTs)
30. [Wizard CRUD APIs (Issue 2) Homework Solution](https://youtu.be/HXmsEk9nXWs)
31. [Code Refactoring](https://youtu.be/kTNArwaaUN4)
32. [Implementing Artifact Assignment (Issue 3)](https://youtu.be/W_55A9hAddw)
33. [Implementing User CRUD APIs](https://youtu.be/-1rRqa7oORI)
34. [Introduction to Spring Security](https://youtu.be/PDAda_bQAv0)
35. [Implementing HTTP Basic Authentication in Spring Boot](https://youtu.be/GtmQ1Yw8QNc)
36. [Introduction to JWT](https://youtu.be/WrmGrmF6sc4)
37. [Generating JWTs in Spring Boot](https://youtu.be/P2L7DvxQC_I)
38. [Handling Spring Security Exceptions Using @ControllerAdvice](https://youtu.be/sCYoQIBND6w)
39. [Testing with Spring Security](https://youtu.be/o9FlC_auq64)
40. [Enabling CORS in Spring Boot](https://youtu.be/5HAzLAnJPKU)
41. [Committing and Pushing to a GitHub Repo](https://youtu.be/RbpmXJdo6KM)
42. [Introduction to Spring Boot Packaging and Deployment](https://youtu.be/8XgRTB_1xws)
43. [Packaging a Spring Boot Application into an Executable JAR](https://youtu.be/O2hbIjEteYU)
44. [Containerizing a Spring Boot Application](https://youtu.be/i6xuO_HBdX4)
45. [Introduction to CI and CD with GitHub Actions](https://youtu.be/wWci4Belkb0)
46. [Spring Boot Continuous Integration with GitHub Actions](https://youtu.be/0QyBY1tMoVk)
47. [Deploying Spring Boot Applications to Azure with GitHub Actions](https://youtu.be/ClyrdJMCE8o)
48. [Setting Up Staging Environments in Azure App Service](https://youtu.be/kkKnandU_KM)
49. [Connecting Spring Boot to a MySQL Database with Azure Key Vault](https://youtu.be/Giqn99rZGaM)
50. [Spring Boot Actuator](https://youtu.be/u51q4Oq0a5k)
51. [Observing a Spring Boot Application with Actuator, Prometheus, Grafana, and Zipkin](https://youtu.be/aqwGRRgiMPI)
52. [Upgrading a Spring Boot Application](https://youtu.be/EkxgbjFqOrY)
53. [Connecting Spring Boot to OpenAI with RestClient](https://youtu.be/WMSYLAby2YU)
54. [Paging and Sorting](https://youtu.be/pbsxk-sX8Pc)
55. [Spring Data JPA Specifications](https://youtu.be/AWBSWlM0JmQ)
56. [Uploading Files to Azure Blob Storage from Spring Boot](https://youtu.be/v_4z8wzel8Y)
57. [Restricting User Access to Their Own Data](https://youtu.be/j1EvF_iUNMQ)
58. [Changing Passwords and Revoking JWTs with Redis](https://youtu.be/p2yuefQ6apQ)
