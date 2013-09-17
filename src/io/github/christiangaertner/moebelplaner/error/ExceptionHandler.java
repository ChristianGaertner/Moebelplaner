package io.github.christiangaertner.moebelplaner.error;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class ExceptionHandler extends Handler {

    public ExceptionHandler() {
        setFormatter(new ExceptionFormatter());
    }
    
    @Override
    public void publish(LogRecord lr) {
        JOptionPane.showMessageDialog(null, getFormatter().format(lr), "Error!", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {
    }
}
