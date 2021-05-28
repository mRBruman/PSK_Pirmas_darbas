package vu.lt.usecases;

import vu.lt.qualifiers.Base;

@Base
public class NameValidator {
    public boolean isValidName(String companyName){
        if (companyName.length() < 1) {
            return false;
        }
        return true;
    }
}
