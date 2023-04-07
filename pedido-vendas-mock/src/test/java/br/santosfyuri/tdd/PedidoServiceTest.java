package br.santosfyuri.tdd;

import br.santosfyuri.tdd.email.NotificadorEmail;
import br.santosfyuri.tdd.model.Pedido;
import br.santosfyuri.tdd.model.StatusPedido;
import br.santosfyuri.tdd.model.builder.PedidoBuilder;
import br.santosfyuri.tdd.repository.Pedidos;
import br.santosfyuri.tdd.service.AcaoLancamentoPedido;
import br.santosfyuri.tdd.service.PedidoService;
import br.santosfyuri.tdd.service.StatusPedidoInvalidoException;
import br.santosfyuri.tdd.sms.NotificadorSms;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PedidoServiceTest {

    private Pedido pedido;
    private PedidoService pedidoService;

    @Mock
    private Pedidos pedidos;
    @Mock
    private NotificadorEmail notificadorEmail;
    @Mock
    private NotificadorSms notificadorSms;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        List<AcaoLancamentoPedido> acoes = Arrays.asList(pedidos, notificadorEmail, notificadorSms);
        pedidoService = new PedidoService(pedidos, acoes);
        pedido = new PedidoBuilder()
                .valor(100.0)
                .cliente("João", "joao@email.com", "(99) 99999-9999")
                .construir();
    }

    @Test
    public void deveCalcularOImposto() {
        double imposto = pedidoService.lancar(pedido);
        assertEquals(10.0, imposto, 0.0001);
    }

    @Test
    public void deveSalvarPedidoNoBancoDeDados() {
        pedidoService.lancar(pedido);
        verify(pedidos).executar(pedido);
    }

    @Test
    public void deveNotificarPorEmail() {
        pedidoService.lancar(pedido);
        verify(notificadorEmail).executar(pedido);
    }

    @Test
    public void deveNotificarPorSms() {
        pedidoService.lancar(pedido);
        verify(notificadorSms).executar(pedido);
    }

    @Test
    public void devePagarPedidoPendente() {
        Long codigoPedido = 135L;
        Pedido pedidoPendente = new PedidoBuilder().status(StatusPedido.PENDENTE).construir();
        when(pedidos.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPendente);

        Pedido pedidoPago = pedidoService.pagar(codigoPedido);
        assertEquals(StatusPedido.PAGO, pedidoPago.getStatus());
    }

    @Test(expected = StatusPedidoInvalidoException.class)
    public void deveNegarPagamento() {
        Long codigoPedido = 135L;
        Pedido pedidoPendente = new PedidoBuilder().status(StatusPedido.PAGO).construir();
        when(pedidos.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPendente);

        pedidoService.pagar(codigoPedido);
    }
}
