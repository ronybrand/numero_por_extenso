package br.com.rony.spring.boot.numero_por_extenso.resource;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.rony.spring.boot.numero_por_extenso.service.ConvertExtensoService;
import br.com.rony.spring.boot.numero_por_extenso.vo.NumeroPorExtensoVO;

@RestController
@Validated
public class ConvertExtensoResource {
	@Autowired
	private ConvertExtensoService convertExtensoService;

    @GetMapping("/{numero}")
	public NumeroPorExtensoVO getNumeroPorExtenso(
			@Valid @Range(min=-99999, max=99999) @PathVariable(name = "numero") Long numero) {
	      return convertExtensoService.getNumeroPorExtenso(numero.intValue());
   }
}
