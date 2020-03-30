package br.com.rony.spring.boot.numero_por_extenso.service;

import org.springframework.stereotype.Service;

import br.com.rony.spring.boot.numero_por_extenso.domain.NumeroPorExtenso;
import br.com.rony.spring.boot.numero_por_extenso.util.ConvertExtenso;
@Service
public class ConvertExtensoService {

	public NumeroPorExtenso getNumeroPorExtenso(int numero) {
		ConvertExtenso convertExtenso = new ConvertExtenso(numero);
		NumeroPorExtenso numeroPorExtenso = new NumeroPorExtenso();
		numeroPorExtenso.setExtenso(convertExtenso.toString());
		return numeroPorExtenso;
	}
}
