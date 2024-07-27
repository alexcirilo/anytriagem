package br.com.anydev.anytriagem.service;

import br.com.anydev.anytriagem.model.dto.MedicoDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    public MedicoDto save(MedicoDto medicoDto) {
        return medicoDto;
    }
}
