@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PedidoProducer producer;

    public Pedido criarPedido(Pedido pedido) {
        Pedido novoPedido = repository.save(pedido);

        // Enviar mensagem para o Kafka após criar o pedido
        String mensagem = "Pedido criado com ID: " + novoPedido.getId() + " afeta o estoque.";
        producer.enviarMensagem(mensagem);

        return novoPedido;
    }
}


