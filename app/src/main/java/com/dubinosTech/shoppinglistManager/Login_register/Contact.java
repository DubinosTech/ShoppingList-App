
package com.dubinosTech.shoppinglistManager.Login_register;
/**
 * @author DubinosTeck
 * Emmanuel Asinyo
 * Brahim Kanouche
 */


public class Contact {
    private static final int LEN=100;
    private static String[] password= new String[LEN];
    private static String[] email= new String[LEN];

    private static int indexEmail=0;
    private static int indexPass=0;

    public boolean getPassword(String password) {


        for (int i=0;i<this.indexPass;i++)
        {if  (this.password[i].equals(password)) return true;
        }
        return false;
    }

    public void setPassword(String password) {
        this.password[indexPass] = password;
        indexPass +=1;
    }

    public boolean getEmail(String email) {


        for (int i=0;i<this.indexEmail;i++)
        {if  (this.email[i].equals(email)) return true;
        }
        return false;
    }

    public void setEmail(String email) {
        this.email[indexEmail] = email;
         indexEmail +=1;
    }





}



