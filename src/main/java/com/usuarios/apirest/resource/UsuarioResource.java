package com.usuarios.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.apirest.model.Usuario;
import com.usuarios.apirest.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Usuários")
@CrossOrigin(origins="*")
public class UsuarioResource {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	@ApiOperation(value="Retorna uma lista de usuários")
	public List<Usuario> listaUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	@ApiOperation(value="Retorna um único usuário")
	public Usuario ListaUnicoUsuario(@PathVariable(value="id") long id){
		return usuarioRepository.findById(id);
	}
	
	@PostMapping("/usuario/salvar")
	@ApiOperation(value="Salva um usuário")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario SalvaUsuario(@RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/usuario/delete/{id}")
	@ApiOperation(value="Deleta um usuário")
	public void DeletaUsuario(@RequestBody Usuario usuario){
		usuarioRepository.delete(usuario);
	}
	
	@PutMapping("/usuario/atualiza/{id}")
	@ApiOperation(value="Atualiza um usuário")
	public Usuario AtualizaUsuario(@RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}
}
