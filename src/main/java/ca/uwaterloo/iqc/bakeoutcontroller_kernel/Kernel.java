package ca.uwaterloo.iqc.bakeoutcontroller_kernel;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.ConnectionRequestFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.DeviceConnector;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.RS232PortConfigurationFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.PortDriver;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.CommPortReporter;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.views.DeviceReporter;

/**
 * Describes the main application kernel
 */
public interface Kernel {
    /**
     * @return A view that can list the available serial ports on this machine
     */
    CommPortReporter getCommPortReporter();

    /**
     * @return A view that lists the available ca.uwaterloo.iqc.bakeoutcontroller_kernel.devices that can be implemented
     */
    DeviceReporter getDeviceReporter();

    RS232PortConfigurationFactory getRS232PortConfigurationFactory();

    DeviceConnector getDeviceConnector();

    PortDriver getPortDriver();

    ConnectionRequestFactory getConnectionRequestFactory();
}
