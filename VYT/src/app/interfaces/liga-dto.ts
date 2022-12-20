export class LigaDTO {
    nombreLiga:string;
    logo:string
    direccion:string
    constructor (nombreLiga:string,direccion:string,logoLiga:string){
        this.nombreLiga=nombreLiga;
        this.direccion=direccion;
        this.logo=logoLiga;
    }
}
