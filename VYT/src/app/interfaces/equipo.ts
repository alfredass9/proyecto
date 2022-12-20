import { Usuario } from "./Usuario";

export class Equipo {
    id:number
    nombreEquipo:string;
    logoEquipo:string;
    listaJugadores= new Set<Usuario>();
    misPuntos:number;
    constructor(nombreEquipo: string, logo: string) {
        this.nombreEquipo=nombreEquipo;
        this.logoEquipo=logo;
    }
}
