package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingresso {
		
		@Id
		@GeneratedValue
		private Integer id;
		
		@ManyToOne
		private Sessao sessao;
		
		@ManyToOne
		private Lugar lugar;
		
		private BigDecimal preco;
		
		@Enumerated(EnumType.STRING)
		private TipoDeIngresso tipoDeIngresso;
		
		/**
		 * @deprecated
		 */
		public Ingresso(){
			
		}
		
		public Ingresso(Sessao sessao, TipoDeIngresso tipoDeIngresso, Lugar lugar){
			this.sessao = sessao;
			this.setTipoDeIngresso(tipoDeIngresso);
			this.preco = tipoDeIngresso.aplicaDesconto(sessao.getPreco());
			this.lugar = lugar;
		}
		public Lugar getLugar() {
			return lugar;
		}

		public void setLugar(Lugar lugar) {
			this.lugar = lugar;
		}

		public void setSessao(Sessao sessao) {
			this.sessao = sessao;
		}

		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}

		public Sessao getSessao(){
			return sessao;
		}
		
		public BigDecimal getPreco(){
			return preco;
		}

		public TipoDeIngresso getTipoDeIngresso() {
			return tipoDeIngresso;
		}

		public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
			this.tipoDeIngresso = tipoDeIngresso;
		}
}
