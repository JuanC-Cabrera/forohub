package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topico.DatosRegistroTopico;
import com.aluracursos.forohub.domain.topico.DatosRespuestaTopicos;
import com.aluracursos.forohub.domain.topico.Topico;
import com.aluracursos.forohub.domain.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    public TopicoRepository topicoRepository;

    @PostMapping()
    public ResponseEntity<DatosRespuestaTopicos> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                 UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopicos datosRespuestaTopicos = new DatosRespuestaTopicos(topico);
        URI url = uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopicos);

    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopicos>> listadoTopicos(@PageableDefault(size=10) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosRespuestaTopicos::new));
    }

    @GetMapping("/ordenados")
    public ResponseEntity<Page<DatosRespuestaTopicos>> listarTopicosOrdenadosPorFecha(
            @PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable paginacion) {
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

}

