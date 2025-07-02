FROM azul/zulu-openjdk:17-latest

# New Relic 복사 (필요 시 직접 복사하거나, 빌드 단계에서 포함)
COPY newrelic /newrelic

# 애플리케이션 복사
COPY build/libs/*.jar app.jar

# New Relic Agent 실행과 함께 애플리케이션 시작
ENTRYPOINT ["java", "-javaagent:/newrelic/newrelic.jar", "-Dnewrelic.config.file=/newrelic/newrelic.yml", "-jar", "/app.jar"]
