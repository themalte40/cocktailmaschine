/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package function;

import java.io.IOException;
import Gui.Hauptansichtneu;

/**
 *
 * @author muuuh
 */
public class ModbusPrint {
    
    private String StringModbusSPSInputNachricht;
    private String StringCProgrammPfad;
    private LinuxInteractor DebianKommando = new LinuxInteractor();
    
    public ModbusPrint( /*String StringCProgrammInputPfad,*/ String StringModbusInputNachricht )
    {
        StringModbusSPSInputNachricht=StringModbusInputNachricht;
        //StringCProgrammPfad=StringCProgrammInputPfad;
    }
    
    public void printSPS() throws IOException {
        String output;
        System.out.println("start Printing \n");
        output=DebianKommando.executeCommand("/home/pi/Schreibtisch/Workspace/run.out "+ StringModbusSPSInputNachricht, true);
        System.out.println("end Printing \n"+ output);
        if (output.contains("0")){
            throw new IOException("No Networkconnection");
        }        
    }
    
    public String get_StringModbusSPSInputNachricht(){
        return StringModbusSPSInputNachricht;
    }            
}