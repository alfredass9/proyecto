import { Equipo } from "./equipo";

export class Liga {
    id:number
    nombreLiga:string;
    logo:string;
    direccion:string;
    listaEquipos=new Array<Equipo>();
    listaJornadas=new Set();
    constructor (nombreLiga:string,direccion:string,logoLiga:string){
        this.nombreLiga=nombreLiga;
        this.direccion=direccion;
        this.logo=logoLiga;
    }
}
