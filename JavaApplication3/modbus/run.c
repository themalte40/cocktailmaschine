/*
        Malte Mechtenberg
        23.11.2014

        Communikationsbuastein_modbus TCP
                Server: SPS NAnoline
 */


//Biblioteken
#include<modbus.h> // www.libmodbus.org
#include<stdio.h>
#include<stdint.h>

//Konstantendeklaration
#define TRUE  1
#define FALSE 0

//Funktionen
int link(char [15]);
int rh_reg(int);
int wh_reg(int, int);

//Globale Variablen und  Zeiger
modbus_t *ctx;

//main Funktion zu testzwecken

int main(int argc, char* argv[]) {
    //printf("%i  \n", argc);
    //printf("%s \n",argv[1]);
    int run;
    run = link("192.168.0.8");

    if (run != FALSE) {

        int i;
        int iIn;

        for (i = 1; i < argc - 1; i++) {
            sscanf(argv[i], "%i", &iIn);
            wh_reg((i - 1), iIn);
        }
        while(rh_reg(28)!=0){i=0;}
        return FALSE;
    }
    return TRUE;
}


// Funktion zum verbindungsaufbau mit Modbusserver festgesetzter Port 502

int link(char ip[15]) {

    int stat;
    ctx = modbus_new_tcp(ip, 502);
    stat = modbus_connect(ctx);
    if (stat == -1) {
        //fprintf(stderr, "Connection faild\n");
        printf("0");
        modbus_free(ctx);
        return FALSE;
    }

    //printf("Connection astablished\n");
    printf("1");
    return TRUE;
}

//returns holding  Registervalue

int rh_reg(int adr) {
    int rc;
    uint16_t tab_reg[64];
    int i;

    rc = modbus_read_registers(ctx, adr, 10, tab_reg);

    if (rc == -1) { 
        return FALSE;
    }

    return tab_reg[0];
}

// sets value of holding Register

int wh_reg(int reg, int value) {
    int stat;
    int adr;

    //writing positive 32 bit value du selectet Regeister
    if (0 <= value && value <= 32767) {
        //printf("größer 0\n");
        adr = 2 * reg;
        stat = modbus_write_register(ctx, adr, value);
        stat = modbus_write_register(ctx, adr + 1, 0);
    }
    //writing negative 32 bit value du selectet Regeister
    if (-32757 <= value && value < 0) {
        //printf("kelienr 0\n");
        adr = 2 * reg;
        stat = modbus_write_register(ctx, adr, value);
        adr++;
        stat = modbus_write_register(ctx, adr, -1);
    }
    return stat;
}