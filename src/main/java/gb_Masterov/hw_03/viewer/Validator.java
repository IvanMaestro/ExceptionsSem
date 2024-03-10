package gb_Masterov.hw_03.viewer;

import gb_Masterov.hw_03.model.Human;

public interface Validator {
    Human validate(String[] rawData) throws Exception;
}
