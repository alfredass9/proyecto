export class NuevoUsuario{
    name:string;
    nombreUsuario:string;
    email:string;
    password:string;
    imageUrl:string;
    posicion:string;

        constructor( name:string,nombreUsuario:string,email:string,password:string,imageUrl:string,posicion:string){
            this.name=name;
            this.nombreUsuario=nombreUsuario;
            this.email=email;
            this.password=password;
            this.imageUrl=imageUrl;
            this.posicion=posicion;
        }
}