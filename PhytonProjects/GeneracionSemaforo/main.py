import random
import datetime
import time
class Genera:
    id = 1
    datosMin = 50
    datosMax = 210
    prioriMin = 1
    prioriMax = 3
    sleepPeatonal = 1
    sleepVehiculos = 4
    sleepCiclista = 4
    lista = []
    listaAuto = []
    listaCicli = []
    listaPea = []

    def Hora(self):
        horaactual = datetime.datetime.now()
        auxiliar = ""+str(horaactual.hour).zfill(2)+":"+str(horaactual.minute).zfill(2)+":"+str(horaactual.second).zfill(2)
        return auxiliar

    def Tipo(self,priori):
        if(priori==1):
             auxiliar = "PEATON   "
        else:
            if(priori==2):
                auxiliar = "CICLISTA "
            else:
                auxiliar = "AUTOMOVIL"
        return auxiliar

    def Agregar(self,datos):
        for n in range(datos):
            aux = "|"+str(self.id).zfill(3)+"|"
            aux = aux + str(self.Hora())+"|"
            priori = random.randint(self.prioriMin,self.prioriMax)
            aux = aux + str(priori).zfill(1)
            aux = aux + "|"+str(random.randint(1,5))
            aux = aux + "|"+self.Tipo(priori)+"|\n"
            self.id = self.id+1
            with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivo.dat","a") as archivo:
                archivo.write(aux)
                self.lista.append(aux)
            archivo.close()
            time.sleep(random.randint(1,4))

    def Crear(self):
        datos = random.randint(self.datosMin,self.datosMax)
        with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivo.dat","w") as archivo:
            archivo.write("|_ID|HO_LLEGA|P|T|T_TRAFICO|\n")
            archivo.close()
        self.Agregar(datos)

    def Procesar(self):
        with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivoPetaon.dat","w") as archivo:
            archivo.write("|_ID|HO_LLEGA|P|TIME_P|T_TRAFICO|\n")
        archivo.close()
        with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivoCiclista.dat","w") as archivo:
            archivo.write("|_ID|HO_LLEGA|P|TIME_P|T_TRAFICO|\n")
        archivo.close()
        with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivoAuto.dat","w") as archivo:
            archivo.write("|_ID|HO_LLEGA|P|TIME_P|T_TRAFICO|\n")
        archivo.close()
        with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivo.dat","r") as archivo:
            linea = archivo.__next__()
            for linea in archivo:
                array = linea.split("|")
                if(array[3]=="1"):
                    with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivoPetaon.dat","a") as archivo:
                        archivo.write(linea)
                        self.listaPea.append(linea)
                    archivo.close()
                if(array[3]=="2"):
                    with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivoCiclista.dat","a") as archivo:
                        archivo.write(linea)
                        self.listaCicli.append(linea)
                    archivo.close()
                if(array[3]=="3"):
                    with open("C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\GeneracionSemaforo\\archivoAuto.dat","a") as archivo:
                        archivo.write(linea)
                        self.listaAuto.append(linea)
                    archivo.close()  

genera = Genera()
genera.Crear()
genera.Procesar()
