package br.com.rony.spring.boot.numero_por_extenso.service;

import org.springframework.stereotype.Service;

import br.com.rony.spring.boot.numero_por_extenso.util.ConvertExtenso;
import br.com.rony.spring.boot.numero_por_extenso.vo.NumeroPorExtensoVO;
@Service
public class ConvertExtensoService {

	public NumeroPorExtensoVO getNumeroPorExtenso(int numero) {
		ConvertExtenso convertExtenso = new ConvertExtenso(numero);
		NumeroPorExtensoVO numeroPorExtenso = new NumeroPorExtensoVO();
		numeroPorExtenso.setExtenso(convertExtenso.toString());
		return numeroPorExtenso;
	}
}
