/**
 * @author João Paulo
 */

package main.java.br.com.luishep.exceptions;

public class TypeKeyNotFound extends Exception{
    private static final long serialVersionUID = -138949676398525746L;

    public TypeKeyNotFound(String msg) {
        this(msg, null);
    }

    public TypeKeyNotFound(String msg, Throwable e) {
        super(msg, e);
    }
}
