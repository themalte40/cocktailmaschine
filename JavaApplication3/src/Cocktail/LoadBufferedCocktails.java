/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cocktail;
import function.*;
import java.io.*;
import javax.imageio.IIOException;
/**
 *
 * @author root
 */
public class LoadBufferedCocktails {
    private String[] BufferCoktails=new String[45];
    private String[] BufferRezept = new String [16];
    private readFile loadSpecs;

    public LoadBufferedCocktails() throws IOException {
        int i=0;
        boolean EndofSpecs=false;
        loadSpecs=new readFile(true);
        
        /*
        hier werden alle Infos für den Cocktail ungeparst in den Buffer
        geschrieben. und so viele cocktails erzeugt wie es die Datei meetX.md 
        verlangt
        */
        while(EndofSpecs == false){
            try{          
                BufferCoktails[i]=loadSpecs.StringGet_CocktailInfo(); 
                i++;    
            }
            catch(EOFException a){
                EndofSpecs=true;
                System.out.println("File reading stopped reason: "+a.getMessage());
            }
                catch(StringIndexOutOfBoundsException stre){
                System.out.println(stre.getMessage());
            }
            catch (NullPointerException ne){
                throw new IOException("blöd gelaufen du noop!");
            }
        }
        
        /*
        hier wird das entsprechende rezept für den jeweiligen Cocktail in den Buffer 
        gelesen
        */
        EndofSpecs=false;
        i=0;
         while(EndofSpecs == false){
            try{          
                BufferRezept[i]=loadSpecs.StringGet_Rezept(); 
                i++;    
            }
            catch(EOFException a){
                EndofSpecs=true;
                System.out.println("File reading stopped reason: "+a.getMessage());
            }
            catch(StringIndexOutOfBoundsException stre){
                System.out.println(stre.getMessage());
            }
        }
    }
    
    
    private int getID(int InputCoctailID) throws IOException {
        char[] charID= new char[2];
        try{
        charID[0]=BufferCoktails[InputCoctailID-1].charAt(0);
        charID[1]=BufferCoktails[InputCoctailID-1].charAt(1);
        }
        catch(NullPointerException a){
            throw new IOException("Der Eintrag mit der Id "+InputCoctailID+" existiert nicht!");
        }
        String StirngID=new String(charID);
        try{
            return Integer.parseInt(StirngID);                
        }
        catch (NumberFormatException e){
            
        }
        return -1;
    }
    
    public void PrintContent(){
        for (int i=0 ;i<BufferCoktails.length && BufferCoktails[i]!= null;i++){
            System.out.println(BufferCoktails[i]);
        }
    }
    
    private String getName(int InputCoctailID) throws IOException {
        char[] charName=new char[100];
        try{
                for(int i=3;BufferCoktails[InputCoctailID-1].charAt(i)!=':'; i++)
                {
                    charName[i-3]=BufferCoktails[InputCoctailID-1].charAt(i);    
                }
        }
        catch(NullPointerException a){
            throw new IOException("Der Eintrag mit der Id "+InputCoctailID+" existiert nicht!");
        }
        return new String (charName);
    }
    
    private String getRezeptWerte( int InputCoctailID) throws IOException {
        char[] charRezept=new char[30];
        int i;
        try{
                for(i=3;BufferCoktails[InputCoctailID-1].charAt(i)!=':'; i++)
                {
                       
                }
                                
                charRezept[0]=' ';
                for(int j=(i+1);BufferCoktails[InputCoctailID-1].charAt(j)!=';'; j++)
                {
                    charRezept[j-i]=BufferCoktails[InputCoctailID-1].charAt(j);    
                }
        }
        catch (NullPointerException a){
            throw new IIOException("Der Eintrag mit der Id "+InputCoctailID+" existiert nicht!");
        }
        return new String (charRezept);
    }
    
    public Cocktail CocktailErzeugen(int InputCoctailID) throws IIOException {
        Cocktail temp;
        try{
            temp = new Cocktail(getID(InputCoctailID),getName(InputCoctailID),getRezeptWerte(InputCoctailID),"leer", BufferRezept );
            System.out.println("load Rezept: "+getRezeptWerte(InputCoctailID));
        }
        catch (IOException a){
            throw new IIOException("Fehler beim erzeugen des Cocktails");
        }
                return temp ;
    }
    
    public Cocktail[] alleCocktailsErzeugen(){
        Cocktail alleCocktails[] = new Cocktail[45];
        try{
            for(int i=1; i<45;i++){

                alleCocktails[i-1]=CocktailErzeugen(i);
            }
        }
        catch (IIOException a){
 
        }
        
        return alleCocktails;
    }
}