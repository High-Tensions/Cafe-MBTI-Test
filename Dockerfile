FROM azul/zulu-openjdk:17-latest

# New Relic Java Agent 설치
RUN mkdir /newrelic
WORKDIR /newrelic
RUN curl -O https://download.newrelic.com/newrelic/java-agent/newrelic-agent/current/newrelic-java.zip \
    && unzip newrelic-java.zip

# 앱 jar 복사
WORKDIR /app
COPY build/libs/*.jar app.jar
COPY --from=0 /newrelic/newrelic /newrelic

ENTRYPOINT ["java", "-javaagent:/newrelic/newrelic.jar", "-jar", "/app.jar"]
