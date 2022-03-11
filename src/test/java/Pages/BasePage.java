package Pages;

import org.openqa.selenium.By;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BasePage {
	
	private DSL dsl = new DSL();
	
	public void inicializar() {
		dsl.inicializar();
		dsl.direcionamento();
	}
	
	public void direcionamentoLogin() {
		dsl.clicar(By.cssSelector("a[class='bui-button bui-button--secondary js-header-login-link']"));
	}
	
	public void fecharBrowser() {
		dsl.quit();
	}
	
	public void informarEmail(String email) {
		dsl.escrever("username", email);
		dsl.clicar(By.cssSelector("button[type='submit']"));		
	}
	
	public void informarSenha(String senha) {
		dsl.escrever("password", senha);
	}
	
	public void clicarParaLogar() {
		dsl.clicar(By.cssSelector("button[type='submit']"));		
	}
	
	public void esperar(int miliseconds) throws InterruptedException {
	Thread.sleep(miliseconds);

	}
	public void localDesejado(String local) throws InterruptedException {
		dsl.escrever("ss", local);
	}
	
	public void clicarCalendario() {
		dsl.clicar(By.cssSelector("div[data-mode='checkin']"));
	}
	
	public void mudarMes() {
		dsl.clicar(By.cssSelector("div[data-bui-ref='calendar-next']"));
		dsl.clicar(By.cssSelector("div[data-bui-ref='calendar-next']"));
		dsl.clicar(By.cssSelector("div[data-bui-ref='calendar-next']"));
		dsl.clicar(By.cssSelector("div[data-bui-ref='calendar-next']"));
		dsl.clicar(By.cssSelector("div[data-bui-ref='calendar-next']"));
		dsl.clicar(By.cssSelector("div[data-bui-ref='calendar-next']"));
	}
	
	public void dataDeEntrada(String ano, String mes, String dia) {
		dsl.clicar(By.xpath("//td[@data-date='"+ano+"-"+mes+"-"+dia+"']"));

	}
	public void dataDeSaida(String ano, String mes, String dia) {
		dsl.clicar(By.xpath("//td[@data-date='"+ano+"-"+mes+"-"+dia+"']"));
	}
	
	public void campoHospedes() {
		dsl.clicar("xp__guests__toggle");
	}
	
	public void adicionarAdulto() {
		dsl.clicar(By.xpath("//button[@aria-label='Aumentar número de Adultos']"));
	}
	
	public void adicionarCrianca() {
		dsl.clicar(By.xpath("//button[@aria-label='Aumentar número de Crianças']"));
		dsl.clicar(By.xpath("//select[@name='age']/option[@value='5']"));	
	}
	
	public void pesquisar() {
		dsl.clicar(By.xpath("//button[@data-sb-id='main']"));
	}
	
	public void selecionarLocal() {
		dsl.clicar(By.xpath("//span[.='Ver disponibilidade']"));
	}
	
	public void reservar() {
		dsl.clicar("hp_book_now_button");
	}
	
	public void trocarJanela() {
		dsl.trocarJanela();
	}
	
	public void confirmarReserva() {
		dsl.clicar(By.cssSelector("button[class='txp-bui-main-pp bui-button bui-button--primary  hp_rt_input js-reservation-button px--fw-cta']"));
	}
	
	public void selecionarAP() {
		dsl.clicar(By.xpath("//select[@class='hprt-nos-select js-hprt-nos-select']/option[@value='1']"));
	}
	
	public void informarNome(String nome) {
		dsl.escrever("firstname", nome);
	}
	
	public void informarSobrenome(String sobrenome) {
		dsl.escrever("lastname", sobrenome);
	}
	
	public void informarCampoEmail (String email) {
		dsl.escrever("email", email);
		dsl.escrever("email_confirm", email);
	}
	
	public void souPrincipalHospede() {
		dsl.clicar(By.cssSelector("div[class='bui-form__group bp-form-group bp-form-group__notstayer_false   ']"));
	}
	
	public void horarioDeChegada() {
		dsl.clicar(By.xpath("//select[@id='checkin_eta_hour']/option[@value='1']"));
	}
	
	public void prosseguirUltimasInformacoes() {
		dsl.clicar(By.cssSelector("button[name='book']"));
	}
	
	public void informarTelefone(String numero) {
		dsl.escrever("phone", numero);
	}
	
	public void concluirReserva() {
		dsl.clicar(By.cssSelector("button[name='book']"));
	}
	
	public void alertaCartaoInvalido(String msg) {
		String alerta = dsl.obterTexto(By.xpath("//div[@class='bui-alert bui-alert--error bui-alert--large bui-u-bleed@small bui-spacer--large']//span[@class='bui-alert__title']"));
		Assert.assertEquals(alerta,	msg);
	}
}