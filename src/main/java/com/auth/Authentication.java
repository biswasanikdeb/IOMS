package com.auth;

public class Authentication {
    private String[][] combination = { { "hello", "pass" }, { "hello2", "pass2" } };
    private boolean check;

    public boolean passCheck(String username, String pass) {

        for (int i = 0; i < combination.length; i++) {
            if (combination[i][0].equals(username) && combination[i][1].equals(pass)) {
                check = true;
                break;
            } else {
                check = false;
            }
        }
        System.out.println(check);
        return check;
    }

    public void userAdd() {
        if (check != true) {

        }
    }
}