package io.mbab.sda.serwery;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "sda.mb.serwery:name=JmxService")
@Slf4j
public class JmxService {

    private LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

    @ManagedOperation
    public void setLoggingLevel(String level) {
        loggerContext.getLogger("io.mbab.sda.serwery")
                .setLevel(Level.valueOf(level));

        log.info("Logging level set to: {}", level);
    }

    @ManagedOperation
    public String getLoggingLevel() {
        return loggerContext.getLogger("io.mbab.sda.serwery")
                .getLevel()
                .toString();
    }
}
