/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dennis
 */
@XmlRootElement

public class Benutzer {
private String Name;
private String Nachname;
private String Geschlecht;
private int Geburtsdatum;
private String Wohnort;
private String Benutzername;
private String Passwort;
  

  public String getName()
  {
    return Name;
  }
  public void setName( String Name){
    this.Name = Name;
  }
 
  public String getNachname()
  {
    return Nachname;
  }
  public void setNachname( String Nachname){
    this.Nachname = Nachname;
  }
  
  public String getGeschlecht()
  {
    return Geschlecht;
  }
public void setGeschlecht( String Geschlecht){
    this.Geschlecht = Geschlecht;
  }

  public void setGeburtsdatum( int Geburtsdatum )
  {
    this.Geburtsdatum = Geburtsdatum;
  }

  public int getGeburtsdatum()
  {
    return Geburtsdatum;
  }

   public String getWohnort()
  {
    return Wohnort;
  }
  public void setWohnort( String Wohnort){
    this.Wohnort = Wohnort;
  }  
  
  public String getBenutzername()
  {
    return Benutzername;
  }
  public void setBenutzername( String Benutzername){
    this.Benutzername = Benutzername;
  }  

    public String getPasswort()
  {
    return Passwort;
  }
  public void setPasswort( String Passwort){
    this.Passwort = Passwort;
  } 
}

    
    
    
   