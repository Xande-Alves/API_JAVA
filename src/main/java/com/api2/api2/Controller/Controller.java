/* Caminho do pacote que o arquivo Controller faz parte */
package com.api2.api2.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api2.api2.Models.Buscador;
import com.api2.api2.Models.Ofertador;
import com.api2.api2.Repository.RepositoryBuscador;
import com.api2.api2.Repository.RepositoryOfertador;

/*Notação responsável por informar que esse é o arquivo de controle do projeto*/
@RestController
/* Notação responsável por mapear e nomear os aquivos */
@RequestMapping("/")
public class Controller {
    /*
     * @Autowired notação responsável por injetar depêndencias (Fazer o trabalho de
     * um construtor)
     */
    @Autowired
    RepositoryBuscador repositoryBuscador;
    @Autowired
    /* Comando java para utilizar uma classe existente */
    RepositoryOfertador repositoryOfertador;

    /*
     * @PostMapping responsável por informar que será usado o método POST e mapear o
     * caminho neste caso /CadastrarProfessor
     */
    /* EndPoint responsável por salvar no banco de dados um buscador */
    @PostMapping(value = "cadastrar-buscador")
    public ResponseEntity<Buscador> cadastrar(@RequestBody Buscador buscador) {
        // Clear ID to force insert and avoid stale entity merge
        buscador.setId(null);
        Buscador resposta = repositoryBuscador.save(buscador); 

        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    /* EndPoint responsável por salvar no banco de dados um ofertador */
    @PostMapping(value = "cadastrar-ofertador")
    public ResponseEntity<Ofertador> cadastrar(@RequestBody Ofertador ofertador) {
        // Clear ID to force insert and avoid stale entity merge
        ofertador.setId(null);
        Ofertador resposta = repositoryOfertador.save(ofertador);

        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    /*
     * EndPoint responsável por listar os Buscadores cadastrados utilizando o
     * método
     * GET
     */
    @GetMapping(value = "listar-buscador")
    public List<Buscador> listaBuscador() {
        return repositoryBuscador.findAll();
    }

     /*
     * EndPoint responsável por listar os Buscadores cadastrados utilizando o
     * método
     * GET
     */
    @GetMapping(value = "listar-ofertador")
    public List<Ofertador> listaOfertador() {
        return repositoryOfertador.findAll();
    }

    /*
     * EndPoint responsável por Deletar um buscador cadastrado utilizando o método
     * Delete
     */

    @DeleteMapping("deletar-buscador/{id}")
    public ResponseEntity<Long> deletarBuscador(@PathVariable Long id) {
        boolean busc = repositoryBuscador.existsById(id);
        if (busc) {
            repositoryBuscador.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

    /*
     * EndPoint responsável por Deletar um ofertador cadastrado utilizando o método
     * Delete
     */

    @DeleteMapping("deletar-ofertador/{id}")
    public ResponseEntity<Long> deletarOfertador(@PathVariable Long id) {
        boolean ofert = repositoryOfertador.existsById(id);
        if (ofert) {
            repositoryOfertador.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

    /* EndPoint responsável atualizar buscador */

    @PutMapping("atualizar-buscador/{id}")
    public ResponseEntity<Buscador> atualizarBuscador(@PathVariable Long id,
            @RequestBody Buscador buscador) {
        Optional<Buscador> existeBuscador = repositoryBuscador.findById(id);

        if (existeBuscador.isPresent()) {
            Buscador atualizaBuscador = existeBuscador.get();
            atualizaBuscador.setNome(buscador.getNome());
            atualizaBuscador.setSobrenome(buscador.getSobrenome());
            atualizaBuscador.setDataNascimento(buscador.getDataNascimento());
            atualizaBuscador.setEmail(buscador.getEmail());
            atualizaBuscador.setTelefone(buscador.getTelefone());
            atualizaBuscador.setSenha(buscador.getSenha());
            repositoryBuscador.save(atualizaBuscador);
            return new ResponseEntity<>(atualizaBuscador, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /* EndPoint responsável atualizar ofertador */

    @PutMapping("atualizar-ofertador/{id}")
    public ResponseEntity<Ofertador> atualizarOfertador(@PathVariable Long id,
            @RequestBody Ofertador ofertador) {
        Optional<Ofertador> existeOfertador = repositoryOfertador.findById(id);

        if (existeOfertador.isPresent()) {
            Ofertador atualizaOfertador = existeOfertador.get();
            atualizaOfertador.setNome(ofertador.getNome());
            atualizaOfertador.setLogradouro(ofertador.getLogradouro());
            atualizaOfertador.setNumero(ofertador.getNumero());
            atualizaOfertador.setComplemento(ofertador.getComplemento());
            atualizaOfertador.setBairro(ofertador.getBairro());
            atualizaOfertador.setCidade(ofertador.getCidade());
            atualizaOfertador.setEstado(ofertador.getEstado());
            atualizaOfertador.setEmail(ofertador.getEmail());
            atualizaOfertador.setTelefone(ofertador.getTelefone());
            atualizaOfertador.setSenha(ofertador.getSenha());
            repositoryOfertador.save(atualizaOfertador);
            return new ResponseEntity<>(atualizaOfertador, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    

}


