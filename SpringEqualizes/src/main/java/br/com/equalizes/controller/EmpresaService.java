package br.com.equalizes.controller;

import br.com.equalizes.model.Empresa;
import br.com.equalizes.repository.EmpresaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class EmpresaService {

	private final EmpresaRepository empresaRepository;

	/**
	 * @param empresaRepository
	 */
	public EmpresaService(final EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	public List<Empresa> getEmpresas() {
		return empresaRepository.findAll();
	}

	public void addEmpresa(final Empresa empresa) {
		if (empresaRepository.findEmpresabyCnpj(empresa.getCnpj()).isPresent()) {
			throw new IllegalStateException("cnpj existe");
		}
		empresaRepository.save(empresa);
	}

	public void deleteEmpresa(final Long id) {
		if (!empresaRepository.existsById(id)) {
			throw new IllegalStateException("empresaId:" + id + "nao existe");
		}
		empresaRepository.deleteById(id);
	}

	@Transactional
	public void updateEmpresa(final Long empresaId, final String email, final Long telefone) {
		final Empresa empresa = empresaRepository.findById(empresaId)
				.orElseThrow(() -> new IllegalStateException("empresaId:" + empresaId + "nao existe"));
		if (!email.isEmpty() && email.length() > 0 && !Objects.equals(empresa.getEmail(), email)) {
			empresa.setEmail(email);
		} else if (telefone != null && !Objects.equals(empresa.getTelefone(), telefone)) {
			empresa.setTelefone(telefone);
		}
		// Talvez de ruim
		empresaRepository.save(empresa);
	}

}
