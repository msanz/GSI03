/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */
package GSILabs.persistence;

/**
 * Managent a XMLParsingException
 * @author GR03
 * @version 1.0
 */
public class XMLParsingException extends Exception{
    public XMLParsingException(){}    
    /**
     * Show the massage with the exception is catched
     * @param string the message that we want to show.
     * @return The message
     */
    public String errorParsingException(String string){
        return "Error provocado.";
    }
}
