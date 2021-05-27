package vu.lt.usecases;

import vu.lt.qualifiers.Standard;

@Standard
public class ValidNameChecker {
    public boolean isValidName(String companyName){
        if (companyName.length() < 3) {
            return false;
        }
        return true;
    }
}
