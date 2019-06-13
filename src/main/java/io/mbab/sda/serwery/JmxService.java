package io.mbab.sda.serwery;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "sda.mb.serwery:name=JmxService")
@Slf4j
public class JmxService {

    @ManagedOperation
    public void managedOperation(String param) {
        log.info("Invoked operation via jmx with parameter: {}", param);
    }
}
