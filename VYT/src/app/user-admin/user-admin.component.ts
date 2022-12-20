import { Component, OnInit } from '@angular/core';
import { Usuario } from '../interfaces/Usuario'; 
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { UsuarioService } from '../services/usuario.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['./user-admin.component.css']
})
export class UserAdminComponent implements OnInit {

  
  public usuarios: Usuario[];
  public editUsuario:Usuario;
  public deleteUsuario:Usuario;
  constructor(private usuarioService: UsuarioService) { }
  ngOnInit(): void {
    this.getUsuarios();
  }
  public getUsuarios():void{
    this.usuarioService.getUser().subscribe(
      (response: Usuario[])=>{
        this.usuarios=response;
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }
  public onOpenModal(usuario:Usuario|null,mode:string):void{
    const container =document.getElementById('mainContainer');
    const button=document.createElement("button");
    button.type='button';
    button.style.display='none';
    button.setAttribute('data-toggle','modal');
    if(mode==='add'){
      button.setAttribute('data-target','#addUsuarioModal');
    }
    if(mode==='edit'&& usuario!=null){
      this.editUsuario=usuario;
      button.setAttribute('data-target','#updateUsuaurioModal');
    }
    if(mode==='delete'&& usuario!=null){
      this.deleteUsuario=usuario;
      button.setAttribute('data-target','#deleteUsuarioModal');
    }
    container?.appendChild(button);
    button.click();

  }
  public onaddUsuario(addForm:NgForm):void{
    document.getElementById('add-Usuario-form')?.click();
    this.usuarioService.addUsuario(addForm.value).subscribe(
      (response: Usuario)=>{
        console.log(response);
        this.getUsuarios();
        addForm.reset();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    );
  }
  public onUpdateEmloyee(usuario :Usuario):void{
    document.getElementById('edit-Usuario-form')?.click();
    this.usuarioService.updateUsuario(usuario).subscribe(
      (response: Usuario)=>{
        console.log(response);
        this.getUsuarios();
       
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
       console.log(usuario);
      }
    );
  }
  public onDeleteUsurio(UsuarioId:number):void{
    document.getElementById('edit-Usuario-form')?.click();
    this.usuarioService.deleteUsuario(UsuarioId).subscribe(
      (response: void)=>{
        console.log(response);
        this.getUsuarios();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }
}
/*Liga miliga=ligaService.findById(ligaID).get();
        List<Partidos> mispartidos=new ArrayList<>();
        List<Equipo> misEQuipo=miliga.getListaEquipos();
        if(misEQuipo.isEmpty()){
            return new ResponseEntity<>(miliga,HttpStatus.BAD_REQUEST);
        }
        if (misEQuipo.size() % 2 != 0) {
            misEQuipo.add(new Equipo());
        }
        int jornadas=misEQuipo.size()-1;
        List<Jornada> misJornadas=new ArrayList<>();
        for(int round=0;round<jornadas;round++){
            for(int i = 0; i < misEQuipo.size() / 2; i++){
                Equipo local=misEQuipo.get(i);
                Equipo visitante=misEQuipo.get(misEQuipo.size()-i-1);
                Partidos partidos= new Partidos(local,visitante);
                mispartidos.add(partidos);
            }
        }
        misJornadas.*/