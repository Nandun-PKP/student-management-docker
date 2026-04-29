# 1. Java Runtime එකක් විදිහට Alpine Linux පාවිච්චි කරමු (Size එක අඩු නිසා)
FROM eclipse-temurin:21-jdk-alpine

# 2. Container එක ඇතුළේ /app කියලා folder එකක් හදමු
WORKDIR /app

# 3. ඔයාගේ project එකේ build වුණ .jar file එක container එකට copy කරමු
# (target folder එක ඇතුළේ තියෙන .jar file එක)
COPY target/*.jar app.jar

# 4. Spring Boot වැඩ කරන port එක (8080) open කරමු
EXPOSE 8090

# 5. App එක run කරන්න ඕනේ command එක
ENTRYPOINT ["java", "-jar", "app.jar"]