package ca.uwaterloo.iqc.bakeoutcontroller_kernel.models;

import ca.uwaterloo.iqc.bakeoutcontroller_kernel.controllers.RS232PortConfigurationFactory;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.PortConfiguration;
import ca.uwaterloo.iqc.bakeoutcontroller_kernel.serial_ports.RXTXPortConfiguration;
import org.jetbrains.annotations.Contract;

/**
 * Factory for creating RS232 port configurations capable of working with
 * the RXTX driver
 */
public final class RXTXPortConfigurationFactory implements
        RS232PortConfigurationFactory {
    private Integer baudRate;
    private Integer dataBits;
    private Integer stopBits;
    private Integer parityBits;

    @Override public void setBaudRate(Integer baudRate){
        this.baudRate = baudRate;
    }

    @Override public void setDataBits(Integer dataBits){
        this.dataBits = dataBits;
    }

    @Override public void setStopBits(Integer stopBits){
        this.stopBits = stopBits;
    }

    @Override public void setParityBits(Integer parityBits){
        this.parityBits = parityBits;
    }

    @Contract(" -> !null")
    @Override public PortConfiguration getConfiguration(){
        return new RXTXPortConfiguration(
            baudRate, stopBits, dataBits, parityBits
        );
    }
}
