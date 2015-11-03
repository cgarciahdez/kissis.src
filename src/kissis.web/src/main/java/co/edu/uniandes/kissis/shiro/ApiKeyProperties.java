/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.kissis.shiro;

import java.util.Properties;

/**
 *
 * @author windows 8
 */
public class ApiKeyProperties extends Properties
{ 
    public ApiKeyProperties() 
    {
        super.put("apiKey.id", System.getenv("STORMPATH_API_KEY_ID"));
        super.put("apiKey.secret", System.getenv("STORMPATH_API_KEY_SECRET"));
    }
}
