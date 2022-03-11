package Steps;

import Pages.BasePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class locacaoStep {
	

	private BasePage page = new BasePage();

	
	@Dado("que me direciono ao site Booking")
	public void que_me_direciono_ao_site_booking() {
		page.inicializar();
	}

	@Quando("seleciono local, dia e hospedes")
	public void seleciono_local_dia_e_hospedes() throws InterruptedException {
		page.localDesejado("Santos");
		page.clicarCalendario();
		page.esperar(3000);
		page.mudarMes();
		page.dataDeEntrada("2022", "10", "15");
		page.dataDeSaida("2022", "10", "25");
		page.campoHospedes();
		page.adicionarAdulto();
		page.adicionarCrianca();
	}

	@E("seleciono o campo pesquisar")
	public void seleciono_o_campo_pesquisar() {
	   page.pesquisar();
	}

	@Quando("seleciono a locacao")
	public void seleciono_a_locacao() throws InterruptedException {
		page.selecionarLocal();
		page.esperar(5000);
		page.trocarJanela();
	}

	@E("seleciono a quantidade de apartamentos")
	public void seleciono_a_quantidade_de_apartamentos() {
		page.selecionarAP();
	}

	@E("seleciono reservar")
	public void seleciono_reservar() {
		page.confirmarReserva();
	}

	@Quando("informo os dados pessoais obrigatorios")
	public void informo_os_dados_pessoais_obrigatorios() {
	   page.informarNome("Ze");
	   page.informarSobrenome("Ruela");
	   page.informarCampoEmail("zeruela@gmail.com");
	   page.souPrincipalHospede();
	   page.horarioDeChegada();
	   page.prosseguirUltimasInformacoes();
	}

	@E("me direciono a pagina de confirmacao de reserva e concluo a reserva")
	public void me_direciono_a_pagina_de_confirmacao_de_reserva_e_concluo_a_reserva() {
	   page.informarTelefone("11999999999");
	   page.concluirReserva();
	}

	@Entao("recebo a mensagem de erro de pagamento")
	public void recebo_a_mensagem_de_erro_de_pagamento() {
		page.alertaCartaoInvalido("Opa! Parece que você só esqueceu uma coisinha... Por favor, preencha os campos que ficaram faltando para continuar:");
	}
	
}
