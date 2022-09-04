package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.modelo.DocumentoAtualizador;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

@RestController
@RequestMapping("/documento")
public class DocumentoControle {
	
	@Autowired
	private DocumentoRepositorio repositorio;
	
	@GetMapping("/documentos")
	public List<Documento> buscarDocumentos(){
		return repositorio.findAll();
	}
	
	@GetMapping("/documento/{id}")
	public Documento buscarDocumentoPorId(@PathVariable Long id) {
		return repositorio.findById(id).get();
	}
	
	@PutMapping("/atualizar")
	public void editarDocumentoPorId(@RequestBody Documento atualizacao) {
		Documento documentoSelecionado = repositorio.getById(atualizacao.getId());
		DocumentoAtualizador atualizador = new DocumentoAtualizador();
		atualizador.atualizar(documentoSelecionado, atualizacao);
		repositorio.save(documentoSelecionado);
	}
	
	
}
