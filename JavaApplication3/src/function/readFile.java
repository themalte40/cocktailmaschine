  /*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package function;
/**
*
* @author muuuh
*/
import java.io.*;
import Gui.Hauptansichtneu;

public class readFile {

    private String BasisPfad=Hauptansichtneu.BasisPfad+"/Cocktails/rezepte/";
/**
* Initaialsierung der Komponenten
* zum Einlesen der Cocktaildatenbank
*/
    private FileReader CocktailEinlesen;
    private BufferedReader InputCocktailInfo;
/**
* Initialisierung der kompontente zum Einliesen
* der Rezepte
*/
    private FileReader RezeptEinlesen;
    private BufferedReader InputRezeptInfo;
/**
* Initialisierung der Komponten um den Status (Menge der ausgefüllten
* Getränke, zuletzt geladenes Rezept) der Maschine einzulesen
*/
    private FileReader StatusEinlesen;
    private BufferedReader InputStatus;
    private String StrRezeptauswahl;
    private String[] StringStatus=new String [17];
    /**
    *
    * @param CocktailID_Input
    */
    public readFile( Boolean Rezept){
        try{
        StatusEinlesen = new FileReader(BasisPfad+"stat.md");
        InputStatus = new BufferedReader(StatusEinlesen);
        }
        catch (FileNotFoundException e){
        System.out.println(e.getMessage());
        }
/*
Wenn nur der Staus abgefragt werden soll sollen nicht die rezepte eingelesen werden
*/
        try{
        setLastStat();
        }
        catch (EOFException e){
        }
        if (Rezept){
            try{
            CocktailEinlesen = new FileReader(BasisPfad+"meep"+StringStatus[0]+".md");
            InputCocktailInfo = new BufferedReader(CocktailEinlesen);
            }
            catch (FileNotFoundException b){
                System.out.println("no meepx.md in directory");
            }
            try{
                RezeptEinlesen = new FileReader(BasisPfad+"meep"+StringStatus[0]+".mdr");
                InputRezeptInfo = new BufferedReader(RezeptEinlesen);
            }
            catch (FileNotFoundException e){
                System.out.println(e.getMessage());
}
}
}
            private void setLastStat () throws EOFException{
                int i;
                try{
                    for (i=0; i <17; i++){
                        if ((StringStatus[i]= InputStatus.readLine()) == null){
                        StringStatus[i]= "-";
                        throw new EOFException("EndofSpecs at stat.md");
                     }
                    System.out.println(StringStatus[i]);
                }
            }
            catch (IOException e){
                 System.out.println(e.getMessage());
                 throw new EOFException("EndofSpecs at stat.md");
                 }
            }
public String StringGet_Rezept() throws EOFException{
    String zeile;
    try{

        if ((zeile = InputRezeptInfo.readLine()) == null) {

            zeile =	"-"; // wenn keine zeile mehr da ist wird der Rückgabewert "-" ansonsten die Zeile
            throw new EOFException("EndofSpecs at meepX.mdr");
        }
    }
    catch( IOException a) {
        System.out.println("EndofSpecs at meepX.mdr");
        throw new EOFException("EndofSpecs at meepX.mdr");
        //return "error reading line";
    }
    System.out.println(zeile);
    return zeile;
}
public String StringGet_CocktailInfo() throws EOFException{
    String zeile;
    try{

        if ((zeile = InputCocktailInfo.readLine()) == null) {

            zeile =	"-"; // wenn keine zeile mehr da ist wird der Rückgabewert "-" ansonsten die Zeile
            throw new EOFException("EndofSpecs at meepX.md");
        }
    }
    catch( IOException a) {
        throw new EOFException("EndofSpecs at meepX.md");
        //return "error reading line";
    }
    
    System.out.println(zeile);
    return zeile;
    }
} 