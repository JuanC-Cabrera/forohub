package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topico.*;
import com.aluracursos.forohub.infra.errores.ValidacionDeIntegridad;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    public TopicoRepository topicoRepository;
    public TopicoService topicoService;

    @Autowired
    public TopicoController(TopicoService topicoService, TopicoRepository topicoRepository) {
        this.topicoService = topicoService;
        this.topicoRepository = topicoRepository;
    }

    @PostMapping()
    public ResponseEntity<DatosRespuestaTopicos> crearTopico(@RequestBody(required = false) @Valid DatosRegistroTopico datosRegistroTopico,
                                                             UriComponentsBuilder uriComponentsBuilder) {
        if (datosRegistroTopico == null) {
            throw new ValidacionDeIntegridad("No se envió ningún dato en la solicitud.");
        }

        topicoService.validarTopicoExistente(datosRegistroTopico);

        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopicos datosRespuestaTopicos = new DatosRespuestaTopicos(topico);
        URI url = uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopicos);

    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopicos>> listadoTopicos(@PageableDefault() Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosRespuestaTopicos::new));
    }

    @GetMapping("/ordenados")
    public ResponseEntity<Page<DatosRespuestaTopicos>> listarTopicosOrdenadosPorFecha(
            @PageableDefault(sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosRespuestaTopicos::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTopicoPorId(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            DatosRespuestaTopicos datosRespuestaTopicos = new DatosRespuestaTopicos(topico);
            return ResponseEntity.ok(datosRespuestaTopicos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopicos> actualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            topico.actualizarDatos(datosActualizarTopico);
            Topico topicoActualizado = topicoRepository.save(topico);
            DatosRespuestaTopicos datosRespuestaTopicos = new DatosRespuestaTopicos(topicoActualizado);

            return ResponseEntity.ok(datosRespuestaTopicos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

