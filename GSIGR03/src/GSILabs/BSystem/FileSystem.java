/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BSystem;

import java.io.File;
import persistence.ODSPersistent;

/**
 * FileSystem is a subsystem for manage the files to load and save info
 * @author GR03
 * @version 1.0
 */
public class FileSystem implements ODSPersistent{

    @Override
    public boolean loadFromFile(File f) {
        return false;
    }

    @Override
    public boolean saveToFile(File f) {
        return false;
    }
    
}
