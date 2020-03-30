package br.com.rony.spring.boot.numero_por_extenso.util;

import java.math.BigInteger;
import java.util.ArrayList;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Range;

public class ConvertExtenso {

	private ArrayList<Integer> nro;
	private BigInteger num;
	private boolean negativo = false;
	private static final StringBuffer MENOS = new StringBuffer("menos ");
	private static final BigInteger MAXNUMBER = new BigInteger("99999");
	private static final BigInteger MINNUMBER = new BigInteger("-99999");
	private static final String MIL = "mil";
	private static final String Numeros[][] = {
			{ "zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze",
					"treze", "quatorze", "quinze", "desesseis", "desessete", "dezoito", "desenove" },
			{ "vinte", "trinta", "quarenta", "Cinquenta", "Sessenta", "Setenta", "oitenta", "noventa" },
			{ "cem", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "Setecentos",
					"oitocentos", "novecentos" } };

	public ConvertExtenso(Integer inteiro) {
		nro = new ArrayList<Integer>();
		if (inteiro <0) {
			inteiro *= -1; 
			negativo = true;	
		}
		setNumber(BigInteger.valueOf(inteiro));
	}

	private void setNumber(BigInteger bigInteger) {
        if (bigInteger.compareTo(MAXNUMBER) == 1 || bigInteger.compareTo(MINNUMBER) == -1)
        	throw new NumberFormatException(
                    "Números válidos são na faixa de -99999 a 99999.");
        num = bigInteger;
		if (num.equals(BigInteger.ZERO)) {
			// Valor
			nro.add(new Integer(0));
		} else {
			// Adiciona grupos de 1000
			do  {
				addRemainder(1000);
			} while (!num.equals(BigInteger.ZERO));
		}
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		if (negativo) {
			buf.append(MENOS);
		}
		int ct;

		for (ct = nro.size() - 1; ct > 0; ct--) {
			// Se ja existe texto e o atual não é zero
			if (buf.length() > 0 && !ehGrupoZero(ct) && buf.equals(MENOS) ) {
				buf.append(" e ");
			}
			buf.append(numToString(((Integer) nro.get(ct)).intValue(), ct));
		}
		if (buf.length() > 0) {
			while (buf.toString().endsWith(" "))
				buf.setLength(buf.length() - 1);
			if (ehPrimeiroGrupoUm())
				buf.insert(0, "");
			if (((Integer) nro.get(0)).intValue() != 0) {
				buf.append(" e ");
			}
		}
		if (((Integer) nro.get(0)).intValue() != 0) {
			buf.append(numToString(((Integer) nro.get(0)).intValue(), 0));
		}

		if (buf.length() == 0)
			buf.append(Numeros[0][0]);
		return buf.toString().trim();
	}

	private boolean ehPrimeiroGrupoUm() {
		if (((Integer) nro.get(nro.size() - 1)).intValue() == 1)
			return true;
		return false;
	}

	private void addRemainder(int divisor) {
		// Encontra newNum[0] = num modulo divisor, newNum[1] = num dividido divisor
		BigInteger[] newNum = num.divideAndRemainder(BigInteger.valueOf(divisor));
		// Adiciona modulo
		nro.add(new Integer(newNum[1].intValue()));
		// Altera numero
		num = newNum[0];
	}

	boolean ehGrupoZero(int ps) {
		if (ps == nro.size())
			return true;
		return ((Integer) nro.get(ps)).intValue() == 0;
	}

	private String numToString(int numero, int escala) {
		StringBuffer buf = new StringBuffer();
		int unidade = (numero % 10);
		int dezena = (numero % 100); // * nao pode dividir por 10 pois verifica de 0..19
		int centena = (numero / 100);
		boolean ehMil = false;
		if (numero != 0) {
			if (centena != 0) {
				if (dezena == 0 && centena == 1) {
					buf.append(Numeros[2][0]);
				} else {
					buf.append(Numeros[2][centena]);
				}
			}
			if ((buf.length() > 0) && (dezena != 0)) {
				buf.append(" e ");
			}
			if (dezena > 19) {
				dezena /= 10;
				buf.append(Numeros[1][dezena - 2]);
				if (unidade != 0) {
					buf.append(" e ");
					buf.append(Numeros[0][unidade]);
				}
			} else if (centena == 0 || dezena != 0) {
				ehMil = dezena == 1 && escala == 1;
				if (!ehMil) {
					buf.append(Numeros[0][dezena]);
				}
			}
			if (!ehMil) {
				buf.append(" ");
			}
			if (escala == 1) {
				buf.append(MIL);
			}
		}
		return buf.toString();
	}
}
