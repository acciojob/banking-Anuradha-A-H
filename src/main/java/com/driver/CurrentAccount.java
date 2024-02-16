package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception'
        super(name,balance,5000);
       if(balance<5000)
       {
           throw new InsufficientBalance("Insufficient Balance");
       }
        this.tradeLicenseId = tradeLicenseId;

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean hasConsecutiveChars = false;

        // check for consecutive characters
        for(int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if(tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                // we've found two consecutive characters that are the same
                // set the flag to true
                hasConsecutiveChars = true;
                break;
            }
        }

        // If there are consecutive characters, check if we can rearrange the id
        if(hasConsecutiveChars) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < tradeLicenseId.length(); i++) {
                map.put(tradeLicenseId.charAt(i), map.getOrDefault(tradeLicenseId.charAt(i), 0) + 1);
            }

            for(Character c : map.keySet()) {
                if(map.get(c) > (tradeLicenseId.length() / 2)) {
                    throw new Exception("Valid License can not be generated");
                }
            }
        }
    }

}
