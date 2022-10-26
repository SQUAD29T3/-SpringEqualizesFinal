package com.exemplo.teste.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

	private final EmpresaService empresaService;

	/**
	 * @param empresaService
	 */
	@Autowired
	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	@GetMapping
	public List<Empresa> getEmpresas() {
		return empresaService.getEmpresas();
	}

	@PostMapping
	public void newEmpresa(@RequestBody Empresa empresa) {
		empresaService.addEmpresa(empresa);
	}

	@DeleteMapping(path = "{empresaId}")
	public void deleteEmpresa(@PathVariable("empresaId") Long id) {
		empresaService.deleteEmpresa(id);
	}

	@PutMapping(path = "{empresaId}")
	public void updateEmpresa(@PathVariable("empresaId") Long empresaId, @RequestParam(required = false) String email,
			@RequestParam(required = false) Long telefone) {
		empresaService.updateEmpresa(empresaId, email, telefone);
	}
}
