package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.services.exceptions.DataIntegrityException;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Cliente find(Integer id) {
        Optional<Cliente> Cliente = repository.findById(id);
        return Cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Cliente findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Transactional
    public Cliente insert(Cliente cliente) {
        cliente.setSenha(encoder.encode(cliente.getSenha()));
        Cliente clienteSaved = repository.save(cliente);
        enderecoRepository.saveAll(cliente.getEnderecos());
        return clienteSaved;
    }

    public Cliente update(Cliente cliente) {
        Cliente clienteToSave = find(cliente.getId());
        updateCliente(clienteToSave, cliente);
        return repository.save(clienteToSave);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
        }
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    private void updateCliente(Cliente clienteToSave, Cliente clienteChanged) {
        clienteToSave.setNome(clienteChanged.getNome());
        clienteToSave.setEmail(clienteChanged.getEmail());
    }
    
}
