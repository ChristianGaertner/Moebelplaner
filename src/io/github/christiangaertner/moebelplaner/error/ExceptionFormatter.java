package io.github.christiangaertner.moebelplaner.error;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author Christian
 */
public class ExceptionFormatter extends Formatter {

    @Override
    public String format(LogRecord lr) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(lr.getLevel().getLocalizedName())
                .append(": ");
        
        String exMsg = lr.getThrown().getMessage();
        
        if (lr.getMessage() == null && exMsg != null) {
            sb.append(exMsg);

        } else if(lr.getMessage() != null && exMsg != null) {
            sb.append(lr.getMessage())
                    .append("\n")
                    .append("ExcpetionMessage: \n")
                    .append(lr.getThrown().getMessage());
        } else if(exMsg != null) {
            sb.append(exMsg);
        } else if(lr.getMessage() != null) {
            sb.append(lr.getMessage());
        } else {
            sb.append("Unknown Error");
        }
                
        return sb.toString();
    }
    
}
